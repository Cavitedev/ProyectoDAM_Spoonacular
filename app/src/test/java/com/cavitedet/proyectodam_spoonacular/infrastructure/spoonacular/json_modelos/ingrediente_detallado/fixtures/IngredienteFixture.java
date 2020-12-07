package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingredientes.IngredienteGsonDto;

public class IngredienteFixture {
    private final int id = 100;
    private final String nombre = "Manzana";
    private final String imagen = "apple";

    protected Ingrediente getIngredienteDominio() {
        return new Ingrediente(id, nombre, imagen);
    }

    protected IngredienteGsonDto getIngredienteDto() {
        IngredienteGsonDto dto = new IngredienteGsonDto();
        dto.setId(id);
        dto.setNombre(nombre);
        dto.setImagen(imagen);
        return dto;
    }
}
