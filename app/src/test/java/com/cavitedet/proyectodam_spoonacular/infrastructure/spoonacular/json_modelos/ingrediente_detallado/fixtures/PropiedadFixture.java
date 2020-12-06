package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.PropiedadGsonDto;

public class PropiedadFixture extends DecomposicionCaloricaFixture {
    private final String nombre = "Prop nombre";
    private final double cantidad = 23.2;
    private final String unidad = "g";

    protected Propiedad getPropiedadDominio() {
        return new Propiedad(nombre, cantidad, unidad);
    }

    protected PropiedadGsonDto getPropiedadDto() {
        PropiedadGsonDto dto = new PropiedadGsonDto();
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        return dto;
    }
}
