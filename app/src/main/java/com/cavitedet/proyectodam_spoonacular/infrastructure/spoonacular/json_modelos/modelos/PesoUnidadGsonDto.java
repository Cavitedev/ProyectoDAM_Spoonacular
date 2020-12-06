package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.modelos;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.PesoUnidad;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;

public class PesoUnidadGsonDto implements IADominio<PesoUnidad> {

    @SerializedName("amount")
    private Double cantidad;

    @SerializedName("unit")
    private String unidad;

    @Override
    public PesoUnidad aDominio() {
        return new PesoUnidad(cantidad, unidad);
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
        return "PesoUnidad{" +
                "cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                '}';
    }
}
