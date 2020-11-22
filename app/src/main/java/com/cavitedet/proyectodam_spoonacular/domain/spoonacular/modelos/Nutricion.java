package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Nutricion {

    @SerializedName("nutrients")
    private List<Nutriente> nutrientes;

    @SerializedName("properties")
    private List<Propiedad> propiedades;

    @SerializedName("caloricBreakdown")
    private DescomposicionCalorica descomposicionCalorica;

    @SerializedName("weightPerServing")
    private PesoUnidad pesoPorRacion;

    public List<Nutriente> getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(List<Nutriente> nutrientes) {
        this.nutrientes = nutrientes;
    }

    public List<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public DescomposicionCalorica getDescomposicionCalorica() {
        return descomposicionCalorica;
    }

    public void setDescomposicionCalorica(DescomposicionCalorica descomposicionCalorica) {
        this.descomposicionCalorica = descomposicionCalorica;
    }

    public PesoUnidad getPesoPorRacion() {
        return pesoPorRacion;
    }

    public void setPesoPorRacion(PesoUnidad pesoPorRacion) {
        this.pesoPorRacion = pesoPorRacion;
    }

    @Override
    public String toString() {
        return "Nutricion{" +
                "nutrientes=" + nutrientes +
                ", propiedades=" + propiedades +
                ", descomposicionCalorica=" + descomposicionCalorica +
                ", pesoPorRacion=" + pesoPorRacion +
                '}';
    }
}
