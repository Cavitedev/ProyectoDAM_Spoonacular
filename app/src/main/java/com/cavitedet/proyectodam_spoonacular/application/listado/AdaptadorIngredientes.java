package com.cavitedet.proyectodam_spoonacular.application.listado;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingrediente;

public class AdaptadorIngredientes extends ListAdapter<Ingrediente, AdaptadorIngredientes.ViewHolder> {


    protected AdaptadorIngredientes(@NonNull DiffUtil.ItemCallback<Ingrediente> diffCallback) {

        super(diffCallback);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int posicion) {
        Ingrediente ingrediente = getItem(posicion);

    }


    class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
