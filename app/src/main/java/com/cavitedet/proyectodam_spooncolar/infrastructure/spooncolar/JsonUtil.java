/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spooncolar.infrastructure.spooncolar;

import com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient.Ingredient;
import com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient.Ingredients;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class JsonUtil {
    public static GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }

    public static String serialize(Object obj) {
        return getGson().toJson(obj);
    }


    public static List<Ingredient> deserializeIngredientList(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<List<Ingredient>>() {
        }.getType());
    }

    public static Ingredient deserializeIngredient(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<Ingredient>() {
        }.getType());
    }

    public static Ingredients deserializeIngredients(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<Ingredients>() {
        }.getType());
    }


}
