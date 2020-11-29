package com.cavitedet.proyectodam_spoonacular.domain;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FiltradoTest {


    @Test
    public void valorMinimoEs0EnSetter() {
        Filtrado filtrado = new Filtrado(20, 20, 20);
        filtrado.setProteinas(1);
        filtrado.setCarboHidratos(-1);
        filtrado.setGrasas(0);

        Assert.assertEquals(1, filtrado.getProteinas());
        Assert.assertEquals(0, filtrado.getGrasas());
        Assert.assertEquals(0, filtrado.getCarboHidratos());
    }

    @Test
    public void valorMinimoEs0EnConstructor() {
        Filtrado filtrado = new Filtrado(-5, -10, -20);

        Assert.assertEquals(0, filtrado.getProteinas());
        Assert.assertEquals(0, filtrado.getGrasas());
        Assert.assertEquals(0, filtrado.getCarboHidratos());
    }

    @Test
    public void valorMaximoEs100EnSetter() {
        Filtrado filtrado = new Filtrado(20, 20, 20);
        filtrado.setProteinas(101);
        filtrado.setGrasas(100);
        filtrado.setCarboHidratos(99);

        Assert.assertEquals(100, filtrado.getProteinas());
        Assert.assertEquals(100, filtrado.getGrasas());
        Assert.assertEquals(99, filtrado.getCarboHidratos());
    }

    @Test
    public void valorMaximoEs100EnConstructor() {
        Filtrado filtrado = new Filtrado(99, 100, 101);


        Assert.assertEquals(99, filtrado.getProteinas());
        Assert.assertEquals(100, filtrado.getGrasas());
        Assert.assertEquals(100, filtrado.getCarboHidratos());
    }

}
