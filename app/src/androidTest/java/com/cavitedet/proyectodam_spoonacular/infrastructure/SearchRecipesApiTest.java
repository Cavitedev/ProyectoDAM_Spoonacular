package com.cavitedet.proyectodam_spoonacular.infrastructure;


import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredients;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.DefaultApi;

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
public class SearchRecipesApiTest {


    @Test
    public void testEjemploOnline() throws ApiException {


        searchIngredient("banana", 2, 13, "calories", "desc");

    }

    @Test
    public void testBuscarBananaEnApp() throws ApiException {


        searchIngredient("banana", 10, 13, null, null);

    }

    private void searchIngredient(String query, Integer number, Integer expectedCount, String sort, String dir) throws ApiException {
        Ingredients result = DefaultApi.getInstance().ingredientSearch(query, null, null, null,
                null, null, null, null,
                null, null, sort, dir, null,
                number);

        MatcherAssert.assertThat(result.getTotalResults(), Matchers.equalTo(expectedCount));
    }


}
