package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

public class Nutriente {

    @SerializedName("title")
    private String nombre;

    @SerializedName("amount")
    private Double cantidad;

    @SerializedName("unit")
    private String unidad;

    @SerializedName("percentOfDailyNeeds")
    private Double porcentajeNecesitadoAlDia;

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
}
