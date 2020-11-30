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
    private Filtrado filtrado;
    private Boolean metaInformation;
    private String intolerances;
    private String sort;
    private String sortDirection;
    private Double offset;
    private Integer number = 10;

    public ObtenerListadoDeIngredientesUsecase(String query) {
        this.query = query;
        sortDirection = "desc";
        sort = "calories";
        filtrado = new Filtrado();
    }


    public FutureTask<Ingredientes> buscarIngredientesEnOtroHilo() {
        Callable<Ingredientes> callIngredientes = new Callable<Ingredientes>() {
            @Override
            public Ingredientes call() throws Exception {

                return LlamadorApi.getInstance().busquedaIngredientes(query, addChildren, filtrado.getProteinas().getValorMinimoActual(),
                        filtrado.getProteinas().getValorMaximoActual(), filtrado.getGrasas().getValorMinimoActual(), filtrado.getGrasas().getValorMaximoActual(), filtrado.getCarboHidratos().getValorMinimoActual(), filtrado.getCarboHidratos().getValorMaximoActual(),
                        metaInformation, intolerances, sort, sortDirection, offset, number);

            }


        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<Ingredientes> futureTask = new FutureTask<>(callIngredientes);


        executor.submit(futureTask);
        executor.shutdown();
        return futureTask;
    }

    public Filtrado getFiltrado() {
        return filtrado;
    }

    public void setFiltrado(Filtrado filtrado) {
        this.filtrado = filtrado;
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
