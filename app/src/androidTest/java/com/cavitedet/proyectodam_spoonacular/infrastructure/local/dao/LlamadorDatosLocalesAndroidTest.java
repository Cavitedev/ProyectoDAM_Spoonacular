package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LlamadorDatosLocales;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import infrastructure.local.fixtures.IngredienteDetalladoFixture;

@RunWith(JUnit4.class)
public class LlamadorDatosLocalesAndroidTest extends IngredienteDetalladoFixture {


    private LlamadorDatosLocales llamador;

    @Before
    public void inicializarBaseDeDatos() {
        LocalDatabase localDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                LocalDatabase.class).allowMainThreadQueries().build();

        llamador = new LlamadorDatosLocales(localDatabase);

    }

    @After
    public void cerrarBaseDeDatos() {
        llamador.limpiar();
    }

    @Test
    public void leeElementoNoEncuentraNada() throws Exception {

        IngredienteDetallado ing = llamador.obtenerInformacionIngrediente(id, 1.0, null);
        Assert.assertNull(ing);
    }

    @Test
    public void insertaYLeeElementoDevuelveElMismo() throws Exception {

        llamador.insertarIngrediente(getIngredienteDetalladoDominio());

        IngredienteDetallado ing = llamador.obtenerInformacionIngrediente(id, 1.0, null);
        Assert.assertNotNull(ing);
        Assert.assertEquals(getIngredienteDetalladoDominio(), ing);
    }
}
