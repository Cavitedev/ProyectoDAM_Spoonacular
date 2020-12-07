package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingredientes;

import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingredientes.fixtures.IngredientesFixture;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IngredientesGsonDtoTest extends IngredientesFixture {

    @Test
    public void ingredienteADominio() {
        Assert.assertEquals(getIngredienteDominio(), getIngredienteGsonDto().aDominio());
    }

    @Test
    public void ingredientesADominio() {
        Assert.assertEquals(getIngredientesDominio(), getIngredientesGsonDto().aDominio());
    }
}
