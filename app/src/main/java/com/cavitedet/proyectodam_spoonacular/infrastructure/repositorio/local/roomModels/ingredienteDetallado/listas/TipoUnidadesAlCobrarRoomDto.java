package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.UNIDADESCOBRAR_NOMBRE_TABLA, primaryKeys = {"idDetalles", "tipo"})
public class TipoUnidadesAlCobrarRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;
    @NonNull
    private String tipo;

    public TipoUnidadesAlCobrarRoomDto(@NonNull Integer idDetalles, @NonNull String tipo) {
        this.idDetalles = idDetalles;
        this.tipo = tipo;
    }

    @NonNull
    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(@NonNull Integer idDetalles) {
        this.idDetalles = idDetalles;
    }

    @NonNull
    public String getTipo() {
        return tipo;
    }

    public void setTipo(@NonNull String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoUnidadesAlCobrarRoomDto)) return false;

        TipoUnidadesAlCobrarRoomDto that = (TipoUnidadesAlCobrarRoomDto) o;

        if (!getIdDetalles().equals(that.getIdDetalles())) return false;
        return getTipo().equals(that.getTipo());
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles().hashCode();
        result = 31 * result + getTipo().hashCode();
        return result;
    }
}
