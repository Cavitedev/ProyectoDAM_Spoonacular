package com.cavitedet.proyectodam_spoonacular.utils;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;

import com.google.android.material.slider.RangeSlider;

import org.hamcrest.Matcher;

public class MyActions {

    public static ViewAction setProgressRangeSlider(final float valueMin, final float valueMax) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                ((RangeSlider) view).setValues(valueMin, valueMax);
            }

            @Override
            public String getDescription() {
                return "Set a progress";
            }

            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(RangeSlider.class);
            }
        };
    }
}
