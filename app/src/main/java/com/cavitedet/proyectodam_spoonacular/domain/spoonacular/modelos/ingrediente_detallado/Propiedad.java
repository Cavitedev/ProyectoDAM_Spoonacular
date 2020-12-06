package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado;

public class Propiedad {

    private String nombre;

    private Double cantidad;

    private String unidad;

    public Propiedad(String nombre) {
        this.nombre = nombre;
    }

    public Propiedad(String nombre, Double cantidad, String unidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Propiedades{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Propiedad)) return false;

        Propiedad propiedad = (Propiedad) o;

        if (getNombre() != null ? !getNombre().equals(propiedad.getNombre()) : propiedad.getNombre() != null)
            return false;
        if (getCantidad() != null ? !getCantidad().equals(propiedad.getCantidad()) : propiedad.getCantidad() != null)
            return false;
        return getUnidad() != null ? getUnidad().equals(propiedad.getUnidad()) : propiedad.getUnidad() == null;
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getCantidad() != null ? getCantidad().hashCode() : 0);
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        return result;
    }
}
