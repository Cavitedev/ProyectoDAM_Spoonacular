package com.cavitedet.proyectodam_spoonacular.application;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredients;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.ApiException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.DefaultApi;

public class ActividadDeBusqueda extends AppCompatActivity {


    private EditText textoBusqueda;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_de_busqueda);


        textoBusqueda = findViewById(R.id.busqueda_textoIngrediente);
        Button botonBusqueda = findViewById(R.id.boton_busqueda);


        textoBusqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    botonBusqueda.setEnabled(false);
                } else {
                    botonBusqueda.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    public void buscarIngrediente(View view) {
        try {

            Ingredients ingredients = DefaultApi.getInstance().ingredientSearch(
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
                    10
            );
            if (ingredients != null) {
                Intent listadoIngredientesIntent = new Intent(this, ActividadDeListado.class);
                startActivity(listadoIngredientesIntent);
            }

        } catch (ApiException e) {
            e.printStackTrace();
        }
    }


}