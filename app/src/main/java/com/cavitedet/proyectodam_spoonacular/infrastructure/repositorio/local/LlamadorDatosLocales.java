package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;

import android.content.Context;

import androidx.room.Room;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.IFuenteDeDatos;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.MetaInfoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import java.util.List;
import java.util.stream.Collectors;

public class LlamadorDatosLocales implements IFuenteDeDatos {

    private static LlamadorDatosLocales instance;
    private LocalDatabase database;


    public LlamadorDatosLocales(LocalDatabase database) {
        this.database = database;
    }

    public static LlamadorDatosLocales getInstance(Context context) {
        if (instance != null) {
            instance = new LlamadorDatosLocales(
                    Room.databaseBuilder(context,
                            LocalDatabase.class, RoomConstantes.BASEDEDATOS_NOMBRE)
                            .allowMainThreadQueries().build()
            );
        }
        return instance;
    }

    public void limpiar() {
        if (instance != null)
            instance.database.close();
        instance = null;
    }

    public void insertarIngrediente(IngredienteDetallado ingredienteDetalladoDominio) {

        if (ingredienteDetalladoDominio == null)
            return;
        getIngredientesDao().insertarIngrediente(new IngredienteDetalladoRoomDto(ingredienteDetalladoDominio));
        int ingId = ingredienteDetalladoDominio.getId();

        insertarListas(ingredienteDetalladoDominio, ingId);

    }

    @Override
    public Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda) throws Exception {
        return null;
        //TODO hacer antes de push
    }

    @Override
    public IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws Exception {
        IngredienteDetalladoRoomDto ingDetalladoDto = getIngredientesDao().getIngrediente(id);
        if (ingDetalladoDto == null) return null;

        leerListas(id, ingDetalladoDto);

        return ingDetalladoDto.aDominio();
    }

    private void insertarListas(IngredienteDetallado dominio, int ingId) {

        if (dominio.getNutricion() != null) {
            for (Nutriente nutriente : dominio.getNutricion().getNutrientes()) {
                NutrienteRoomDto nutrienteDto = new NutrienteRoomDto(nutriente);
                nutrienteDto.setIdDetalles(dominio.getId());
                getIngredientesDao().insertarNutriente(nutrienteDto);
            }

            for (Propiedad propiedad : dominio.getNutricion().getPropiedades()) {
                PropiedadRoomDto propiedadDto = new PropiedadRoomDto(propiedad);
                propiedadDto.setIdDetalles(dominio.getId());
                getIngredientesDao().insertarPropiedad(propiedadDto);
            }
        }

        for (String camino : dominio.getCaminoDeCategorias()) {
            CaminoCategoriasRoomDto camDto = new CaminoCategoriasRoomDto(ingId, camino);
            getIngredientesDao().insertarCaminoCategoria(camDto);
        }

        for (String posUnid : dominio.getPosiblesUnidades()) {
            PosiblesUnidadesRoomDto posUnidDto = new PosiblesUnidadesRoomDto(ingId, posUnid);
            getIngredientesDao().insertarPosibleUnidad(posUnidDto);
        }

        for (String tipoUnid : dominio.getTiposDeUnidadesAlCobrar()) {
            TipoUnidadesAlCobrarRoomDto tipoUnidadCob = new TipoUnidadesAlCobrarRoomDto(ingId, tipoUnid);
            getIngredientesDao().insertarUnidadCobrar(tipoUnidadCob);
        }

        for (String metaInfo : dominio.getMetaInformacion()) {
            MetaInfoRoomDto metaInfoDto = new MetaInfoRoomDto(ingId, metaInfo);
            getIngredientesDao().insertarMetainfo(metaInfoDto);
        }
    }

    private void leerListas(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto) {
        List<CaminoCategoriasRoomDto> categoriasDto = getIngredientesDao().getCategorias(id);
        List<String> categorias = categoriasDto.parallelStream().map(CaminoCategoriasRoomDto::getCategoria).collect(Collectors.toList());
        ingDetalladoDto.setCaminoDeCategorias(categorias);

        List<PosiblesUnidadesRoomDto> unidadesDto = getIngredientesDao().getPosiblesUnidades(id);
        List<String> unidades = unidadesDto.parallelStream().map(PosiblesUnidadesRoomDto::getUnidad).collect(Collectors.toList());
        ingDetalladoDto.setPosiblesUnidades(unidades);

        List<TipoUnidadesAlCobrarRoomDto> tiposDto = getIngredientesDao().getUnidadesCobrar(id);
        List<String> tipos = tiposDto.parallelStream().map(TipoUnidadesAlCobrarRoomDto::getTipo).collect(Collectors.toList());
        ingDetalladoDto.setTiposDeUnidadesAlCobrar(tipos);

        List<MetaInfoRoomDto> metaInfoDto = getIngredientesDao().getMetaInfo(id);
        List<String> metaInfo = metaInfoDto.parallelStream().map(MetaInfoRoomDto::getInfo).collect(Collectors.toList());
        ingDetalladoDto.setMetaInformacion(metaInfo);


        if (ingDetalladoDto.getNutricion() == null) return;
        List<NutrienteRoomDto> nutrientes = getIngredientesDao().getNutrientes(id);
        ingDetalladoDto.getNutricion().setNutrientes(nutrientes);

        List<PropiedadRoomDto> propiedades = getIngredientesDao().getPropiedades(id);
        ingDetalladoDto.getNutricion().setPropiedades(propiedades);
    }

    private IngredientesDao getIngredientesDao() {
        return database.ingredientesDao();
    }


}
