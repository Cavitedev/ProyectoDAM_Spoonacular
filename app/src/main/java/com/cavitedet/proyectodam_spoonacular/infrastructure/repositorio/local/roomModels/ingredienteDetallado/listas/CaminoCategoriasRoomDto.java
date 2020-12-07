package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.CAMINOCATEGORIAS_NOMBRE_TABLA, primaryKeys = {"idDetalles", "categoria"})
public class CaminoCategoriasRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "caminoDeCategoriasId", onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String categoria;

    public CaminoCategoriasRoomDto(Integer idDetalles, String categoria) {
        this.idDetalles = idDetalles;
        this.categoria = categoria;
    }


    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(Integer idDetalles) {
        this.idDetalles = idDetalles;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
