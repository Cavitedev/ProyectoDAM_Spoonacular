package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.usecases;

import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.LlamadorApi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ObtenerListadoDeIngredientesUsecase {

    private String query;
    private Boolean addChildren;
    private Double minProteinPercent;
    private Double maxProteinPercent;
    private Double minFatPercent;
    private Double maxFatPercent;
    private Double minCarbsPercent;
    private Double maxCarbsPercent;
    private Boolean metaInformation;
    private String intolerances;
    private String sort;
    private String sortDirection;
    private Double offset;
    private Integer number = 10;

    public ObtenerListadoDeIngredientesUsecase(String query) {
        this.query = query;
        sortDirection = "asc";
        sort = "calories";
    }


    public FutureTask<Ingredientes> buscarIngredientesEnOtroHilo() {
        Callable<Ingredientes> callIngredientes = new Callable<Ingredientes>() {
            @Override
            public Ingredientes call() throws Exception {
                return LlamadorApi.getInstance().busquedaIngredientes(query, addChildren, minProteinPercent,
                        maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent,
                        metaInformation, intolerances, sort, sortDirection, offset, number);

            }

        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<Ingredientes> futureTask = new FutureTask<>(callIngredientes);
        executor.submit(futureTask);

        return futureTask;
    }


    public void setFiltrado(Filtrado filtrado) {

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

    public Double getMinProteinPercent() {
        return minProteinPercent;
    }

    public void setMinProteinPercent(Double minProteinPercent) {
        this.minProteinPercent = minProteinPercent;
    }

    public Double getMaxProteinPercent() {
        return maxProteinPercent;
    }

    public void setMaxProteinPercent(Double maxProteinPercent) {
        this.maxProteinPercent = maxProteinPercent;
    }

    public Double getMinFatPercent() {
        return minFatPercent;
    }

    public void setMinFatPercent(Double minFatPercent) {
        this.minFatPercent = minFatPercent;
    }

    public Double getMaxFatPercent() {
        return maxFatPercent;
    }

    public void setMaxFatPercent(Double maxFatPercent) {
        this.maxFatPercent = maxFatPercent;
    }

    public Double getMinCarbsPercent() {
        return minCarbsPercent;
    }

    public void setMinCarbsPercent(Double minCarbsPercent) {
        this.minCarbsPercent = minCarbsPercent;
    }

    public Double getMaxCarbsPercent() {
        return maxCarbsPercent;
    }

    public void setMaxCarbsPercent(Double maxCarbsPercent) {
        this.maxCarbsPercent = maxCarbsPercent;
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
}
