package com.cavitedet.proyectodam_spoonacular.domain;

import java.util.List;

public class Filtrado {

    private final int minimo = 0;
    private final int maximo = 100;

    private IntMinMax proteinas;
    private IntMinMax grasas;
    private IntMinMax carboHidratos;

    public Filtrado() {
        proteinas = new IntMinMax(minimo, maximo);
        grasas = new IntMinMax(minimo, maximo);
        carboHidratos = new IntMinMax(minimo, maximo);
    }

    public Filtrado(int minProteinas, int maxProteinas, int minGrasas, int maxGrasas,
                    int minCarboHidratos, int maxCarboHidratos) {
        this();
        setProteinas(minProteinas, maxProteinas);
        setGrasas(minGrasas, maxGrasas);
        setCarboHidratos(minCarboHidratos, maxCarboHidratos);
    }

    public IntMinMax getProteinas() {
        return proteinas;
    }

    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setProteinas(List<? extends Number> valores) {
        setProteinas(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public IntMinMax getGrasas() {
        return grasas;
    }

    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setGrasas(List<? extends Number> valores) {
        setGrasas(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public IntMinMax getCarboHidratos() {
        return carboHidratos;
    }

    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setCarboHidratos(List<? extends Number> valores) {
        setCarboHidratos(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public void setProteinas(int minimo, int maximo) {
        proteinas.setValorMinimoActual(minimo);
        proteinas.setValorMaximoActual(maximo);
    }

    public void setGrasas(int minimo, int maximo) {
        grasas.setValorMinimoActual(minimo);
        grasas.setValorMaximoActual(maximo);
    }

    public void setCarboHidratos(int minimo, int maximo) {
        carboHidratos.setValorMinimoActual(minimo);
        carboHidratos.setValorMaximoActual(maximo);
    }

}
