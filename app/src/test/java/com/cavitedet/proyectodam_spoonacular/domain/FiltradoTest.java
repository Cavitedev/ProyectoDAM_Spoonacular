package com.cavitedet.proyectodam_spoonacular.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class FiltradoTest {

    private final double delta = 0.01;

    @Test
    public void valorMinimoEs0EnSetter() {
        Filtrado filtrado = new Filtrado(20, 20, 20, 20, 20, 20);
        filtrado.setProteinas(1, 50);
        filtrado.setCarboHidratos(-1, 50);
        filtrado.setGrasas(0, 50);

        Assert.assertEquals(1, filtrado.getProteinas().getValorMinimoActual(), delta);
        Assert.assertEquals(0, filtrado.getGrasas().getValorMinimoActual(), delta);
        Assert.assertEquals(0, filtrado.getCarboHidratos().getValorMinimoActual(), delta);
    }

    @Test
    public void valorMinimoEs0EnConstructor() {
        Filtrado filtrado = new Filtrado(1, 50, -10, 50, -20, 50);

        Assert.assertEquals(1, filtrado.getProteinas().getValorMinimoActual(), delta);
        Assert.assertEquals(0, filtrado.getGrasas().getValorMinimoActual(), delta);
        Assert.assertEquals(0, filtrado.getCarboHidratos().getValorMinimoActual(), delta);
    }

    @Test
    public void valorMaximoEs100EnSetter() {
        Filtrado filtrado = new Filtrado();
        filtrado.setProteinas(20, 101);
        filtrado.setGrasas(20, 100);
        filtrado.setCarboHidratos(20, 99);

        Assert.assertEquals(100, filtrado.getProteinas().getValorMaximoActual(), delta);
        Assert.assertEquals(100, filtrado.getGrasas().getValorMaximoActual(), delta);
        Assert.assertEquals(99, filtrado.getCarboHidratos().getValorMaximoActual(), delta);
    }

    @Test
    public void valorMaximoEs100EnConstructor() {
        Filtrado filtrado = new Filtrado(20, 99, 20, 100, 20, 101);


        Assert.assertEquals(99, filtrado.getProteinas().getValorMaximoActual(), delta);
        Assert.assertEquals(100, filtrado.getGrasas().getValorMaximoActual(), delta);
        Assert.assertEquals(100, filtrado.getCarboHidratos().getValorMaximoActual(), delta);
    }

    @Test
    public void minimoNoEsMayorQueMaximoInts() {

        Filtrado filtrado = new Filtrado();

        filtrado.setProteinas(20, 10);

        Assert.assertEquals(20, filtrado.getProteinas().getValorMinimoActual(), delta);
        Assert.assertEquals(20, filtrado.getProteinas().getValorMaximoActual(), delta);

    }

    @Test
    public void minimoNoEsMayorQueMaximoLista() {

        Filtrado filtrado = new Filtrado();
        List<Float> valores = new ArrayList<>();
        valores.add(new Float(20));
        valores.add(new Float(10));
        filtrado.setProteinas(valores);

        Assert.assertEquals(20, filtrado.getProteinas().getValorMinimoActual(), delta);
        Assert.assertEquals(20, filtrado.getProteinas().getValorMaximoActual(), delta);

    }

}
