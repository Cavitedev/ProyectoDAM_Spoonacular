package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;

@Entity(tableName = RoomConstantes.CAMINOCATEGORIAS_NOMBRE_TABLA, primaryKeys = {"idDetalles", "indice"})
public class CaminoCategoriasRoomDto {
    @ForeignKey(entity = IngredienteDetallado.class, childColumns = "idDetalles",
            parentColumns = "id", onUpdate = ForeignKey.CASCADE)

    @NonNull
    private Integer idDetalles;

    private String categoria;

    private int indice;

    public CaminoCategoriasRoomDto(@NonNull Integer idDetalles, @NonNull String categoria, int indice) {
        this.idDetalles = idDetalles;
        this.categoria = categoria;
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
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NonNull String categoria) {
        this.categoria = categoria;
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
        if (!(o instanceof CaminoCategoriasRoomDto)) return false;

        CaminoCategoriasRoomDto that = (CaminoCategoriasRoomDto) o;

        if (getIndice() != that.getIndice()) return false;
        if (!getIdDetalles().equals(that.getIdDetalles())) return false;
        return getCategoria().equals(that.getCategoria());
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles().hashCode();
        result = 31 * result + getCategoria().hashCode();
        result = 31 * result + getIndice();
        return result;
    }

    @Override
    public String toString() {
        return "CaminoCategoriasRoomDto{" +
                "idDetalles=" + idDetalles +
                ", categoria='" + categoria + '\'' +
                ", indice=" + indice +
                '}';
    }
}
