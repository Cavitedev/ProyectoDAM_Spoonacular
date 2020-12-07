package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.MetaInfoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;


@Database(entities = {IngredienteDetalladoRoomDto.class, CaminoCategoriasRoomDto.class
        , PosiblesUnidadesRoomDto.class, TipoUnidadesAlCobrarRoomDto.class,
        NutrienteRoomDto.class, PropiedadRoomDto.class, MetaInfoRoomDto.class}
        , version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    public abstract IngredientesDao ingredientesDao();


}
