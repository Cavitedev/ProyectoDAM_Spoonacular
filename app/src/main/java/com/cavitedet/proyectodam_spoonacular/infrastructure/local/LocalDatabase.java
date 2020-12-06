package com.cavitedet.proyectodam_spoonacular.infrastructure.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.IngredienteRoomDto;

@Database(entities = IngredienteRoomDto.class, version = 1, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {

    public abstract IngredientesDao ingredientesDao();


}
