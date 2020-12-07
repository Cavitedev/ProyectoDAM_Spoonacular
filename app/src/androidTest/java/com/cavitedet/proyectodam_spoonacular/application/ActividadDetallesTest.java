package com.cavitedet.proyectodam_spoonacular.application;


import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles.ActividadDetalles;
import com.cavitedet.proyectodam_spoonacular.domain.utilidades.ConversorImagen;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ActividadDetallesTest {

    static Intent intentBanana;

    static {
        Context context = ApplicationProvider.getApplicationContext();
        intentBanana = new Intent(context, ActividadDetalles.class);
        intentBanana.putExtra(context.getString(R.string.intent_ingrediente_id), 9040);
    }


    @Rule
    public ActivityScenarioRule<ActividadDetalles> activityRule =
            new ActivityScenarioRule<>(intentBanana);


    @Test
    public void precioApareceCorrectamente() {
        Context context = ApplicationProvider.getApplicationContext();
        Espresso.onView(ViewMatchers.withId(R.id.valor_estimado)).check(
                ViewAssertions.matches(ViewMatchers.withText
                        (context.getString(R.string.precio_ingrediente, "15.73 US Cents")))
        );
    }

    @Test
    public void detallesAparecenCorrectamente() {

        Espresso.onView(ViewMatchers.withText("105.02 kcal")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void muestraImagenConResolucionBaja() {
        ConversorImagen.guardarEnPreferenciasResolucion(ConversorImagen.Resolucion.PEQUENO,
                ApplicationProvider.getApplicationContext());

        Espresso.onView(ViewMatchers.withId(R.id.imagen_ingrediente)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
