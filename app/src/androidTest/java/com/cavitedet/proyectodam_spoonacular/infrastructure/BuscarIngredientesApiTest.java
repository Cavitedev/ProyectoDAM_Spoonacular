package com.cavitedet.proyectodam_spoonacular.infrastructure;


import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.busqueda.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingredientes;
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

    @Test
    public void probarTodosOrdenados() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String[] tiposDeOrdenado = context.getResources().getStringArray(R.array.ordenados_api);
        ParametrosBuscarIngredientes parametros = new ParametrosBuscarIngredientes("banana");
        parametros.setSortDirection("desc");
        parametros.setNumber(1);
        boolean excepcion = false;
        for (String s : tiposDeOrdenado) {
            parametros.setSort(s);
            try {
                LlamadorApi.getInstance().busquedaIngredientes(parametros);
            } catch (ApiException e) {
                excepcion = true;
                break;
            }
        }
        MatcherAssert.assertThat(excepcion, Matchers.is(false));
    }

    @Test
    public void asegurarTamanosOrdenadosEsIgual() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String[] tiposDeOrdenadoApi = context.getResources().getStringArray(R.array.ordenados_api);
        String[] tiposDeOrdenadoEspanol = context.getResources().getStringArray(R.array.ordenados_mostrar);
        MatcherAssert.assertThat(tiposDeOrdenadoApi.length, Matchers.equalTo(tiposDeOrdenadoEspanol.length));
    }


    private void buscarIngredientes(String query, Integer number, Integer expectedCount, String sort, String dir) throws ApiException {
        ParametrosBuscarIngredientes parametros = new ParametrosBuscarIngredientes(query);
        parametros.setSortDirection(dir);
        parametros.setNumber(number);
        parametros.setSort(sort);

        Ingredientes result = LlamadorApi.getInstance().busquedaIngredientes(parametros);

        MatcherAssert.assertThat(result.getResultadosTotales(), Matchers.equalTo(expectedCount));
    }


}
