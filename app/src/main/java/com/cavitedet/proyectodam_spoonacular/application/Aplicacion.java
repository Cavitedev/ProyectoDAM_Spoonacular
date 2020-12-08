package com.cavitedet.proyectodam_spoonacular.application;

import android.app.Application;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.IngredientesRepositorio;

public class Aplicacion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IngredientesRepositorio.buildInstance(this);
    }
}
