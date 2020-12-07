package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;


@Database(entities = {IngredienteDetalladoRoomDto.class, CaminoCategoriasRoomDto.class}
        , version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    public abstract IngredientesDao ingredientesDao();


}
