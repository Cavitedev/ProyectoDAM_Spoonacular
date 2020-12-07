package com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nutricion)) return false;

        Nutricion nutricion = (Nutricion) o;

        if (getNutrientes() != null ? !getNutrientes().equals(nutricion.getNutrientes()) : nutricion.getNutrientes() != null)
            return false;
        if (getPropiedades() != null ? !getPropiedades().equals(nutricion.getPropiedades()) : nutricion.getPropiedades() != null)
            return false;
        if (getDescomposicionCalorica() != null ? !getDescomposicionCalorica().equals(nutricion.getDescomposicionCalorica()) : nutricion.getDescomposicionCalorica() != null)
            return false;
        return getPesoPorRacion() != null ? getPesoPorRacion().equals(nutricion.getPesoPorRacion()) : nutricion.getPesoPorRacion() == null;
    }

    @Override
    public int hashCode() {
        int result = getNutrientes() != null ? getNutrientes().hashCode() : 0;
        result = 31 * result + (getPropiedades() != null ? getPropiedades().hashCode() : 0);
        result = 31 * result + (getDescomposicionCalorica() != null ? getDescomposicionCalorica().hashCode() : 0);
        result = 31 * result + (getPesoPorRacion() != null ? getPesoPorRacion().hashCode() : 0);
        return result;
    }
}
