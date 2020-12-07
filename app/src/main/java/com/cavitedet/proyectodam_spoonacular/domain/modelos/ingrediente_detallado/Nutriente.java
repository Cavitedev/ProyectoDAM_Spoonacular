package com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado;


public class Nutriente {

    private String nombre;

    private Double cantidad;

    private String unidad;

    private Double porcentajeNecesitadoAlDia;

    public Nutriente(String nombre) {
        this.nombre = nombre;
    }


    public Nutriente(String nombre, Double cantidad, String unidad, Double porcentajeNecesitadoAlDia) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.porcentajeNecesitadoAlDia = porcentajeNecesitadoAlDia;
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

    public Double getPorcentajeNecesitadoAlDia() {
        return porcentajeNecesitadoAlDia;
    }

    public void setPorcentajeNecesitadoAlDia(Double porcentajeNecesitadoAlDia) {
        this.porcentajeNecesitadoAlDia = porcentajeNecesitadoAlDia;
    }

    @Override
    public String toString() {
        return "Nutriente{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", unidad='" + unidad + '\'' +
                ", porcentajeNecesitadoAlDia=" + porcentajeNecesitadoAlDia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nutriente)) return false;

        Nutriente nutriente = (Nutriente) o;

        if (getNombre() != null ? !getNombre().equals(nutriente.getNombre()) : nutriente.getNombre() != null)
            return false;
        if (getCantidad() != null ? !getCantidad().equals(nutriente.getCantidad()) : nutriente.getCantidad() != null)
            return false;
        if (getUnidad() != null ? !getUnidad().equals(nutriente.getUnidad()) : nutriente.getUnidad() != null)
            return false;
        return getPorcentajeNecesitadoAlDia() != null ? getPorcentajeNecesitadoAlDia().equals(nutriente.getPorcentajeNecesitadoAlDia()) : nutriente.getPorcentajeNecesitadoAlDia() == null;
    }

    @Override
    public int hashCode() {
        int result = getNombre() != null ? getNombre().hashCode() : 0;
        result = 31 * result + (getCantidad() != null ? getCantidad().hashCode() : 0);
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        result = 31 * result + (getPorcentajeNecesitadoAlDia() != null ? getPorcentajeNecesitadoAlDia().hashCode() : 0);
        return result;
    }
}
