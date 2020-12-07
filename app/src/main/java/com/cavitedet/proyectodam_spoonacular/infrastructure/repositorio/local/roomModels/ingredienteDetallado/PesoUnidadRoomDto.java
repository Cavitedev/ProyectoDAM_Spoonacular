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
        if (!(o instanceof PesoUnidadRoomDto)) return false;

        PesoUnidadRoomDto that = (PesoUnidadRoomDto) o;

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
