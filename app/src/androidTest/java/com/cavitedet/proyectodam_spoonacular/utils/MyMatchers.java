package com.cavitedet.proyectodam_spoonacular.utils;

import android.view.View;

import androidx.test.espresso.matcher.BoundedMatcher;

import com.google.android.material.slider.RangeSlider;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class MyMatchers {

    // Obscure code from StackOverflow https://stackoverflow.com/a/39756832/14559140

    /**
     * Matcher that returns the index-element that matches the condition
     *
     * @param matcher Matcher to retrieve multiple elements
     * @param index   which of those elements to return, first is 0
     * @return The view that matches with the filter and the position
     */
    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }
        };
    }

    public static Matcher<View> withSliderValues(final int minValue, final int maxValue) {
        return new BoundedMatcher<View, RangeSlider>(RangeSlider.class) {


            @Override
            public void describeTo(Description description) {
                description.appendText("RangeSlider with values: ");
                description.appendValue(minValue);
                description.appendValue(maxValue);

            }

            @Override
            protected boolean matchesSafely(RangeSlider item) {
                List<Float> values = item.getValues();
                return values.get(0) == minValue && values.get(1) == maxValue;
            }
        };
    }
}
