package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado;

import androidx.room.ColumnInfo;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.PesoUnidad;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

public class PesoUnidadRoomDto implements IADominio<PesoUnidad> {

    @ColumnInfo(name = "cantidadPeso")
    private Double cantidad;

    @ColumnInfo(name = "unidadPeso")
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
