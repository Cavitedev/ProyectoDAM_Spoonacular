package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.utilidades.ConversorImagen;

public class DialogoDeResolucion extends DialogFragment {

    private AlAceptarResolucion alAceptar;
    private Context contexto;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder constructor = new AlertDialog.Builder(getActivity());
        constructor.setTitle(R.string.cambiar_resolucion);
        final int[] opcion = {0};
        String[] opciones = new String[]{"100x100", "250x250", "500x500"};
        int opcionSeleccionada = ConversorImagen.getResolucion(contexto);
        constructor.setSingleChoiceItems(opciones, opcionSeleccionada, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int indice) {
                opcion[0] = indice;
            }
        });

        constructor.setPositiveButton(R.string.aceptar,
                (dialogInterface, indice) -> {
                    ConversorImagen.guardarEnPreferenciasResolucion(opcion[0]
                            , contexto);
                    alAceptar.aceptarResolucion();
                    dialogInterface.dismiss();
                });

        return constructor.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
        alAceptar = (AlAceptarResolucion) context;

    }

    public interface AlAceptarResolucion {
        void aceptarResolucion();
    }
}
