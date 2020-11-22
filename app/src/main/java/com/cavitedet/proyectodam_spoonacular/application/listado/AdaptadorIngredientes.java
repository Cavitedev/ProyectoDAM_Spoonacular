package com.cavitedet.proyectodam_spoonacular.application.listado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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


        private final TextView tituloIngrediente;
        private final ImageView imagenIngrediente;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloIngrediente = itemView.findViewById(R.id.nombre_ingrediente);
            imagenIngrediente = itemView.findViewById(R.id.imagen_ingrediente);
            view = itemView;
        }

        public void asignarIngrediente(Ingrediente ingrediente) {
            tituloIngrediente.setText(ingrediente.getName());
            String urlImagen = context.getString(R.string.image_url_prefix, ingrediente.getImage());
            Glide.with(view).load(urlImagen).into(imagenIngrediente);
        }


    }
}
