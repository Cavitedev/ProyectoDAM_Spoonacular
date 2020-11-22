package com.cavitedet.proyectodam_spoonacular.application;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.listado.ActividadDeListado;
import com.cavitedet.proyectodam_spoonacular.application.util.AccionesEnPantalla;
import com.cavitedet.proyectodam_spoonacular.infrastructure.CheckNetworkAccess;

public class ActividadDeBusqueda extends AppCompatActivity {


    private EditText textoBusqueda;
    private TextView mensajeError;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_de_busqueda);


        textoBusqueda = findViewById(R.id.busqueda_textoIngrediente);
        mensajeError = findViewById(R.id.mensaje_error);
        Button botonBusqueda = findViewById(R.id.boton_busqueda);


        textoBusqueda.addTextChangedListener(deshabilitarBotonSiNoHayTexto(botonBusqueda));
    }

    private TextWatcher deshabilitarBotonSiNoHayTexto(Button botonBusqueda) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                botonBusqueda.setEnabled(charSequence.length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }


    public void buscarIngrediente(View view) {



            if (!CheckNetworkAccess.isNetworkConnected(this)) {
                AccionesEnPantalla.esconderTeclado(ActividadDeBusqueda.this);
                mensajeError.setText(getString(R.string.error_no_internet));
                return;
            }

                Intent listadoIngredientesIntent = new Intent(this, ActividadDeListado.class);
        listadoIngredientesIntent.putExtra(getString(R.string.ingredientes_query), textoBusqueda.getText().toString());
        startActivity(listadoIngredientesIntent);

    }


}