package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.NutricionGsonDto;

import java.util.Collections;

public class NutricionFixture extends PesoUnidadFixture {
    protected Nutricion getNutricionDominio() {
        return new Nutricion(Collections.singletonList(getNutrienteDominio()), Collections.singletonList(getPropiedadDominio()),
                getDecomposicionCaloricaDominio(), getPesoPorUnidadDominio());
    }

    protected NutricionGsonDto getNutricionGsonDto() {
        NutricionGsonDto dto = new NutricionGsonDto();
        dto.setNutrientes(Collections.singletonList(getNutrienteGsonDto()));
        dto.setPropiedades(Collections.singletonList(getPropiedadGsonDto()));
        dto.setDescomposicionCalorica(getDecomposicionCaloricaGsonDto());
        dto.setPesoPorRacion(getPesoPorUnidadGsonDto());
        return dto;
    }
}
