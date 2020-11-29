package com.cavitedet.proyectodam_spoonacular.domain;

import java.util.List;

public class Filtrado {

    private final int minimo = 0;
    private final int maximo = 100;

    private DoubleMinMax proteinas;
    private DoubleMinMax grasas;
    private DoubleMinMax carboHidratos;

    public Filtrado() {
        proteinas = new DoubleMinMax(minimo, maximo);
        grasas = new DoubleMinMax(minimo, maximo);
        carboHidratos = new DoubleMinMax(minimo, maximo);
    }

    public Filtrado(double minProteinas, double maxProteinas, double minGrasas, double maxGrasas,
                    double minCarboHidratos, double maxCarboHidratos) {
        this();
        setProteinas(minProteinas, maxProteinas);
        setGrasas(minGrasas, maxGrasas);
        setCarboHidratos(minCarboHidratos, maxCarboHidratos);
    }

    public DoubleMinMax getProteinas() {
        return proteinas;
    }


    public DoubleMinMax getGrasas() {
        return grasas;
    }


    public DoubleMinMax getCarboHidratos() {
        return carboHidratos;
    }


    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setProteinas(List<? extends Number> valores) {
        setProteinas(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public void setProteinas(double minimo, double maximo) {
        proteinas.setValorMinimoActual(minimo);
        proteinas.setValorMaximoActual(maximo);
    }

    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setGrasas(List<? extends Number> valores) {
        setGrasas(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public void setGrasas(double minimo, double maximo) {
        grasas.setValorMinimoActual(minimo);
        grasas.setValorMaximoActual(maximo);
    }

    /**
     * @param valores lista con almenos 2 números que representan el mínimo y máximo
     */
    public void setCarboHidratos(List<? extends Number> valores) {
        setCarboHidratos(valores.get(0).intValue(), valores.get(1).intValue());
    }

    public void setCarboHidratos(double minimo, double maximo) {
        carboHidratos.setValorMinimoActual(minimo);
        carboHidratos.setValorMaximoActual(maximo);
    }

}
