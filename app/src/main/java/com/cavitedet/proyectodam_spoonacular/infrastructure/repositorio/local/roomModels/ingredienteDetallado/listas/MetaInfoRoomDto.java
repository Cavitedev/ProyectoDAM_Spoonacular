package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.METAINFO_NOMBRE_TABLA, primaryKeys = {"idDetalles", "info"})

public class MetaInfoRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String info;

    public MetaInfoRoomDto(@NonNull Integer idDetalles, @NonNull String info) {
        this.idDetalles = idDetalles;
        this.info = info;
    }

    @NonNull
    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(@NonNull Integer idDetalles) {
        this.idDetalles = idDetalles;
    }

    @NonNull
    public String getInfo() {
        return info;
    }

    public void setInfo(@NonNull String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetaInfoRoomDto)) return false;

        MetaInfoRoomDto that = (MetaInfoRoomDto) o;

        if (!getIdDetalles().equals(that.getIdDetalles())) return false;
        return getInfo().equals(that.getInfo());
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles().hashCode();
        result = 31 * result + getInfo().hashCode();
        return result;
    }
}
