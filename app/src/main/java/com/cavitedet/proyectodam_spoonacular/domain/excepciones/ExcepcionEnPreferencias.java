package com.cavitedet.proyectodam_spoonacular.domain.excepciones;

public class ExcepcionEnPreferencias extends Exception {

    private String referencia;

    public ExcepcionEnPreferencias(String referencia) {
        super("No se ha encontrado la referencia: " + referencia + " en las preferencias compartidas");
        this.referencia = referencia;
    }
}
