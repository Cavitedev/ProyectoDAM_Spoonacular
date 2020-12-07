package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.listas;


import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class PosiblesUnidadesDaoTest {

    private final int id = 10000;
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
    public void getPosiblesUnidadesDevuelveNulo() {

        List<PosiblesUnidadesRoomDto> resultado = ingredientesDao.getPosiblesUnidades(id);
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void anadePosibleUnidades_devuelveAlgo() {
        PosiblesUnidadesRoomDto elem =
                new PosiblesUnidadesRoomDto(id, "algo");

        ingredientesDao.insertarPosibleUnidad(elem);
        List<PosiblesUnidadesRoomDto> resultado = ingredientesDao.getPosiblesUnidades(id);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void anadeTresCaminos_devuelve2DelMismoId() {
        PosiblesUnidadesRoomDto elem =
                new PosiblesUnidadesRoomDto(id, "elem1");
        PosiblesUnidadesRoomDto elem2 =
                new PosiblesUnidadesRoomDto(id, "elem2");
        PosiblesUnidadesRoomDto elem3 =
                new PosiblesUnidadesRoomDto(id + 1, "elem3");

        ingredientesDao.insertarPosibleUnidad(elem);
        ingredientesDao.insertarPosibleUnidad(elem2);
        ingredientesDao.insertarPosibleUnidad(elem3);

        List<PosiblesUnidadesRoomDto> resultado = ingredientesDao.getPosiblesUnidades(id);
        Assert.assertEquals(2, resultado.size());
    }


}
