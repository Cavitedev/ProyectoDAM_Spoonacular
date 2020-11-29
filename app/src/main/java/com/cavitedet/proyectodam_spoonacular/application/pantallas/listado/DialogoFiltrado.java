package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;

public class DialogoFiltrado extends DialogFragment {

    private aceptarFiltrar alAceptar;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder constructor = new AlertDialog.Builder(getActivity());
        constructor.setView(R.layout.vista_filtrado);

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
