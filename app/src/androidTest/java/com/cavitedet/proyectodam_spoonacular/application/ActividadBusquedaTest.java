package com.cavitedet.proyectodam_spoonacular.application;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.cavitedet.proyectodam_spoonacular.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ActividadBusquedaTest {

    @Rule
    public ActivityScenarioRule<ActividadDeBusqueda> activityRule
            = new ActivityScenarioRule<>(ActividadDeBusqueda.class);


    @Test
    public void noTexto_botonDeshabilitado() {
        Espresso.onView(ViewMatchers.withId(R.id.busqueda_textoIngrediente)).perform(ViewActions.typeText(""));

        Espresso.onView(ViewMatchers.withId(R.id.boton_busqueda)).perform(ViewActions.click());


        Espresso.onView(ViewMatchers.withId(R.id.boton_busqueda)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void buscarBanana_encuentraBanana() {
        Espresso.onView(ViewMatchers.withId(R.id.busqueda_textoIngrediente)).perform(ViewActions.typeText("banana"));

        Espresso.onView(ViewMatchers.withId(R.id.boton_busqueda)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.listaLinearLayoutPadre)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void noInternet_errorInternet() {

    }


}
