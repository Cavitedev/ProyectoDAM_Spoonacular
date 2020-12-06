package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.busqueda;

import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiInvoker;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.Pair;

import java.util.ArrayList;
import java.util.List;

public class ParametrosBuscarIngredientes {


    private String query;
    private Boolean addChildren;
    private Filtrado filtrado;
    private Boolean metaInformation;
    private String intolerances;
    private String sort;
    private String sortDirection;
    private Double offset;
    private Integer number = 10;

    public ParametrosBuscarIngredientes(String query) {
        this.query = query;
        filtrado = new Filtrado();
    }

    public List<Pair> convertirAParametros() {
        List<Pair> parametors = new ArrayList<>();
        parametors.addAll(ApiInvoker.parameterToPairs("", "query", getQuery()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "addChildren", getAddChildren()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "minProteinPercent", getFiltrado().getProteinas().getValorMinimoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "maxProteinPercent", getFiltrado().getProteinas().getValorMaximoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "minFatPercent", getFiltrado().getGrasas().getValorMinimoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "maxFatPercent", getFiltrado().getGrasas().getValorMaximoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "minCarbsPercent", getFiltrado().getCarboHidratos().getValorMinimoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "maxCarbsPercent", getFiltrado().getCarboHidratos().getValorMaximoActual()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "metaInformation", getMetaInformation()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "intolerances", getIntolerances()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "sort", getSort()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "sortDirection", getSortDirection()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "offset", getOffset()));
        parametors.addAll(ApiInvoker.parameterToPairs("", "number", getNumber()));

        return parametors;
    }


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Boolean getAddChildren() {
        return addChildren;
    }

    public void setAddChildren(Boolean addChildren) {
        this.addChildren = addChildren;
    }

    public Filtrado getFiltrado() {
        return filtrado;
    }

    public void setFiltrado(Filtrado filtrado) {
        this.filtrado = filtrado;
    }

    public Boolean getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(Boolean metaInformation) {
        this.metaInformation = metaInformation;
    }

    public String getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(String intolerances) {
        this.intolerances = intolerances;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void cambiarDireccionOrdenado() {
        sortDirection = sortDirection.equals("asc") ? "desc" : "asc";
    }

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BuscarIngredienteDatos{" +
                "query='" + query + '\'' +
                ", addChildren=" + addChildren +
                ", filtrado=" + filtrado +
                ", metaInformation=" + metaInformation +
                ", intolerances='" + intolerances + '\'' +
                ", sort='" + sort + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                ", offset=" + offset +
                ", number=" + number +
                '}';
    }
}
