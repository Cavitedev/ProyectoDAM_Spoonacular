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
import androidx.test.platform.app.InstrumentationRegistry;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.detalles.ActividadDetalles;
import com.cavitedet.proyectodam_spoonacular.application.pantallas.listado.ActividadDeListado;
import com.cavitedet.proyectodam_spoonacular.utils.MyMatchers;

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


        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getInstrumentation().getTargetContext());

        Espresso.onView(ViewMatchers.withText(R.string.cambiar_orden)).
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }

}
