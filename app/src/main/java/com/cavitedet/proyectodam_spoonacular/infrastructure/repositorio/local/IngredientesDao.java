package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import java.util.List;


@Dao
public interface IngredientesDao {

    @Query("SELECT * FROM " + RoomConstantes.INGREDIENTES_NOMBRE_TABLA + " WHERE id = :id")
    IngredienteDetalladoRoomDto getIngrediente(int id);

    @Insert
    void insertarIngrediente(IngredienteDetalladoRoomDto ingrediente);


    @Query("SELECT * FROM " + RoomConstantes.CAMINOCATEGORIAS_NOMBRE_TABLA +
            " WHERE idDetalles = :id")
    List<CaminoCategoriasRoomDto> getCategorias(int id);

    @Insert
    void insertarCaminoCategoria(CaminoCategoriasRoomDto caminoCategorias);

    @Query("SELECT * FROM " + RoomConstantes.POSIBLESUNIDADES_NOMBRE_TABLA +
            " WHERE idDetalles = :id")
    List<PosiblesUnidadesRoomDto> getPosiblesUnidades(int id);

    @Insert
    void insertarPosibleUnidad(PosiblesUnidadesRoomDto elem);

    @Query("SELECT * FROM " + RoomConstantes.UNIDADESCOBRAR_NOMBRE_TABLA +
            " WHERE idDetalles = :id")
    List<TipoUnidadesAlCobrarRoomDto> getUnidadesCobrar(int id);

    @Insert
    void insertarUnidadCobrar(TipoUnidadesAlCobrarRoomDto elem);
}
