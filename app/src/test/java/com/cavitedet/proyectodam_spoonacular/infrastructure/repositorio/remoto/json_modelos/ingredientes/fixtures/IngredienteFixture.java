package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingredientes.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingredientes.IngredienteGsonDto;

public class IngredienteFixture {
    private final int id = 100;
    private final String nombre = "Manzana";
    private final String imagen = "apple";

    protected Ingrediente getIngredienteDominio() {
        return new Ingrediente(id, nombre, imagen);
    }

    protected IngredienteGsonDto getIngredienteGsonDto() {
        IngredienteGsonDto dto = new IngredienteGsonDto();
        dto.setId(id);
        dto.setNombre(nombre);
        dto.setImagen(imagen);
        return dto;
    }
}
