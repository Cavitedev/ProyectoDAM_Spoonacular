/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
  private final String basePath = "https://api.spoonacular.com";
  private final ApiInvoker apiInvoker = ApiInvoker.getInstance();

  private static DefaultApi instance;


  public static DefaultApi getInstance() {
    if (instance == null) {
      instance = new DefaultApi();
    }
    return instance;
  }


  public String busquedaIngredientesEnJSONString(String query, Boolean addChildren, Double minProteinPercent, Double maxProteinPercent, Double minFatPercent, Double maxFatPercent, Double minCarbsPercent, Double maxCarbsPercent, Boolean metaInformation, String intolerances, String sort, String sortDirection, BigDecimal offset, Integer number) throws ApiException {
    Object localVarPostBody = null;
    // verify the required parameter 'query' is set
    if (query == null) {
      throw new ApiException(400, "Missing the required parameter 'query' when calling ingredientSearch");
    }

    // create path and map variables
    String localVarPath = "/food/ingredients/search";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<>();

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "query", query));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "addChildren", addChildren));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "minProteinPercent", minProteinPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "maxProteinPercent", maxProteinPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "minFatPercent", minFatPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "maxFatPercent", maxFatPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "minCarbsPercent", minCarbsPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "maxCarbsPercent", maxCarbsPercent));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "metaInformation", metaInformation));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "intolerances", intolerances));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "sort", sort));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "sortDirection", sortDirection));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "offset", offset));
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "number", number));


    String localVarContentType = "application/json";


    return apiInvoker.invokeAPI(basePath, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);


  }

  public Ingredientes busquedaIngredientes(String query, Boolean addChildren, Double minProteinPercent, Double maxProteinPercent, Double minFatPercent, Double maxFatPercent, Double minCarbsPercent, Double maxCarbsPercent, Boolean metaInformation, String intolerances, String sort, String sortDirection, BigDecimal offset, Integer number) throws ApiException {
    String respuesta = busquedaIngredientesEnJSONString(query, addChildren, minProteinPercent, maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent, metaInformation, intolerances, sort, sortDirection, offset, number);
    return JsonUtil.deserializeIngredients(respuesta);

  }

}
