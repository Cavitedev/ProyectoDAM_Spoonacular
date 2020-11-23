package com.cavitedet.proyectodam_spoonacular.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

import com.cavitedet.proyectodam_spoonacular.R;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.utilidades.ConversorImagen;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ConversorImagenTest {

    private final String MISPREFERENCIAS = "mis_preferencias";
    private final String MIRESOLUCION = "resolucion_imagen";

    @Mock
    private Context contexto;
    @Mock
    private SharedPreferences preferencias;
    @Mock
    private SharedPreferences.Editor editor;

    @Before
    public void preparar() {
        Mockito.when(contexto.getString(R.string.mis_preferencias)).thenReturn(MISPREFERENCIAS);
        Mockito.when(contexto.getString(R.string.resolucion_imagen)).thenReturn(MIRESOLUCION);
        Mockito.when(contexto.getSharedPreferences(MISPREFERENCIAS, Context.MODE_PRIVATE)).
                thenReturn(preferencias);
        Mockito.when(preferencias.edit()).thenReturn(editor);
    }


    @Test
    public void guardaTamanoEnPreferencias() {


        ConversorImagen.guardarEnPreferenciasResolucion(ConversorImagen.Resolucion.PEQUENO, contexto);

        Mockito.verify(editor).putInt(contexto.getString(R.string.resolucion_imagen), 0);

    }

    @Test
    public void tamanoGrandeSiNoEstaEspecificado() {

        Mockito.when(preferencias.getInt(MIRESOLUCION, -1)).thenReturn(-1);
        ConversorImagen.imagenAUrl("imagen", contexto);
        Mockito.verify(editor).putInt(contexto.getString(R.string.resolucion_imagen), 2);
    }

    @Test
    public void urlCorrectaConPreferenciasEnPequeno() {
        Mockito.when(preferencias.getInt(MIRESOLUCION, -1)).thenReturn(0);
        String esperado = "https://spoonacular.com/cdn/ingredients_100x100/imagen";
        Assert.assertEquals(esperado, ConversorImagen.imagenAUrl("imagen", contexto));
    }


}
