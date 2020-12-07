package com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes;


import java.util.List;

public class Ingredientes {

    private List<Ingrediente> listaIngredientes;

    private Integer offset;

    private Integer numeroPedido;

    private Integer resultadosTotales;

    public Ingredientes(List<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public Ingredientes(List<Ingrediente> listaIngredientes, Integer offset, Integer numeroPedido, Integer resultadosTotales) {
        this.listaIngredientes = listaIngredientes;
        this.offset = offset;
        this.numeroPedido = numeroPedido;
        this.resultadosTotales = resultadosTotales;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredientes)) return false;

        Ingredientes that = (Ingredientes) o;

        if (!getListaIngredientes().equals(that.getListaIngredientes())) return false;
        if (getOffset() != null ? !getOffset().equals(that.getOffset()) : that.getOffset() != null)
            return false;
        if (getNumeroPedido() != null ? !getNumeroPedido().equals(that.getNumeroPedido()) : that.getNumeroPedido() != null)
            return false;
        return getResultadosTotales() != null ? getResultadosTotales().equals(that.getResultadosTotales()) : that.getResultadosTotales() == null;
    }

    @Override
    public int hashCode() {
        int result = getListaIngredientes().hashCode();
        result = 31 * result + (getOffset() != null ? getOffset().hashCode() : 0);
        result = 31 * result + (getNumeroPedido() != null ? getNumeroPedido().hashCode() : 0);
        result = 31 * result + (getResultadosTotales() != null ? getResultadosTotales().hashCode() : 0);
        return result;
    }
}
