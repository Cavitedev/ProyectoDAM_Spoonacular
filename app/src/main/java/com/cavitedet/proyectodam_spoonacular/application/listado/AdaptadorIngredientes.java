package com.cavitedet.proyectodam_spoonacular.application.listado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;

public class AdaptadorIngredientes extends RecyclerView.Adapter<AdaptadorIngredientes.ViewHolder> {


    private Ingredientes ingredientes;
    private Context context;

    public AdaptadorIngredientes(Ingredientes ingredientes, Context context) {
        this.ingredientes = ingredientes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listado_objeto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int posicion) {
        holder.asignarIngrediente(ingredientes.getIngredienteList().get(posicion));
    }

    @Override
    public int getItemCount() {
        return ingredientes.getNumber();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tituloIngrediente;
        private ImageView imagenIngrediente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloIngrediente = itemView.findViewById(R.id.nombre_ingrediente);
            imagenIngrediente = itemView.findViewById(R.id.imagen_ingrediente);
        }

        public void asignarIngrediente(Ingrediente ingrediente) {
            tituloIngrediente.setText(ingrediente.getName());
            imagenIngrediente.setImageResource(R.drawable.ic_launcher_foreground);
        }


    }
}
