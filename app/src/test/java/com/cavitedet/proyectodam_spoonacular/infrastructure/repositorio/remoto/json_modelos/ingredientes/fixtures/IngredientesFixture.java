package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingredientes.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingredientes.IngredientesGsonDto;

import java.util.Collections;

public class IngredientesFixture extends IngredienteFixture {
    private final int offset = 5;
    private final int numeroPedido = 10;
    private final int resultadosTotales = 15;

    protected Ingredientes getIngredientesDominio() {
        return new Ingredientes(Collections.singletonList(getIngredienteDominio()),
                offset, numeroPedido, resultadosTotales);
    }

    protected IngredientesGsonDto getIngredientesGsonDto() {
        IngredientesGsonDto dto = new IngredientesGsonDto();
        dto.setListaIngredientes(Collections.singletonList(getIngredienteGsonDto()));
        dto.setOffset(offset);
        dto.setNumeroPedido(numeroPedido);
        dto.setResultadosTotales(resultadosTotales);
        return dto;
    }
}
