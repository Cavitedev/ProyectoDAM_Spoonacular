package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.ValorEstimado;

public class ValorEstimadoRoomDto {

    private double valor;

    private String unidad;

    public ValorEstimadoRoomDto(ValorEstimado dominio) {
        this.valor = dominio.getValor();
        this.unidad = dominio.getUnidad();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    @Override
    public String toString() {
        return "ValorEstimado{" +
                "valor=" + valor +
                ", unidad='" + unidad + '\'' +
                '}';
    }

    public String valorFormateado() {
        return valor + " " + unidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ValorEstimadoRoomDto)) return false;

        ValorEstimadoRoomDto that = (ValorEstimadoRoomDto) o;

        if (Double.compare(that.getValor(), getValor()) != 0) return false;
        return getUnidad() != null ? getUnidad().equals(that.getUnidad()) : that.getUnidad() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getValor());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getUnidad() != null ? getUnidad().hashCode() : 0);
        return result;
    }
}
