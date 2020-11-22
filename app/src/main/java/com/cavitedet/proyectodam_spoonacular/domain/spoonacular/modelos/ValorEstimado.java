package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

public class ValorEstimado {

    @SerializedName("value")
    private double valor;

    @SerializedName("unit")
    private String unidad;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "ValorEstimado{" +
                "valor=" + valor +
                ", unidad='" + unidad + '\'' +
                '}';
    }
}
