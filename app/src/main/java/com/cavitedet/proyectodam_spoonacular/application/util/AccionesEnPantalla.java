package com.cavitedet.proyectodam_spoonacular.application.util;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class AccionesEnPantalla {
    public static void esconderTeclado(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
}
