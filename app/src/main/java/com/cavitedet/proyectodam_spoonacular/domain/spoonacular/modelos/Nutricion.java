package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;


import java.util.List;

public class Nutricion {

    private List<Nutriente> nutrientes;

    private List<Propiedad> propiedades;

    private DescomposicionCalorica descomposicionCalorica;

    private PesoUnidad pesoPorRacion;

    public Nutricion() {
    }

    public Nutricion(List<Nutriente> nutrientes, List<Propiedad> propiedades, DescomposicionCalorica descomposicionCalorica, PesoUnidad pesoPorRacion) {
        this.nutrientes = nutrientes;
        this.propiedades = propiedades;
        this.descomposicionCalorica = descomposicionCalorica;
        this.pesoPorRacion = pesoPorRacion;
    }

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
