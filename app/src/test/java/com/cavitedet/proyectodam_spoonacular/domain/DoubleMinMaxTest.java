package com.cavitedet.proyectodam_spoonacular.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class DoubleMinMaxTest {


    @Test
    public void convertToFloatList() {
        DoubleMinMax minMax = new DoubleMinMax(0, 100, 20, 50);
        List<Float> valores = minMax.toListFloat();

        Assert.assertEquals(20.0, valores.get(0), 0.01);
        Assert.assertEquals(50.0, valores.get(1), 0.01);
    }

}
