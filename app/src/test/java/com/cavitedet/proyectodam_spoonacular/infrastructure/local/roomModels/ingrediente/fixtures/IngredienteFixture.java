package com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.ingrediente.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.IngredienteRoomDto;

public class IngredienteFixture {
    private final int id = 100;
    private final String nombre = "Manzana";
    private final String imagen = "apple";

    protected Ingrediente getIngredienteDominio() {
        return new Ingrediente(id, nombre, imagen);
    }

    protected IngredienteRoomDto getIngredienteRoomDto() {
        return new IngredienteRoomDto(getIngredienteDominio());
    }
}
