package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.modelos;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Propiedad;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;

public class PropiedadGsonDto implements IADominio<Propiedad> {

    @SerializedName("title")
    private String nombre;

    @SerializedName("amount")
    private Double cantidad;

    @SerializedName("unit")
    private String unidad;

    @Override
    public Propiedad aDominio() {
        return new Propiedad(nombre, cantidad, unidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
    public String toString() {
        return "Propiedades{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                '}';
    }
}
