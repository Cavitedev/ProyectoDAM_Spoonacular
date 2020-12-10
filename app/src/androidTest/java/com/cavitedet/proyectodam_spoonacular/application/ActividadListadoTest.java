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
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles.ActividadDetalles;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.listado.ActividadDeListado;
import com.cavitedet.proyectodam_spoonacular.domain.utilidades.ConversorImagen;
import com.cavitedet.proyectodam_spoonacular.utils.MyActions;
import com.cavitedet.proyectodam_spoonacular.utils.MyMatchers;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

@LargeTest
public class ActividadListadoTest {


    @Rule
    public ActivityTestRule<ActividadDeListado> activityRule
            = new ActivityTestRule<>(ActividadDeListado.class, true, false);

    @Before
    public void init() {

        Context context = ApplicationProvider.getApplicationContext();
        Intent intentConBanana = new Intent(context, ActividadDeListado.class);
        intentConBanana.putExtra(context.getString(R.string.intent_peticion_ingredientes), "banana");
        activityRule.launchActivity(intentConBanana);

        Intents.init();
    }

    @After
    public void end() {
        Intents.release();
    }

    @Test
    public void visualizaBananaChips() {


        Espresso.onView(MyMatchers.withIndex(
                ViewMatchers.withId(R.id.nombre_ingrediente), 0)).check(
                ViewAssertions.matches(ViewMatchers.withText("banana chips"))
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


    @Test
    public void noEncuentraResultadoYLuegoEncuentra_noMuestraError() {

        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                perform(MyActions.setProgressRangeSlider(80f, 100f));

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        Espresso.onView(ViewMatchers.withId(R.id.mensaje_error)).check(
                ViewAssertions.matches(ViewMatchers.withText(R.string.error_no_resultado))
        );

        Espresso.onView(ViewMatchers.withContentDescription(R.string.cambiar_filtrado)).
                perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.barra_proteina)).
                perform(MyActions.setProgressRangeSlider(0f, 100f));
        Espresso.onView(ViewMatchers.withId(R.id.barra_carbo_hidratos)).
                perform(MyActions.setProgressRangeSlider(60f, 100f));

        Espresso.onView(ViewMatchers.withId(android.R.id.button1)).perform(
                ViewActions.click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

        Espresso.onView(ViewMatchers.withId(R.id.mensaje_error)).check(
                ViewAssertions.matches(ViewMatchers.withText(""))
        );

    }

}
