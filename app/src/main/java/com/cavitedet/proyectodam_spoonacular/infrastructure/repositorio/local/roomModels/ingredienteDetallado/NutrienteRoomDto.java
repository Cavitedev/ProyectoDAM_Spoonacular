package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;


import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

public class NutrienteRoomDto implements IADominio<Nutriente> {

    private String nombre;

    private Double cantidad;

    private String unidad;

    private Double porcentajeNecesitadoAlDia;

    public NutrienteRoomDto(String nombre) {
        this.nombre = nombre;
    }


    public NutrienteRoomDto(Nutriente dominio) {
        this.nombre = dominio.getNombre();
        this.cantidad = dominio.getCantidad();
        this.unidad = dominio.getUnidad();
        this.porcentajeNecesitadoAlDia = dominio.getPorcentajeNecesitadoAlDia();
    }


    @Override
    public Nutriente aDominio() {
        return new Nutriente(nombre, cantidad, unidad, porcentajeNecesitadoAlDia);
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




}
