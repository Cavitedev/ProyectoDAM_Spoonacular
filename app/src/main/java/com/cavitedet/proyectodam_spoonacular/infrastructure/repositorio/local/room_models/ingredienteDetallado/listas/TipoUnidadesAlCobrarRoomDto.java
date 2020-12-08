package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;

@Entity(tableName = RoomConstantes.UNIDADESCOBRAR_NOMBRE_TABLA, primaryKeys = {"idDetalles", "indice"})
public class TipoUnidadesAlCobrarRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;

    private String tipo;

    private int indice;

    public TipoUnidadesAlCobrarRoomDto(@NonNull Integer idDetalles, String tipo, int indice) {
        this.idDetalles = idDetalles;
        this.tipo = tipo;
        this.indice = indice;
    }

    @NonNull
    public Integer getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(@NonNull Integer idDetalles) {
        this.idDetalles = idDetalles;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(o instanceof TipoUnidadesAlCobrarRoomDto)) return false;

        TipoUnidadesAlCobrarRoomDto that = (TipoUnidadesAlCobrarRoomDto) o;

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
