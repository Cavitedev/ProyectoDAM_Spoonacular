package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.excepciones.ExcepcionEnPreferencias;

public class ConversorImagen {

    private static final String prefijoUrl = "https://spoonacular.com/cdn/ingredients_";
    private static final String pequeno = "100x100/";
    private static final String mediano = "250x250/";
    private static final String grande = "500x500/";

    /**
     * @param imagen   Final de la url
     * @param contexto contexto para sacar las preferencias
     * @return url completa a la que descargar la imágen
     * @throws ExcepcionEnPreferencias si no encuentra el valor en los sharedPreferences salta un error
     */
    public static String imagenAUrl(String imagen, Context contexto) throws ExcepcionEnPreferencias {
        SharedPreferences preferenciasCompartidas = contexto.getSharedPreferences(contexto.getString(R.string.mis_preferencias), Context.MODE_PRIVATE);
        int idResolucion = preferenciasCompartidas.getInt(contexto.getString(R.string.resolucion_imagen), -1);
        if (idResolucion == -1) {
            throw new ExcepcionEnPreferencias(contexto.getString(R.string.resolucion_imagen));
        }

        Resolucion resolucion = tamanoDesdeNum(idResolucion);
        switch (resolucion) {
            case PEQUENO:
                return prefijoUrl + pequeno + imagen;
            case MEDIANO:
                return prefijoUrl + mediano + imagen;
            case GRANDE:
                return prefijoUrl + grande + imagen;

        }
        return null;
    }

    public static void guardarEnPreferenciasResolucion(Resolucion resolucion, Context contexto) {
        int num = resolucion.ordinal();
        SharedPreferences preferencias = contexto.getSharedPreferences(contexto.getString(R.string.mis_preferencias), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt(contexto.getString(R.string.resolucion_imagen), num);
        editor.apply();
    }

    private static Resolucion tamanoDesdeNum(int num) {
        return Resolucion.values()[num];
    }


    public enum Resolucion {PEQUENO, MEDIANO, GRANDE}

}
