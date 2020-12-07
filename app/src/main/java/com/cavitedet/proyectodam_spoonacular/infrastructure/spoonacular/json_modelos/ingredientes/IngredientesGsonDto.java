package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingredientes;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.stream.Collectors;

import static com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil.getGson;

public class IngredientesGsonDto implements IADominio<Ingredientes> {

    @SerializedName("results")
    private List<IngredienteGsonDto> listaIngredientes;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("number")
    private Integer numeroPedido;

    @SerializedName("totalResults")
    private Integer resultadosTotales;

    public IngredientesGsonDto() {
    }

    public static IngredientesGsonDto desdeJson(String json) {
        return getGson().fromJson(json, new TypeToken<IngredientesGsonDto>() {
        }.getType());
    }

    @Override
    public Ingredientes aDominio() {
        return new Ingredientes(
                listaIngredientes.parallelStream().map(IngredienteGsonDto::aDominio).collect(Collectors.toList()),
                offset,
                numeroPedido,
                resultadosTotales
        );
    }

    public List<IngredienteGsonDto> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<IngredienteGsonDto> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Integer getResultadosTotales() {
        return resultadosTotales;
    }

    public void setResultadosTotales(Integer resultadosTotales) {
        this.resultadosTotales = resultadosTotales;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientList=" + listaIngredientes +
                ", offset=" + offset +
                ", number=" + numeroPedido +
                ", totalResults=" + resultadosTotales +
                '}';
    }


}
