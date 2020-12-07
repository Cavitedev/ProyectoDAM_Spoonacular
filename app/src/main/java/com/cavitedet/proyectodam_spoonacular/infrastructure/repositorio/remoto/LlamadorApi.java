/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.IFuenteDeDatos;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.IngredienteDetalladoGsonDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingredientes.IngredientesGsonDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LlamadorApi implements IFuenteDeDatos {
    private static LlamadorApi instance;
    private final String basePath = "https://api.spoonacular.com";
    private final ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public static LlamadorApi getInstance() {
        if (instance == null) {
            instance = new LlamadorApi();
        }
        return instance;
    }

    /**
     * Llama a está api en otro hilo https://spoonacular.com/food-api/docs#Ingredient-Search
     */
    public Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda)
            throws ApiException {
        String respuesta = busquedaIngredientesJsonString(parametrosBusqueda);
        return IngredientesGsonDto.desdeJson(respuesta).aDominio();

    }

    public String busquedaIngredientesJsonString(ParametrosBuscarIngredientes parametrosBusqueda) throws ApiException {

        if (parametrosBusqueda.getQuery() == null) {
            throw new ApiException(400, "Missing the required parameter 'query' when calling ingredientSearch");
        }

        String localVarPath = "/food/ingredients/search";
        List<Pair> localVarQueryParams = parametrosBusqueda.convertirAParametros();
        Map<String, String> localVarHeaderParams = new HashMap<>();

        return apiInvoker.invokeAPI(basePath, localVarPath, "GET",
                localVarQueryParams, localVarHeaderParams);
    }


    /**
     * LLama a está API https://spoonacular.com/food-api/docs#Get-Ingredient-Information
     *
     */
    public IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws ApiException {
        String respuesta = obtenerInformacionIngredienteJsonString(id, amount, unit);
        return IngredienteDetalladoGsonDto.desdeJson(respuesta).aDominio();
    }


    public String obtenerInformacionIngredienteJsonString(Integer id, Double amount, String unit) throws ApiException {
        if (id == null) {
            throw new ApiException(400, "Missing the required parameter 'id' when calling getIngredientInformation");
        }

        String localVarPath = "/food/ingredients/{id}/information".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "id" + "\\}", apiInvoker.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();

        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "amount", amount));
        localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "unit", unit));

        return apiInvoker.invokeAPI(basePath, localVarPath, "GET",
                localVarQueryParams, localVarHeaderParams);

    }


}
