/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;
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


    public static List<Ingrediente> deserializeIngredientList(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<List<Ingrediente>>() {
        }.getType());
    }

    public static Ingrediente deserializeIngredient(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<Ingrediente>() {
        }.getType());
    }

    public static Ingredientes deserializeIngredients(String jsonString) {
        return getGson().fromJson(jsonString, new TypeToken<Ingredientes>() {
        }.getType());
    }


}
