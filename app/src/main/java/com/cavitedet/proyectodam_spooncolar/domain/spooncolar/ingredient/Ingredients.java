package com.cavitedet.proyectodam_spooncolar.domain.spooncolar.ingredient;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredients {

    @SerializedName("results")
    private List<Ingredient> ingredientList;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("number")
    private Integer number;

    @SerializedName("totalResults")
    private Integer totalResults;

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
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
                "ingredientList=" + ingredientList +
                ", offset=" + offset +
                ", number=" + number +
                ", totalResults=" + totalResults +
                '}';
    }


}
