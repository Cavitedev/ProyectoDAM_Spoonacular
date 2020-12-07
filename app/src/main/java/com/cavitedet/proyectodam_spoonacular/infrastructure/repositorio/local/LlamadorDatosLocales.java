package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;

import android.content.Context;

import androidx.room.Room;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.IFuenteDeDatos;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
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

    @Override
    public Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda) throws Exception {
        return null;
        //TODO hacer antes de push
    }

    @Override
    public IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws Exception {
        IngredienteDetalladoRoomDto ingDetalladoDto = getIngredientesDao().getIngrediente(id);
        if (ingDetalladoDto == null) return null;

        anadirListas(id, ingDetalladoDto);

        return ingDetalladoDto.aDominio();
    }

    private void anadirListas(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto) {
        List<CaminoCategoriasRoomDto> categoriasDto = getIngredientesDao().getCategorias(id);
        List<String> categorias = categoriasDto.parallelStream().map(CaminoCategoriasRoomDto::getCategoria).collect(Collectors.toList());
        ingDetalladoDto.setCaminoDeCategorias(categorias);

        List<PosiblesUnidadesRoomDto> unidadesDto = getIngredientesDao().getPosiblesUnidades(id);
        List<String> unidades = unidadesDto.parallelStream().map(PosiblesUnidadesRoomDto::getUnidad).collect(Collectors.toList());
        ingDetalladoDto.setPosiblesUnidades(unidades);

        List<TipoUnidadesAlCobrarRoomDto> tiposDto = getIngredientesDao().getUnidadesCobrar(id);
        List<String> tipos = tiposDto.parallelStream().map(TipoUnidadesAlCobrarRoomDto::getTipo).collect(Collectors.toList());
        ingDetalladoDto.setTiposDeUnidadesAlCobrar(tipos);
    }

    private IngredientesDao getIngredientesDao() {
        return database.ingredientesDao();
    }
}
