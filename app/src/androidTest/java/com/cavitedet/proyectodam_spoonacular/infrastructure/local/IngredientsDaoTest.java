package com.cavitedet.proyectodam_spoonacular.infrastructure.local;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.busqueda.ParametrosBuscarIngredientes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IngredientsDaoTest {

    private LocalDatabase localDatabase;

    @Before
    public void inicializarBaseDeDatos() {
        localDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                LocalDatabase.class).allowMainThreadQueries().build();
    }

    @After
    public void cerrarBaseDeDatos() {
        localDatabase.close();
    }

    @Test
    public void getIngredienteDevuelveNulo() {
        IngredientesDao ingredientesDao = localDatabase.ingredientesDao();
        ParametrosBuscarIngredientes parametros = new ParametrosBuscarIngredientes("banana");
//        Ingredientes ingredientes = ingredientesDao.getIngredientes(parametros);
    }

}
