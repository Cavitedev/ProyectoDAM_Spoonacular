package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredientes {

    @SerializedName("results")
    private List<Ingrediente> listaIngredientes;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("number")
    private Integer numeroPedido;

    @SerializedName("totalResults")
    private Integer resultadosTotales;

    public List<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Integer getResultadosTotales() {
        return resultadosTotales;
    }

    public void setResultadosTotales(Integer resultadosTotales) {
        this.resultadosTotales = resultadosTotales;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientList=" + listaIngredientes +
                ", offset=" + offset +
                ", number=" + numeroPedido +
                ", totalResults=" + resultadosTotales +
                '}';
    }


}
