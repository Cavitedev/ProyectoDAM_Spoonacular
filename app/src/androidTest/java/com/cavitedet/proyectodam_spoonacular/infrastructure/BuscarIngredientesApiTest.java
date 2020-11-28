package com.cavitedet.proyectodam_spoonacular.infrastructure;


import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.LlamadorApi;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests para buscar en esta página
 * https://spoonacular.com/food-api/docs#Ingredient-Search
 */
@RunWith(JUnit4.class)
public class BuscarIngredientesApiTest {


    @Test
    public void testEjemploOnline() throws ApiException {


        buscarIngredientes("banana", 2, 13, "calories", "desc");

    }

    @Test
    public void testBuscarBananaEnApp() throws ApiException {


        buscarIngredientes("banana", 10, 13, null, null);

    }


    private void buscarIngredientes(String query, Integer number, Integer expectedCount, String sort, String dir) throws ApiException {
        Ingredientes result = LlamadorApi.getInstance().busquedaIngredientes(query, null, null, null,
                null, null, null, null,
                null, null, sort, dir, null,
                number);

        MatcherAssert.assertThat(result.getResultadosTotales(), Matchers.equalTo(expectedCount));
    }


}
