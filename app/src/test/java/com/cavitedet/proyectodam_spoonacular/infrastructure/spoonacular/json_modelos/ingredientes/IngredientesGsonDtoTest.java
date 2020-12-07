package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingredientes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IngredientesGsonDtoTest extends com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures.IngredientesFixture {

    @Test
    public void ingredienteADominio() {
        Assert.assertEquals(getIngredienteDominio(), getIngredienteDto().aDominio());
    }

    @Test
    public void ingredientesADominio() {
        Assert.assertEquals(getIngredientesDominio(), getIngredientesDto().aDominio());
    }
}
