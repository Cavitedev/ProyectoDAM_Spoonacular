package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.modelos;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ValorEstimado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;

public class ValorEstimadoGsonDto implements IADominio<ValorEstimado> {

    @SerializedName("value")
    private double valor;

    @SerializedName("unit")
    private String unidad;

    @Override
    public ValorEstimado aDominio() {
        return new ValorEstimado(valor, unidad);
    }

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

    public String valorFormateado() {
        return valor + " " + unidad;
    }
}
