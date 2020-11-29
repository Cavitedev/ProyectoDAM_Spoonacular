package com.cavitedet.proyectodam_spoonacular.domain;

import java.util.ArrayList;
import java.util.List;

public class DoubleMinMax {

    private final double valorMinimo;
    private final double valorMaximo;
    private double valorMinimoActual;
    private double valorMaximoActual;

    public DoubleMinMax(double valorMinimo, double valorMaximo) {
        this.valorMinimo = valorMinimo;
        valorMinimoActual = valorMinimo;
        this.valorMaximo = valorMaximo;
        valorMaximoActual = valorMaximo;
    }

    public DoubleMinMax(double valorMinimo, double valorMaximo, double valorMinimoActual, double valorMaximoActual) {
        this.valorMinimo = valorMinimo;
        this.valorMinimoActual = valorMinimoActual;
        this.valorMaximo = valorMaximo;
        this.valorMaximoActual = valorMaximoActual;
    }

    public double getValorMinimoActual() {
        return valorMinimoActual;
    }

    public void setValorMinimoActual(double valorMinimoActual) {


        double nuevoValorMinimo = (double) Math.max(
                Math.min(valorMaximo, valorMinimoActual),
                valorMinimo);

        this.valorMinimoActual = Math.min(nuevoValorMinimo, valorMaximoActual);

    }

    public double getValorMaximoActual() {
        return valorMaximoActual;
    }

    public void setValorMaximoActual(double valorMaximoActual) {

        double nuevoValorMaximo = (double) Math.max(
                Math.min(valorMaximo, valorMaximoActual),
                valorMinimo);

        this.valorMaximoActual = Math.max(nuevoValorMaximo, valorMinimoActual);
    }


    public List<Float> toListFloat() {
        List<Float> lista = new ArrayList<>();
        lista.add((float) valorMinimoActual);
        lista.add((float) valorMaximoActual);
        return lista;
    }
}
