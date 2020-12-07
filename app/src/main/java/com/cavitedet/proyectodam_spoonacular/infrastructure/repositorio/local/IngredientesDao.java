package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;

import java.util.List;


@Dao
public interface IngredientesDao {

    @Query("SELECT * FROM " + RoomConstantes.INGREDIENTES_NOMBRE_TABLA + " WHERE id = :id")
    IngredienteDetalladoRoomDto getIngredientes(int id);

    @Insert
    void insertarIngrediente(IngredienteDetalladoRoomDto ingrediente);


    @Query("SELECT * FROM " + RoomConstantes.CAMINOCATEGORIAS_NOMBRE_TABLA +
            " WHERE idDetalles = :id")
    List<CaminoCategoriasRoomDto> getCategorias(int id);

    @Insert
    void insertarCaminoCategoria(CaminoCategoriasRoomDto caminoCategorias);
}
