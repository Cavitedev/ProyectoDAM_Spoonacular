package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.PesoUnidad;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

public class PesoUnidadRoomDto implements IADominio<PesoUnidad> {

    private Double cantidad;

    private String unidad;

    public PesoUnidadRoomDto() {
    }

    public PesoUnidadRoomDto(PesoUnidad dominio) {
        this.cantidad = dominio.getCantidad();
        this.unidad = dominio.getUnidad();
    }

    @Override
    public PesoUnidad aDominio() {
        return new PesoUnidad(cantidad, unidad);
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




}
