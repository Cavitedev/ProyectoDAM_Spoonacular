package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

public class PesoUnidad {

    @SerializedName("amount")
    private Double cantidad;

    @SerializedName("unit")
    private String unidad;

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
