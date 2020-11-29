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

public class DialogoDeOrdenado extends DialogFragment {


    private DialogoOrdenadoRespuesta alResponder;
    private String ordenadoSeleccionado;
    private String[] ordenadosMostrar;
    private String[] ordenadosApi;

    public DialogoDeOrdenado(String ordenadoSeleccionado) {
        this.ordenadoSeleccionado = ordenadoSeleccionado;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        final String[] objetoSeleccionado = {ordenadoSeleccionado};
        int seleccionado = -1;
        for (int i = 0; i < ordenadosApi.length; i++) {
            if (ordenadosApi[i].equals(ordenadoSeleccionado)) {
                seleccionado = i;
                break;
            }
        }
        AlertDialog.Builder constructor = new AlertDialog.Builder(getActivity());
        constructor.setTitle(R.string.selecciona_orden);
        constructor.setSingleChoiceItems(ordenadosMostrar, seleccionado, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int indice) {
                objetoSeleccionado[0] = ordenadosApi[indice];
            }
        });
        constructor.setPositiveButton(getString(R.string.aceptar), new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alResponder.alAceptarOrdenado(objetoSeleccionado[0]);
                dialogInterface.dismiss();
            }
        });


        return constructor.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {

        alResponder = (DialogoOrdenadoRespuesta) context;
        ordenadosMostrar = context.getResources().getStringArray(R.array.ordenados_mostrar);
        ordenadosApi = context.getResources().getStringArray(R.array.ordenados_api);

        super.onAttach(context);
    }

    public interface DialogoOrdenadoRespuesta {
        public void alAceptarOrdenado(String respuesta);
    }
}
