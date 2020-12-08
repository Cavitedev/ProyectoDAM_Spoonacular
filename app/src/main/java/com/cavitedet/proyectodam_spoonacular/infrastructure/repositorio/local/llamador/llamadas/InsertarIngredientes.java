package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.llamadas;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.MetaInfoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import java.util.List;

public class InsertarIngredientes {
    public static void insertarListas(IngredienteDetallado dominio, int ingId, IngredientesDao dao) {

        insertarNutricion(dominio, dao);

        insertarCaminoCategorias(dominio, ingId, dao);

        insertarPosiblesUnidades(dominio, ingId, dao);

        insertarUnidadesCobrar(dominio, ingId, dao);

        insertarMetaInformacion(dominio, ingId, dao);
    }

    private static void insertarNutricion(IngredienteDetallado dominio, IngredientesDao dao) {
        if (dominio.getNutricion() != null) {
            insertarNutrientes(dominio, dao);

            insertarPropiedades(dominio, dao);
        }
    }

    private static void insertarNutrientes(IngredienteDetallado dominio, IngredientesDao dao) {
        List<Nutriente> nutrientes = dominio.getNutricion().getNutrientes();
        for (int i = 0; i < nutrientes.size(); i++) {
            Nutriente nutriente = nutrientes.get(i);
            NutrienteRoomDto nutrienteDto = new NutrienteRoomDto(nutriente, i);
            nutrienteDto.setIdDetalles(dominio.getId());
            dao.insertarNutriente(nutrienteDto);
        }
    }

    private static void insertarPropiedades(IngredienteDetallado dominio, IngredientesDao dao) {
        List<Propiedad> propiedades = dominio.getNutricion().getPropiedades();
        for (int i = 0; i < propiedades.size(); i++) {
            Propiedad propiedad = propiedades.get(i);
            PropiedadRoomDto propiedadDto = new PropiedadRoomDto(propiedad, i);
            propiedadDto.setIdDetalles(dominio.getId());
            dao.insertarPropiedad(propiedadDto);
        }
    }

    private static void insertarCaminoCategorias(IngredienteDetallado dominio, int ingId, IngredientesDao dao) {
        List<String> caminoDeCategorias = dominio.getCaminoDeCategorias();
        for (int i = 0; i < caminoDeCategorias.size(); i++) {
            String camino = caminoDeCategorias.get(i);
            CaminoCategoriasRoomDto camDto = new CaminoCategoriasRoomDto(ingId, camino, i);
            dao.insertarCaminoCategoria(camDto);
        }
    }

    private static void insertarPosiblesUnidades(IngredienteDetallado dominio, int ingId, IngredientesDao dao) {
        List<String> posiblesUnidades = dominio.getPosiblesUnidades();
        for (int i = 0; i < posiblesUnidades.size(); i++) {
            String posUnid = posiblesUnidades.get(i);
            PosiblesUnidadesRoomDto posUnidDto = new PosiblesUnidadesRoomDto(ingId, posUnid, i);
            dao.insertarPosibleUnidad(posUnidDto);
        }
    }

    private static void insertarUnidadesCobrar(IngredienteDetallado dominio, int ingId, IngredientesDao dao) {
        List<String> tiposDeUnidadesAlCobrar = dominio.getTiposDeUnidadesAlCobrar();
        for (int i = 0; i < tiposDeUnidadesAlCobrar.size(); i++) {
            String tipoUnid = tiposDeUnidadesAlCobrar.get(i);
            TipoUnidadesAlCobrarRoomDto tipoUnidadCob = new TipoUnidadesAlCobrarRoomDto(ingId, tipoUnid, i);
            dao.insertarUnidadCobrar(tipoUnidadCob);
        }
    }

    private static void insertarMetaInformacion(IngredienteDetallado dominio, int ingId, IngredientesDao dao) {
        List<String> metaInformacion = dominio.getMetaInformacion();
        for (int i = 0; i < metaInformacion.size(); i++) {
            String metaInfo = metaInformacion.get(i);
            MetaInfoRoomDto metaInfoDto = new MetaInfoRoomDto(ingId, metaInfo, i);
            dao.insertarMetainfo(metaInfoDto);
        }
    }
}
