/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class DefaultApi {
    private static DefaultApi instance;
    private final String basePath = "https://api.spoonacular.com";
    private final ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public static DefaultApi getInstance() {
        if (instance == null) {
            instance = new DefaultApi();
        }
        return instance;
    }

    public FutureTask<String> busquedaIngredientesEnJSONStringHiloGenerado(String query, Boolean addChildren,
                                                                           Double minProteinPercent, Double maxProteinPercent,
                                                                           Double minFatPercent, Double maxFatPercent,
                                                                           Double minCarbsPercent, Double maxCarbsPercent,
                                                                           Boolean metaInformation, String intolerances,
                                                                           String sort, String sortDirection, Double offset,
                                                                           Integer number) {

        Callable<String> callIngredientes = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return busquedaIngredientesEnJSONStringHiloPrincipal(query, addChildren, minProteinPercent,
                        maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent,
                        metaInformation, intolerances, sort, sortDirection, offset, number);

            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask = new FutureTask<>(callIngredientes);
        executor.submit(futureTask);
        return futureTask;
    }

    public String busquedaIngredientesEnJSONStringHiloPrincipal(String query, Boolean addChildren,
                                                                Double minProteinPercent, Double maxProteinPercent,
                                                                Double minFatPercent, Double maxFatPercent,
                                                                Double minCarbsPercent, Double maxCarbsPercent,
                                                                Boolean metaInformation, String intolerances,
                                                                String sort, String sortDirection, Double offset,
                                                                Integer number) throws ApiException {

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


        return apiInvoker.invokeAPI(basePath, localVarPath, "GET",
                localVarQueryParams, localVarHeaderParams);


    }

    public Ingredientes busquedaIngredientes(String query, Boolean addChildren,
                                             Double minProteinPercent, Double maxProteinPercent,
                                             Double minFatPercent, Double maxFatPercent,
                                             Double minCarbsPercent, Double maxCarbsPercent,
                                             Boolean metaInformation, String intolerances, String sort,
                                             String sortDirection, Double offset, Integer number)
            throws ApiException {
        String respuesta = busquedaIngredientesEnJSONStringHiloPrincipal(query, addChildren, minProteinPercent, maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent, metaInformation, intolerances, sort, sortDirection, offset, number);
        return JsonUtil.deserializeIngredients(respuesta);

    }

}
