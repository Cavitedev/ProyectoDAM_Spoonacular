package com.cavitedet.proyectodam_spoonacular.infrastructure;


import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.cavitedet.proyectodam_spoonacular.R;
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

    @Test
    public void probarTodosOrdenados() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String[] tiposDeOrdenado = context.getResources().getStringArray(R.array.ordenados_api);

        boolean excepcion = false;
        for (int i = 0; i < tiposDeOrdenado.length; i++) {

            try {
                Ingredientes result = LlamadorApi.getInstance().busquedaIngredientes("banana", null, null, null,
                        null, null, null, null,
                        null, null, tiposDeOrdenado[i], "desc", null,
                        1);
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
        Ingredientes result = LlamadorApi.getInstance().busquedaIngredientes(query, null, null, null,
                null, null, null, null,
                null, null, sort, dir, null,
                number);

        MatcherAssert.assertThat(result.getResultadosTotales(), Matchers.equalTo(expectedCount));
    }


}
