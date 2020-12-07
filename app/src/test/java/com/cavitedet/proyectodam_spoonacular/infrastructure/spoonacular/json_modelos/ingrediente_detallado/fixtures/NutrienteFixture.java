package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.NutrienteGsonDto;

public class NutrienteFixture {
    private final String nombre = "Proteina";
    private final double cantidad = 12.3;
    private final String unidad = "g";
    private final double porcentajeDiario = 0.23;

    protected NutrienteGsonDto getNutrienteDto() {
        NutrienteGsonDto dto = new NutrienteGsonDto();
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        dto.setPorcentajeNecesitadoAlDia(porcentajeDiario);
        return dto;
    }

    protected Nutriente getNutrienteDominio() {
        return new Nutriente(nombre, cantidad, unidad, porcentajeDiario);
    }
}