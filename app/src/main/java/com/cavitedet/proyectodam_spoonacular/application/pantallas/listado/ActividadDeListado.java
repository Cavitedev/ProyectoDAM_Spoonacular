package com.cavitedet.proyectodam_spoonacular.application.pantallas.listado;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.Filtrado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.usecases.ObtenerListadoDeIngredientesUsecase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.CheckNetworkAccess;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ActividadDeListado extends AppCompatActivity implements DialogoDeOrdenado.DialogoOrdenadoRespuesta, DialogoFiltrado.aceptarFiltrar {


    private TextView mensajeError;
    private ObtenerListadoDeIngredientesUsecase listadoUsecase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_busqueda);

        mensajeError = findViewById(R.id.mensaje_error);

        String peticionIngrediente = getIntent().getStringExtra(getString(R.string.intent_peticion_ingredientes));
        listadoUsecase = new ObtenerListadoDeIngredientesUsecase(peticionIngrediente);
        if (peticionIngrediente == null) {
            mensajeError.setText(getString(R.string.error_recibir_intent, getString(R.string.intent_peticion_ingredientes)));
            return;
        }


        refrescarIngredientes();


    }

    private void refrescarIngredientes() {
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


        try {
            if (!CheckNetworkAccess.isNetworkConnected(this)) {
                mensajeError.setText(getString(R.string.error_no_internet));
                return null;
            }


            FutureTask<Ingredientes> futureTask = listadoUsecase.buscarIngredientesEnOtroHilo();

            return futureTask.get(10, TimeUnit.SECONDS);

        } catch (ExecutionException e) {
            mensajeError.setText(getString(R.string.error_ejecucción_busqueda_api, listadoUsecase.getQuery()));
        } catch (TimeoutException e) {
            mensajeError.setText(getString(R.string.error_respuesta_api));
        } catch (InterruptedException e) {
            mensajeError.setText(getString(R.string.error_interrupcion_hilo_api));
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_listado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_cambiar_dir_orden) {
            listadoUsecase.cambiarDireccionOrdenado();
            refrescarIngredientes();
        } else if (item.getItemId() == R.id.menu_cambiar_ordenado) {
            DialogoDeOrdenado dialogoDeOrdenado = new DialogoDeOrdenado(listadoUsecase.getSort());
            dialogoDeOrdenado.show(getSupportFragmentManager(), getString(R.string.cambiar_ordenado));
        } else if (item.getItemId() == R.id.menu_cambiar_filtrado) {
            DialogoFiltrado dialogoFiltrado = new DialogoFiltrado(listadoUsecase.getFiltrado());
            dialogoFiltrado.show(getSupportFragmentManager(), getString(R.string.cambiar_filtrado));
        }
        return true;
    }

    @Override
    public void alAceptarOrdenado(String respuesta) {
        listadoUsecase.setSort(respuesta);
        refrescarIngredientes();
    }

    @Override
    public void aceptarFiltrado(Filtrado filtrado) {
        listadoUsecase.setFiltrado(filtrado);
        refrescarIngredientes();
    }
}
