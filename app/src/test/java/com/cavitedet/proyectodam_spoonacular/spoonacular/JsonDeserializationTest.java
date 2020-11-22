package com.cavitedet.proyectodam_spoonacular.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class JsonDeserializationTest {


    @Test
    public void deserializeIngredient() {
        String responseJson = "{\"id\":19400, \"name\":\"banana chips\", \"image\":\"banana-chips.jpg\"}";
        Ingrediente obj = JsonUtil.deserializeIngredient(responseJson);

        Assert.assertEquals("Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}"
                , obj.toString());
    }

    @Test
    public void deserializeIngredientList() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}]";
        List<Ingrediente> obj = JsonUtil.deserializeIngredientList(responseJson);

        Assert.assertEquals("[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}]", obj.toString());
    }

    @Test
    public void deserializeIngredientSearch() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "{\"results\":[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}],\"offset\":0,\"number\":2,\"totalResults\":13}";
        Ingredientes obj = JsonUtil.deserializeIngredients(responseJson);

        Assert.assertEquals("Ingredients{ingredientList=[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}], offset=0, number=2, totalResults=13}", obj.toString());
    }

}
