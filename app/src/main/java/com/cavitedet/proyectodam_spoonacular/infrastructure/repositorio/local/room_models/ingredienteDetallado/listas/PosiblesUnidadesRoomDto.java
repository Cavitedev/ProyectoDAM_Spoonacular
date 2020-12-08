package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;

@Entity(tableName = RoomConstantes.POSIBLESUNIDADES_NOMBRE_TABLA, primaryKeys = {"idDetalles", "indice"})
public class PosiblesUnidadesRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String unidad;

    private int indice;

    public PosiblesUnidadesRoomDto(@NonNull Integer idDetalles, @NonNull String unidad, int indice) {
        this.idDetalles = idDetalles;
        this.unidad = unidad;
        this.indice = indice;
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


    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PosiblesUnidadesRoomDto)) return false;

        PosiblesUnidadesRoomDto that = (PosiblesUnidadesRoomDto) o;

        if (getIndice() != that.getIndice()) return false;
        return getIdDetalles().equals(that.getIdDetalles());
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles().hashCode();
        result = 31 * result + getIndice();
        return result;
    }
}
