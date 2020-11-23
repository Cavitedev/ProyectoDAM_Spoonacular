package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;

public class ListaIngredientesViewModel extends ViewModel {


    private MutableLiveData<Ingredientes> ingredientes;

    public ListaIngredientesViewModel(MutableLiveData<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public MutableLiveData<Ingredientes> getIngredientes() {
        return ingredientes;
    }
}