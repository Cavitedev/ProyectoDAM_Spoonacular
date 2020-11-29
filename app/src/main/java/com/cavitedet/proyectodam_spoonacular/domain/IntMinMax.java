package com.cavitedet.proyectodam_spoonacular.domain;

public class IntMinMax {

    private final int valorMinimo;
    private final int valorMaximo;
    private int valorMinimoActual;
    private int valorMaximoActual;

    public IntMinMax(int valorMinimo, int valorMaximo) {
        this.valorMinimo = valorMinimo;
        valorMinimoActual = valorMinimo;
        this.valorMaximo = valorMaximo;
        valorMaximoActual = valorMaximo;
    }

    public IntMinMax(int valorMinimo, int valorMinimoActual, int valorMaximo, int valorMaximoActual) {
        this.valorMinimo = valorMinimo;
        this.valorMinimoActual = valorMinimoActual;
        this.valorMaximo = valorMaximo;
        this.valorMaximoActual = valorMaximoActual;
    }

    public int getValorMinimoActual() {
        return valorMinimoActual;
    }

    public void setValorMinimoActual(int valorMinimoActual) {


        int nuevoValorMinimo = (int) Math.max(
                Math.min(valorMaximo, valorMinimoActual),
                valorMinimo);

        this.valorMinimoActual = Math.min(nuevoValorMinimo, valorMaximoActual);

    }

    public int getValorMaximoActual() {
        return valorMaximoActual;
    }

    public void setValorMaximoActual(int valorMaximoActual) {

        int nuevoValorMaximo = (int) Math.max(
                Math.min(valorMaximo, valorMaximoActual),
                valorMinimo);

        this.valorMaximoActual = Math.max(nuevoValorMaximo, valorMinimoActual);
    }
}
