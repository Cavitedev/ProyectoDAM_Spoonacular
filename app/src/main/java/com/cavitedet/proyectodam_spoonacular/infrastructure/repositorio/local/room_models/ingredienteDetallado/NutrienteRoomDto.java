package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;

@Entity(tableName = RoomConstantes.NUTRIENTES_NOMBRE_TABLA,
        primaryKeys = {"idDetalles", "nombre"})
public class NutrienteRoomDto implements IADominio<Nutriente> {

    @ForeignKey(entity = IngredienteDetallado.class,
            parentColumns = "id", childColumns = "idDetalles")


    private int idDetalles;

    @NonNull
    private String nombre;

    private Double cantidad;

    private String unidad;

    private Double porcentajeNecesitadoAlDia;

    private int indice;

    public NutrienteRoomDto() {
        idDetalles = -1;
        nombre = "";

    }

    public NutrienteRoomDto(Nutriente dominio, int indice) {
        this.nombre = dominio.getNombre();
        this.cantidad = dominio.getCantidad();
        this.unidad = dominio.getUnidad();
        this.porcentajeNecesitadoAlDia = dominio.getPorcentajeNecesitadoAlDia();
        this.indice = indice;
    }


    @Override
    public Nutriente aDominio() {
        return new Nutriente(nombre, cantidad, unidad, porcentajeNecesitadoAlDia);
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

    public Double getPorcentajeNecesitadoAlDia() {
        return porcentajeNecesitadoAlDia;
    }

    public void setPorcentajeNecesitadoAlDia(Double porcentajeNecesitadoAlDia) {
        this.porcentajeNecesitadoAlDia = porcentajeNecesitadoAlDia;
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
        if (!(o instanceof NutrienteRoomDto)) return false;

        NutrienteRoomDto that = (NutrienteRoomDto) o;

        if (getIdDetalles() != that.getIdDetalles()) return false;
        if (getIndice() != that.getIndice()) return false;
        if (!getNombre().equals(that.getNombre())) return false;
        if (getCantidad() != null ? !getCantidad().equals(that.getCantidad()) : that.getCantidad() != null)
            return false;
        if (getUnidad() != null ? !getUnidad().equals(that.getUnidad()) : that.getUnidad() != null)
            return false;
        return getPorcentajeNecesitadoAlDia() != null ? getPorcentajeNecesitadoAlDia().equals(that.getPorcentajeNecesitadoAlDia()) : that.getPorcentajeNecesitadoAlDia() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdDetalles();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + (getCantidad() != null ? getCantidad().hashCode() : 0);
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        result = 31 * result + (getPorcentajeNecesitadoAlDia() != null ? getPorcentajeNecesitadoAlDia().hashCode() : 0);
        result = 31 * result + getIndice();
        return result;
    }
}
