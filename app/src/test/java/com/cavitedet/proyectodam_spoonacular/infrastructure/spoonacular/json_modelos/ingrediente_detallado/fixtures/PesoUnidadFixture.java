package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado.PesoUnidad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.PesoUnidadGsonDto;

public class PesoUnidadFixture extends PropiedadFixture {
    private final double cantidad = 250.2;
    private final String unidad = "1";

    protected PesoUnidad getPesoPorUnidadDominio() {
        return new PesoUnidad(cantidad, unidad);
    }

    protected PesoUnidadGsonDto getPesoPorUnidadDto() {
        PesoUnidadGsonDto dto = new PesoUnidadGsonDto();
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        return dto;
    }
}
