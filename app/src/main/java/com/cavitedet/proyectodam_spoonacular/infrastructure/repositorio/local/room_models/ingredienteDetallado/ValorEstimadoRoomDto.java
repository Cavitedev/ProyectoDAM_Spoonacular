package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.ValorEstimado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

public class ValorEstimadoRoomDto implements IADominio<ValorEstimado> {

    private double valor;

    private String unidad;

    public ValorEstimadoRoomDto() {
    }

    public ValorEstimadoRoomDto(ValorEstimado dominio) {
        if (dominio == null) return;
        this.valor = dominio.getValor();
        this.unidad = dominio.getUnidad();
    }

    @Override
    public ValorEstimado aDominio() {
        return new ValorEstimado(valor, unidad);
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

}
