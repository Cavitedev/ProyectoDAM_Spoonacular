package com.cavitedet.proyectodam_spoonacular.application.listado;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.ingredient.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil;

public class ActividadDeListado extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_busqueda);

        String respuesta = getIntent().getStringExtra(getString(R.string.intent_ingredientes));
        Ingredientes ingredientes = JsonUtil.deserializeIngredients(respuesta);

        RecyclerView listado = findViewById(R.id.lista_ingredientes);
        listado.setAdapter(new AdaptadorIngredientes(ingredientes, this));

    }

}
