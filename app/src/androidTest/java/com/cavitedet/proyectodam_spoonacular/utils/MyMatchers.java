package com.cavitedet.proyectodam_spoonacular.utils;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

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
}
