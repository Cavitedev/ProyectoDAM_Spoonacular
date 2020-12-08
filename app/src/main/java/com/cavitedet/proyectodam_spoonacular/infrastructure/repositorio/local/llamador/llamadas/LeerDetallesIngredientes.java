package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.llamadas;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.MetaInfoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import java.util.List;
import java.util.stream.Collectors;

public class LeerDetallesIngredientes extends InsertarIngredientes {

    public static void leerListas(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        leerCaminoCategorias(id, ingDetalladoDto, dao);

        leerPosiblesUnidadesMedida(id, ingDetalladoDto, dao);

        leerUnidadesCobrar(id, ingDetalladoDto, dao);

        leerMetaInfo(id, ingDetalladoDto, dao);

        leerNutricion(id, ingDetalladoDto, dao);
    }

    private static void leerCaminoCategorias(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<CaminoCategoriasRoomDto> categoriasDto = dao.getCategorias(id);
        List<String> categorias = categoriasDto.parallelStream().map(CaminoCategoriasRoomDto::getCategoria).collect(Collectors.toList());
        ingDetalladoDto.setCaminoDeCategorias(categorias);
    }

    private static void leerPosiblesUnidadesMedida(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<PosiblesUnidadesRoomDto> unidadesDto = dao.getPosiblesUnidades(id);
        List<String> unidades = unidadesDto.parallelStream().map(PosiblesUnidadesRoomDto::getUnidad).collect(Collectors.toList());
        ingDetalladoDto.setPosiblesUnidades(unidades);
    }

    private static void leerUnidadesCobrar(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<TipoUnidadesAlCobrarRoomDto> tiposDto = dao.getUnidadesCobrar(id);
        List<String> tipos = tiposDto.parallelStream().map(TipoUnidadesAlCobrarRoomDto::getTipo).collect(Collectors.toList());
        ingDetalladoDto.setTiposDeUnidadesAlCobrar(tipos);
    }

    private static void leerMetaInfo(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<MetaInfoRoomDto> metaInfoDto = dao.getMetaInfo(id);
        List<String> metaInfo = metaInfoDto.parallelStream().map(MetaInfoRoomDto::getInfo).collect(Collectors.toList());
        ingDetalladoDto.setMetaInformacion(metaInfo);
    }

    private static void leerNutricion(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        if (ingDetalladoDto.getNutricion() == null) return;
        leerNutrientes(id, ingDetalladoDto, dao);

        leerPropiedades(id, ingDetalladoDto, dao);
    }

    private static void leerPropiedades(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<PropiedadRoomDto> propiedades = dao.getPropiedades(id);
        ingDetalladoDto.getNutricion().setPropiedades(propiedades);
    }

    private static void leerNutrientes(Integer id, IngredienteDetalladoRoomDto ingDetalladoDto, IngredientesDao dao) {
        List<NutrienteRoomDto> nutrientes = dao.getNutrientes(id);
        ingDetalladoDto.getNutricion().setNutrientes(nutrientes);
    }
}
