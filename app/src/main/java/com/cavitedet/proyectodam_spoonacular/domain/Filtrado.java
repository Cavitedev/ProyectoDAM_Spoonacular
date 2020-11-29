package com.cavitedet.proyectodam_spoonacular.domain;

public class Filtrado {

    private int proteinas;
    private int grasas;
    private int carboHidratos;

    public Filtrado() {
    }

    public Filtrado(int proteinas, int grasas, int carboHidratos) {
        setProteinas(proteinas);
        setGrasas(grasas);
        setCarboHidratos(carboHidratos);
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = Math.max(Math.min(100, proteinas), 0);
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = Math.max(Math.min(100, grasas), 0);
    }

    public int getCarboHidratos() {
        return carboHidratos;
    }

    public void setCarboHidratos(int carboHidratos) {
        this.carboHidratos = Math.max(Math.min(100, carboHidratos), 0);
    }
}
