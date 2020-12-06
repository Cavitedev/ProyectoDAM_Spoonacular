package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.NutricionGsonDto;

import java.util.Collections;

public class NutricionFixture extends PesoUnidadFixture {
    protected Nutricion getNutricionDominio() {
        return new Nutricion(Collections.singletonList(getNutrienteDominio()), Collections.singletonList(getPropiedadDominio()),
                getDecomposicionCaloricaDominio(), getPesoPorUnidadDominio());
    }

    protected NutricionGsonDto getNutricionDto() {
        NutricionGsonDto dto = new NutricionGsonDto();
        dto.setNutrientes(Collections.singletonList(getNutrienteDto()));
        dto.setPropiedades(Collections.singletonList(getPropiedadDto()));
        dto.setDescomposicionCalorica(getDecomposicionCaloricaDto());
        dto.setPesoPorRacion(getPesoPorUnidadDto());
        return dto;
    }
}
