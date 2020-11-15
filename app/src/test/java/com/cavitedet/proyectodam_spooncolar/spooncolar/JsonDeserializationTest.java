package com.cavitedet.proyectodam_spooncolar.spooncolar;

import com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient.Ingredient;
import com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient.Ingredients;
import com.cavitedet.proyectodam_spooncolar.infrastructure.spooncolar.JsonUtil;

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
        Ingredient obj = JsonUtil.deserializeIngredient(responseJson);

        Assert.assertEquals("Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}"
                , obj.toString());
    }

    @Test
    public void deserializeIngredientList() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}]";
        List<Ingredient> obj = JsonUtil.deserializeIngredientList(responseJson);

        Assert.assertEquals("[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}]", obj.toString());
    }

    @Test
    public void deserializeIngredientSearch() {
        //https://spoonacular.com/food-api/docs#Search-Recipes-by-Ingredients
        String responseJson = "{\"results\":[{\"id\":19400,\"name\":\"banana chips\",\"image\":\"banana-chips.jpg\"},{\"id\":93779,\"name\":\"banana liqueur\",\"image\":\"limoncello.jpg\"}],\"offset\":0,\"number\":2,\"totalResults\":13}";
        Ingredients obj = JsonUtil.deserializeIngredients(responseJson);

        Assert.assertEquals("Ingredients{ingredientList=[Ingredient{id=19400, name='banana chips', image='banana-chips.jpg'}, Ingredient{id=93779, name='banana liqueur', image='limoncello.jpg'}], offset=0, number=2, totalResults=13}", obj.toString());
    }

}
