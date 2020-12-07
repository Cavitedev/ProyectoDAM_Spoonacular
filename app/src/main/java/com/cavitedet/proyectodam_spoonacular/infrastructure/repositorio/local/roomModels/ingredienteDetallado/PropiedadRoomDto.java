package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

@Entity(tableName = RoomConstantes.PROPIEDAD_NOMBRE_TABLA,
        primaryKeys = {"idDetalles", "nombre"})
public class PropiedadRoomDto implements IADominio<Propiedad> {

    @ForeignKey(entity = IngredienteDetallado.class,
            parentColumns = "id", childColumns = "idDetalles")


    private int idDetalles;

    @NonNull
    private String nombre;

    private Double cantidad;

    private String unidad;

    public PropiedadRoomDto() {
        nombre = "";
    }

    public PropiedadRoomDto(Propiedad dominio) {
        this.nombre = dominio.getNombre();
        this.cantidad = dominio.getCantidad();
        this.unidad = dominio.getUnidad();
    }


    @Override
    public Propiedad aDominio() {
        return new Propiedad(nombre, cantidad, unidad);
    }


    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropiedadRoomDto)) return false;

        PropiedadRoomDto that = (PropiedadRoomDto) o;

        if (getIdDetalles() != that.getIdDetalles()) return false;
        if (!getNombre().equals(that.getNombre())) return false;
        if (getCantidad() != null ? !getCantidad().equals(that.getCantidad()) : that.getCantidad() != null)
            return false;
        return getUnidad() != null ? getUnidad().equals(that.getUnidad()) : that.getUnidad() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + (getCantidad() != null ? getCantidad().hashCode() : 0);
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        return result;
    }
}
