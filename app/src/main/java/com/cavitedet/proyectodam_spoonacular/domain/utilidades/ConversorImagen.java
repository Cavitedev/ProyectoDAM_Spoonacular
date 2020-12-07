package com.cavitedet.proyectodam_spoonacular.domain.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

import com.cavitedet.proyectodam_spoonacular.R;

public class ConversorImagen {

    private static final String prefijoUrl = "https://spoonacular.com/cdn/ingredients_";
    private static final String pequeno = "100x100/";
    private static final String mediano = "250x250/";
    private static final String grande = "500x500/";

    /**
     * @param imagen   Final de la url
     * @param contexto contexto para sacar las preferencias
     * @return url completa a la que descargar la imágen
     */
    public static String imagenAUrl(String imagen, Context contexto) {

        Resolucion resolucion = tamanoDesdeNum(getResolucion(contexto));
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
        guardarEnPreferenciasResolucion(num, contexto);
    }

    public static void guardarEnPreferenciasResolucion(int resolucion, Context contexto) {
        SharedPreferences preferencias = contexto.getSharedPreferences(contexto.getString(R.string.mis_preferencias), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putInt(contexto.getString(R.string.resolucion_imagen), resolucion);
        editor.apply();
    }


    public static int getResolucion(Context contexto) {
        SharedPreferences preferenciasCompartidas = contexto.getSharedPreferences(contexto.getString(R.string.mis_preferencias), Context.MODE_PRIVATE);
        int idResolucion = preferenciasCompartidas.getInt(contexto.getString(R.string.resolucion_imagen), -1);
        if (idResolucion == -1) {
            guardarEnPreferenciasResolucion(Resolucion.GRANDE, contexto);
            idResolucion = 2;
        }
        return idResolucion;
    }

    public static Resolucion tamanoDesdeNum(int num) {
        return Resolucion.values()[num];
    }


    public enum Resolucion {PEQUENO, MEDIANO, GRANDE}

}
