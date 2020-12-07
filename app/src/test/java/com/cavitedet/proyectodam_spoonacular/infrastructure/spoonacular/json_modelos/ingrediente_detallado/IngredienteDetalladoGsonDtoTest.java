package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado;

import org.junit.Assert;
import org.junit.Test;

public class IngredienteDetalladoGsonDtoTest extends com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado.fixtures.IngredienteDetalladoFixture {

    @Test
    public void valorEstimadoADominio() {
        Assert.assertEquals(getValorEstimadoDominio(), getValorEstimadoGsonDto().aDominio());
    }

    @Test
    public void nutrienteADominito() {
        Assert.assertEquals(getNutrienteDominio(), getNutrienteGsonDto().aDominio());
    }

    @Test
    public void propiedadesADominio() {
        Assert.assertEquals(getPropiedadDominio(), getPropiedadGsonDto().aDominio());
    }

    @Test
    public void decomposicionCaloricaADominio() {
        Assert.assertEquals(getDecomposicionCaloricaDominio(), getDecomposicionCaloricaGsonDto().aDominio());
    }

    @Test
    public void pesoPorUnidadADominio() {
        Assert.assertEquals(getPesoPorUnidadDominio(), getPesoPorUnidadGsonDto().aDominio());
    }

    @Test
    public void nutricionADominio() {
        Assert.assertEquals(getNutricionDominio(), getNutricionGsonDto().aDominio());
    }

    @Test
    public void ingredienteDetalladoADominio() {
        Assert.assertEquals(getIngredienteDetalladoDominio(), getIngredienteDetalladoGsonDto().aDominio());
    }


}