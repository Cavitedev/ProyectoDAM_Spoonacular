package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.POSIBLESUNIDADES_NOMBRE_TABLA, primaryKeys = {"idDetalles", "unidad"})
public class PosiblesUnidadesRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String unidad;

    public PosiblesUnidadesRoomDto(@NonNull Integer idDetalles, @NonNull String unidad) {
        this.idDetalles = idDetalles;
        this.unidad = unidad;
    }

    @NonNull
    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(@NonNull Integer idDetalles) {
        this.idDetalles = idDetalles;
    }

    @NonNull
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(@NonNull String unidad) {
        this.unidad = unidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosiblesUnidadesRoomDto)) return false;

        PosiblesUnidadesRoomDto that = (PosiblesUnidadesRoomDto) o;

        if (!getIdDetalles().equals(that.getIdDetalles())) return false;
        return getUnidad().equals(that.getUnidad());
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles().hashCode();
        result = 31 * result + getUnidad().hashCode();
        return result;
    }
}
