package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado;

public class PesoUnidad {

    private Double cantidad;

    private String unidad;

    public PesoUnidad() {
    }

    public PesoUnidad(Double cantidad, String unidad) {
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "PesoUnidad{" +
                "cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PesoUnidad)) return false;

        PesoUnidad that = (PesoUnidad) o;

        if (getCantidad() != null ? !getCantidad().equals(that.getCantidad()) : that.getCantidad() != null)
            return false;
        return getUnidad() != null ? getUnidad().equals(that.getUnidad()) : that.getUnidad() == null;
    }

    @Override
    public int hashCode() {
        int result = getCantidad() != null ? getCantidad().hashCode() : 0;
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        return result;
    }
}
