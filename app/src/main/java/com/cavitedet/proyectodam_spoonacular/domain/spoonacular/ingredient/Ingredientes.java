package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredientes {

    @SerializedName("results")
    private List<Ingrediente> ingredienteList;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("number")
    private Integer number;

    @SerializedName("totalResults")
    private Integer totalResults;

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "ingredientList=" + ingredienteList +
                ", offset=" + offset +
                ", number=" + number +
                ", totalResults=" + totalResults +
                '}';
    }


}
