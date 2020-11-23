package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles.ActividadDetalles;
import com.cavitedet.proyectodam_spoonacular.domain.excepciones.ExcepcionEnPreferencias;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.utilidades.ConversorImagen;

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
        holder.asignarIngrediente(ingredientes.getListaIngredientes().get(posicion));
    }

    @Override
    public int getItemCount() {
        return ingredientes.getListaIngredientes().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private final TextView tituloIngrediente;
        private final ImageView imagenIngrediente;
        private Integer ingredienteID;
        private View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloIngrediente = itemView.findViewById(R.id.nombre_ingrediente);
            imagenIngrediente = itemView.findViewById(R.id.imagen_ingrediente);
            view = itemView;
            view.setOnClickListener(this);
        }

        public void asignarIngrediente(Ingrediente ingrediente) {
            ingredienteID = ingrediente.getId();
            tituloIngrediente.setText(ingrediente.getNombre());
            String urlImagen = null;
            try {
                urlImagen = ConversorImagen.imagenAUrl(ingrediente.getImagen(), context);
            } catch (ExcepcionEnPreferencias excepcionEnPreferencias) {
                //TODO añadir pop up para elegir resolucion
                excepcionEnPreferencias.printStackTrace();
            }
            Glide.with(view).load(urlImagen).into(imagenIngrediente);
        }


        @Override
        public void onClick(View view) {
            Intent paginaDetallesIntent = new Intent(context, ActividadDetalles.class);
            paginaDetallesIntent.putExtra(context.getString(R.string.intent_ingrediente_id), ingredienteID);
            context.startActivity(paginaDetallesIntent);
        }
    }
}
