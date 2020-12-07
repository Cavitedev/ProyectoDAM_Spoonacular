package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import infrastructure.local.fixtures.IngredienteDetalladoFixture;

@RunWith(JUnit4.class)
public class IngredientesDaoTest extends IngredienteDetalladoFixture {

    private LocalDatabase localDatabase;
    private IngredientesDao ingredientesDao;

    @Before
    public void inicializarBaseDeDatos() {
        localDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                LocalDatabase.class).allowMainThreadQueries().build();
        ingredientesDao = localDatabase.ingredientesDao();
    }

    @After
    public void cerrarBaseDeDatos() {
        localDatabase.close();
    }

    @Test
    public void getIngredienteDevuelveNulo() {
        IngredienteDetalladoRoomDto ingrediente = ingredientesDao.getIngrediente(id);
        Assert.assertNull(ingrediente);
    }

    @Test
    public void anadeIngredieneGetIngrediente_devuelveIngrediente() {
        IngredienteDetalladoRoomDto ingredienteDto = getIngredienteDetalladoRoomDto();
        ingredientesDao.insertarIngrediente(ingredienteDto);
        IngredienteDetalladoRoomDto ingredienteDevuelto = ingredientesDao.getIngrediente(id);
        Assert.assertNotNull(ingredienteDevuelto);
    }

    @Test
    public void anadeIngredieneGetIngrediente_devuelveIngredienteCorrectamente() {
        IngredienteDetalladoRoomDto ingredienteDto = getIngredienteDetalladoRoomDto();
        ingredientesDao.insertarIngrediente(ingredienteDto);
        IngredienteDetalladoRoomDto ingredienteDevuelto = ingredientesDao.getIngrediente(id);
        Assert.assertNotNull(ingredienteDevuelto);
        Assert.assertEquals(ingredienteDto.getId(),
                ingredienteDevuelto.getId());
    }


}
