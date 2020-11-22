package com.cavitedet.proyectodam_spoonacular.application.listado;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.usecases.ObtenerListadoDeIngredientesUsecase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.CheckNetworkAccess;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ActividadDeListado extends AppCompatActivity {


    private TextView mensajeError;
    private ObtenerListadoDeIngredientesUsecase listadoUsecase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_busqueda);

        mensajeError = findViewById(R.id.mensaje_error);


        Ingredientes ingredientes = devolverIngredientesDelIntent();
        if (ingredientes == null) return;

        if (ingredientes.getListaIngredientes().isEmpty()) {
            mensajeError.setText(getString(R.string.error_no_resultado));

        } else {
            mostrarIngredientes(ingredientes);
        }


    }

    private void mostrarIngredientes(Ingredientes ingredientes) {
        RecyclerView listado = findViewById(R.id.lista_ingredientes);
        listado.setAdapter(new AdaptadorIngredientes(ingredientes, this));
    }

    private Ingredientes devolverIngredientesDelIntent() {
        String peticionIngrediente = getIntent().getStringExtra(getString(R.string.intent_peticion_ingredientes));

        if (peticionIngrediente == null) {
            mensajeError.setText(getString(R.string.error_recibir_intent, getString(R.string.intent_peticion_ingredientes)));
            return null;
        }

        try {


            if (!CheckNetworkAccess.isNetworkConnected(this)) {
                mensajeError.setText(getString(R.string.error_no_internet));
                return null;
            }

            listadoUsecase = new ObtenerListadoDeIngredientesUsecase(peticionIngrediente);
            FutureTask<Ingredientes> futureTask = listadoUsecase.buscarIngredientesEnOtroHilo();

            return futureTask.get(10, TimeUnit.SECONDS);


        } catch (ExecutionException e) {
            mensajeError.setText(getString(R.string.error_ejecucción_busqueda_api, peticionIngrediente));
        } catch (TimeoutException e) {
            mensajeError.setText(getString(R.string.error_respuesta_api));
        } catch (InterruptedException e) {
            mensajeError.setText(getString(R.string.error_interrupcion_hilo_api));
        }
        return null;
    }

}
