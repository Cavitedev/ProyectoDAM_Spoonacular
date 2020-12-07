package com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;

import java.util.List;

public class AdaptadorNutrientes extends RecyclerView.Adapter<AdaptadorNutrientes.ViewHolder> {

    private List<Nutriente> nutrientes;
    private Context context;

    public AdaptadorNutrientes(Context context, List<Nutriente> nutrientes) {
        this.nutrientes = nutrientes;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.propiedad_ingrediente, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarNutriente(nutrientes.get(position));
    }

    @Override
    public int getItemCount() {
        return nutrientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView propiedad;
        private TextView cantidad;
        private TextView porcentaje;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            propiedad = itemView.findViewById(R.id.propiedad);
            cantidad = itemView.findViewById(R.id.cantidad);
            porcentaje = itemView.findViewById(R.id.porcentaje_diario);
        }

        public void asignarNutriente(Nutriente nutriente) {
            propiedad.setText(String.format("%s:", nutriente.getNombre()));
            cantidad.setText(String.format("%s %s", nutriente.getCantidad(), nutriente.getUnidad()));
            porcentaje.setText(String.format("%s%%", nutriente.getPorcentajeNecesitadoAlDia()));
        }
    }
}
