package com.cavitedet.proyectodam_spoonacular.domain.modelos.busqueda;

import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.busqueda.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiInvoker;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.Pair;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ParametrosBuscarIngredientesTest {

    @Test
    public void convertirAParametros() {
        String query = "bananas";
        Boolean addChildren = true;
        double minProtein = 0.3;
        double maxProtein = 0.6;
        double minFats = 0.2;
        double maxFats = 0.5;
        double minCarbohidrates = 0.1;
        double maxCarbohidrates = 0.2;
        boolean metaInformation = true;
        String intolerances = "something";
        String sort = "protein";
        String sortDirection = "asc";
        double offset = 4;
        int number = 10;

        ParametrosBuscarIngredientes parametrosBuscarIngredientes;
        parametrosBuscarIngredientes = setupParametrosBuscarIngredientes(query, addChildren, minProtein, maxProtein, minFats, maxFats, minCarbohidrates, maxCarbohidrates, metaInformation, intolerances, sort, sortDirection, offset, number);


        List<Pair> esperado = setupEsperado(query, addChildren, minProtein, maxProtein, minFats, maxFats, minCarbohidrates, maxCarbohidrates, metaInformation, intolerances, sort, sortDirection, offset, number);

        Assert.assertEquals(esperado, parametrosBuscarIngredientes.convertirAParametros());

    }

    private ParametrosBuscarIngredientes setupParametrosBuscarIngredientes(String query, Boolean addChildren, double minProtein, double maxProtein, double minFats, double maxFats, double minCarbohidrates, double maxCarbohidrates, boolean metaInformation, String intolerances, String sort, String sortDirection, double offset, int number) {
        ParametrosBuscarIngredientes parametrosBuscarIngredientes;
        parametrosBuscarIngredientes = new ParametrosBuscarIngredientes(query);
        parametrosBuscarIngredientes.setAddChildren(addChildren);
        Filtrado filtrado = new Filtrado(minProtein, maxProtein, minFats, maxFats, minCarbohidrates, maxCarbohidrates);
        parametrosBuscarIngredientes.setFiltrado(filtrado);
        parametrosBuscarIngredientes.setMetaInformation(metaInformation);
        parametrosBuscarIngredientes.setIntolerances(intolerances);
        parametrosBuscarIngredientes.setSort(sort);
        parametrosBuscarIngredientes.setSortDirection(sortDirection);
        parametrosBuscarIngredientes.setOffset(offset);
        parametrosBuscarIngredientes.setNumber(number);
        return parametrosBuscarIngredientes;
    }

    private List<Pair> setupEsperado(String query, Boolean addChildren, double minProtein, double maxProtein, double minFats, double maxFats, double minCarbohidrates, double maxCarbohidrates, boolean metaInformation, String intolerances, String sort, String sortDirection, double offset, int number) {

        List<Pair> esperado = new ArrayList<>();
        esperado.addAll(ApiInvoker.parameterToPairs("", "query", query));
        esperado.addAll(ApiInvoker.parameterToPairs("", "addChildren", addChildren));
        esperado.addAll(ApiInvoker.parameterToPairs("", "minProteinPercent", minProtein));
        esperado.addAll(ApiInvoker.parameterToPairs("", "maxProteinPercent", maxProtein));
        esperado.addAll(ApiInvoker.parameterToPairs("", "minFatPercent", minFats));
        esperado.addAll(ApiInvoker.parameterToPairs("", "maxFatPercent", maxFats));
        esperado.addAll(ApiInvoker.parameterToPairs("", "minCarbsPercent", minCarbohidrates));
        esperado.addAll(ApiInvoker.parameterToPairs("", "maxCarbsPercent", maxCarbohidrates));
        esperado.addAll(ApiInvoker.parameterToPairs("", "metaInformation", metaInformation));
        esperado.addAll(ApiInvoker.parameterToPairs("", "intolerances", intolerances));
        esperado.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
        esperado.addAll(ApiInvoker.parameterToPairs("", "sortDirection", sortDirection));
        esperado.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
        esperado.addAll(ApiInvoker.parameterToPairs("", "number", number));
        return esperado;
    }
}