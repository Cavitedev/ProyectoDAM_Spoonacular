package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.CAMINOCATEGORIAS_NOMBRE_TABLA, primaryKeys = {"idDetalles", "categoria"})
public class CaminoCategoriasRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String categoria;

    public CaminoCategoriasRoomDto(@NonNull Integer idDetalles, @NonNull String categoria) {
        this.idDetalles = idDetalles;
        this.categoria = categoria;
    }

    @NonNull
    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(@NonNull Integer idDetalles) {
        this.idDetalles = idDetalles;
    }

    @NonNull
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NonNull String categoria) {
        this.categoria = categoria;
    }


}
