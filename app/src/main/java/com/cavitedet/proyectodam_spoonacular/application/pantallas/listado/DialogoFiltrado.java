package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;
import com.google.android.material.slider.RangeSlider;

public class DialogoFiltrado extends DialogFragment {

    private aceptarFiltrar alAceptar;
    private Filtrado filtrado;
    private RangeSlider proteinasSlider;
    private RangeSlider grasasSlider;
    private RangeSlider carbohidratosSlider;

    public DialogoFiltrado(Filtrado filtrado) {
        this.filtrado = filtrado;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder constructor = new AlertDialog.Builder(getActivity());
        constructor.setTitle(R.string.cambiar_filtrado);
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.vista_filtrado, null);

        constructor.setView(view);
        proteinasSlider = view.findViewById(R.id.barra_proteina);

        constructor.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                filtrado.setProteinas(proteinasSlider.getValues());
                alAceptar.aceptarFiltrado(filtrado);
            }
        });

        return constructor.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        alAceptar = (aceptarFiltrar) context;
    }

    public interface aceptarFiltrar {
        public void aceptarFiltrado(Filtrado filtrado);
    }
}
