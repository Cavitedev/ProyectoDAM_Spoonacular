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
import com.cavitedet.proyectodam_spoonacular.application.util.AccionesEnPantalla;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.CheckNetworkAccess;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.DefaultApi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
        try {


            if (!CheckNetworkAccess.isNetworkConnected(this)) {
                AccionesEnPantalla.esconderTeclado(ActividadDeBusqueda.this);
                mensajeError.setText(getString(R.string.error_no_internet));
                return;
            }

            Callable<Ingredientes> callIngredientes = new Callable() {
                @Override
                public Ingredientes call() throws ApiException {
                    return DefaultApi.getInstance().ingredientSearch(
                            textoBusqueda.getText().toString(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            10);
                }
            };
            ExecutorService executor = Executors.newFixedThreadPool(1);
            FutureTask<Ingredientes> futureTask = new FutureTask<>(callIngredientes);
            executor.submit(futureTask);

            Ingredientes ingredientes = futureTask.get(10, TimeUnit.SECONDS);


            if (ingredientes != null) {
                Intent listadoIngredientesIntent = new Intent(this, ActividadDeListado.class);
                startActivity(listadoIngredientesIntent);
            }


        } catch (ExecutionException e) {
            AccionesEnPantalla.esconderTeclado(ActividadDeBusqueda.this);
            mensajeError.setText(getString(R.string.error_ejecucción_api, textoBusqueda.getText().toString()));
        } catch (TimeoutException e) {
            AccionesEnPantalla.esconderTeclado(ActividadDeBusqueda.this);
            mensajeError.setText(getString(R.string.error_respuesta_api));
        } catch (InterruptedException e) {
            AccionesEnPantalla.esconderTeclado(ActividadDeBusqueda.this);
            mensajeError.setText(getString(R.string.error_interrupcion_hilo_api));
        }
    }


}