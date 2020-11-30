package com.cavitedet.proyectodam_spoonacular.application;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles.ActividadDetalles;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.listado.ActividadDeListado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.utilidades.ConversorImagen;
import com.cavitedet.proyectodam_spoonacular.utils.MyActions;
import com.cavitedet.proyectodam_spoonacular.utils.MyMatchers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ActividadListadoTest {

    static Intent intentConBanana;

    static {
        Context context = ApplicationProvider.getApplicationContext();
        intentConBanana = new Intent(context, ActividadDeListado.class);
        intentConBanana.putExtra(context.getString(R.string.intent_peticion_ingredientes), "banana");

    }

    @Rule
    public ActivityScenarioRule<ActividadDeListado> activityRule
            = new ActivityScenarioRule<>(intentConBanana);

    @Before
    public void init() {
        Intents.init();
    }

    @Test
    public void visualizaBananaChips() {

        Espresso.onView(MyMatchers.withIndex(
                ViewMatchers.withId(R.id.nombre_ingrediente), 0)).check(
                ViewAssertions.matches(ViewMatchers.withText("banana"))
        );

    }

    @Test
    public void clickearBanana_vaActividadDetalles() {

        Espresso.onView(MyMatchers.withIndex(
                ViewMatchers.withId(R.id.ingrediente_objeto), 0)).perform(
                ViewActions.click());

        Intents.intended(IntentMatchers.hasComponent(ActividadDetalles.class.getName()));
    }

    @Test
    public void aparecenOpciones() {


        Espresso.openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());

        Espresso.onView(ViewMatchers.withText(R.string.cambiar_orden)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }

    @Test
    public void apareceFiltrado() {


        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.nombre_proteina)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void filtradoEsRecordado() {
        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                perform(MyActions.setProgressRangeSlider(2, 3));

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                check(ViewAssertions.matches(MyMatchers.withSliderValues(2, 3)));
    }

    @Test
    public void filtradoDejaPanDeBanana() {
        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                perform(MyActions.setProgressRangeSlider(3f, 5f));

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        Espresso.onView(MyMatchers.withIndex(
                ViewMatchers.withId(R.id.nombre_ingrediente), 0)).check(
                ViewAssertions.matches(ViewMatchers.withText("banana bread"))
        );
    }

    @Test
    public void filtradoImposibleDaError() {
        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                perform(MyActions.setProgressRangeSlider(99, 100));

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        Espresso.onView(MyMatchers.withIndex(
                ViewMatchers.withId(R.id.mensaje_error), 0)).check(
                ViewAssertions.matches(ViewMatchers.withText(R.string.error_no_resultado))
        );
    }

    @Test
    public void cambiarResolucionAMedianaFunciona() {

        Espresso.openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext());

        Espresso.onView(ViewMatchers.withText(R.string.cambiar_resolucion)).
                perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withText("250x250")).
                perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        int resolucion = ConversorImagen.getResolucion(ApplicationProvider.getApplicationContext());
        Assert.assertEquals(1, resolucion);
    }

}
