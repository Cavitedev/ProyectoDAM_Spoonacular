package com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.ValorEstimado;
import com.cavitedet.proyectodam_spoonacular.domain.usecases.ObtenerDetallesIngredienteUsecase;
import com.cavitedet.proyectodam_spoonacular.domain.utilidades.ConversorImagen;
import com.cavitedet.proyectodam_spoonacular.infrastructure.CheckNetworkAccess;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ActividadDetalles extends AppCompatActivity {

    private ObtenerDetallesIngredienteUsecase detalleUsecase;

    private TextView mensajeError;
    private TextView nombreIngrediente;
    private TextView precioIngrediente;
    private TextView categoriaIngrediente;
    private ImageView imagenIngrediente;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles_ingrediente);
        mensajeError = findViewById(R.id.mensaje_error);
        nombreIngrediente = findViewById(R.id.nombre_ingrediente);
        precioIngrediente = findViewById(R.id.valor_estimado);
        categoriaIngrediente = findViewById(R.id.categoria);
        imagenIngrediente = findViewById(R.id.imagen_ingrediente);

        IngredienteDetallado ingredienteDetallado = devolverIngredienteDetalladoDelIntent();

        if (ingredienteDetallado != null) {
            nombreIngrediente.setText(getString(R.string.nombre_ingrediente, ingredienteDetallado.getNombre()));
            ValorEstimado valorEstimado = ingredienteDetallado.getValorEstimado();
            precioIngrediente.setText(getString(R.string.precio_ingrediente, valorEstimado.valorFormateado()));
            String categoria = asignarCategoriaSiExiste(ingredienteDetallado);
            categoriaIngrediente.setText(getString(R.string.categoria_ingrediente, categoria));

            String urlImagen = ConversorImagen.imagenAUrl(ingredienteDetallado.getImagen(), this);
            Glide.with(this).load(urlImagen).into(imagenIngrediente);

            AdaptadorNutrientes adaptadorNutrientes = new AdaptadorNutrientes(this, ingredienteDetallado.getNutricion().getNutrientes());
            RecyclerView recyclerView = findViewById(R.id.propiedades_ingrediente);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(adaptadorNutrientes);

        }

    }


    private IngredienteDetallado devolverIngredienteDetalladoDelIntent() {
        Integer idIngrediente = getIntent().getIntExtra(getString(R.string.intent_ingrediente_id), 0);

        if (idIngrediente == 0) {
            mensajeError.setVisibility(View.VISIBLE);
            mensajeError.setText(getString(R.string.error_recibir_intent, getString(R.string.intent_ingrediente_id)));
            return null;
        }
        try {


            if (!CheckNetworkAccess.isNetworkConnected(this)) {
                mensajeError.setVisibility(View.VISIBLE);
                mensajeError.setText(getString(R.string.error_no_internet));
                return null;
            }

            detalleUsecase = new ObtenerDetallesIngredienteUsecase(idIngrediente);
            FutureTask<IngredienteDetallado> futureTask = detalleUsecase.obtenerDetallesIngredienteEnOtroHilo();

            return futureTask.get(100, TimeUnit.SECONDS);


        } catch (ExecutionException e) {
            if (e.getCause() != null && e.getCause().getMessage() != null && e.getCause().getMessage().equals(getString(R.string.excepcion_pago_api))) {
                mensajeError.setText(R.string.llamadas_api_acabadas);
            } else {
                mensajeError.setVisibility(View.VISIBLE);
                mensajeError.setText(getString(R.string.error_ejecucción_detalles_api, idIngrediente));
            }
        } catch (TimeoutException e) {
            mensajeError.setVisibility(View.VISIBLE);
            mensajeError.setText(getString(R.string.error_respuesta_api));
        } catch (InterruptedException e) {
            mensajeError.setVisibility(View.VISIBLE);
            mensajeError.setText(getString(R.string.error_interrupcion_hilo_api));
        }
        return null;
    }

    private String asignarCategoriaSiExiste(IngredienteDetallado ingredienteDetallado) {
        String categoria;
        if (!ingredienteDetallado.getCaminoDeCategorias().isEmpty()) {
            categoria = ingredienteDetallado.getCaminoDeCategorias().get(0);
        } else {
            categoria = ingredienteDetallado.getCategoria();
        }
        if (categoria == null) {
            categoria = getString(R.string.sin_categoria);
        }
        return categoria;
    }
}
