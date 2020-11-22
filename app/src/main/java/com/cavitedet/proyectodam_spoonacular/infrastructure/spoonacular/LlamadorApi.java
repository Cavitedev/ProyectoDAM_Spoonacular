/*
  Modified from
  https://spoonacular.com/food-api/sdk
 */

package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LlamadorApi {
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
     *
     * @param query             Peticion de búsqueda por ejemplo "apple"
     * @param addChildren       Si quieres añadir los hijos de la busqueda
     * @param minProteinPercent Mínimo de proteinas (entre 0 y 100)
     * @param maxProteinPercent Maximo de proteínas sobre (entre 0 y 100)100%
     * @param minFatPercent     Mínimo de grasas (entre 0 y 100)
     * @param maxFatPercent     Máximo de grasas (entre 0 y 100)
     * @param minCarbsPercent   Mínimo de hidratos de carbono (entre 0 y 100)
     * @param maxCarbsPercent   Máximo de hidratos de carbono (entre 0 y 100)
     * @param metaInformation   Información extra del ingrediente
     * @param intolerances      lista de intolerancias separadas con coma
     * @param sort              tipo de ordenado
     * @param sortDirection     dirección de ordenado asc o desc
     * @param offset            Cuantos resultados se tiene que saltar
     * @param number            números de resultados devueltos
     * @return
     */
    public FutureTask<Ingredientes> busquedaIngredientesEnHiloGenerado(String query, Boolean addChildren,
                                                                       Double minProteinPercent, Double maxProteinPercent,
                                                                       Double minFatPercent, Double maxFatPercent,
                                                                       Double minCarbsPercent, Double maxCarbsPercent,
                                                                       Boolean metaInformation, String intolerances,
                                                                       String sort, String sortDirection, Double offset,
                                                                       Integer number) {

        Callable<Ingredientes> callIngredientes = new Callable<Ingredientes>() {
            @Override
            public Ingredientes call() throws Exception {
                return busquedaIngredientes(query, addChildren, minProteinPercent,
                        maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent,
                        metaInformation, intolerances, sort, sortDirection, offset, number);

            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<Ingredientes> futureTask = new FutureTask<>(callIngredientes);
        executor.submit(futureTask);
        return futureTask;
    }

    public Ingredientes busquedaIngredientes(String query, Boolean addChildren,
                                             Double minProteinPercent, Double maxProteinPercent,
                                             Double minFatPercent, Double maxFatPercent,
                                             Double minCarbsPercent, Double maxCarbsPercent,
                                             Boolean metaInformation, String intolerances, String sort,
                                             String sortDirection, Double offset, Integer number)
            throws ApiException {
        String respuesta = busquedaIngredientesEnJSONStringHiloPrincipal(query, addChildren, minProteinPercent, maxProteinPercent, minFatPercent, maxFatPercent, minCarbsPercent, maxCarbsPercent, metaInformation, intolerances, sort, sortDirection, offset, number);
        return JsonUtil.deserializarIngredientes(respuesta);

    }

    public String busquedaIngredientesEnJSONStringHiloPrincipal(String query, Boolean addChildren,
                                                                Double minProteinPercent, Double maxProteinPercent,
                                                                Double minFatPercent, Double maxFatPercent,
                                                                Double minCarbsPercent, Double maxCarbsPercent,
                                                                Boolean metaInformation, String intolerances,
                                                                String sort, String sortDirection, Double offset,
                                                                Integer number) throws ApiException {

        if (query == null) {
            throw new ApiException(400, "Missing the required parameter 'query' when calling ingredientSearch");
        }

        String localVarPath = "/food/ingredients/search";

        List<Pair> localVarQueryParams = new ArrayList<>();
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


    /**
     * LLama a está API https://spoonacular.com/food-api/docs#Get-Ingredient-Information
     *
     * @param id     identificador del ingrediente, 9266 es la piña por ejemplo
     * @param amount cantidad para realizar operaciones de precio entre otras
     * @param unit   unidad de medida: "grams", "piece", "slice", "fruit", "oz", "cup", "serbing"
     * @return respuesta json
     * @throws ApiException
     */
    public String obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws ApiException {
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
