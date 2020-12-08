package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.listas;


import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.listas.MetaInfoRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class MetaInfoDaoTest {

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

        List<MetaInfoRoomDto> resultado = ingredientesDao.getMetaInfo(id);
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void anadePosibleUnidades_devuelveAlgo() {
        MetaInfoRoomDto elem =
                new MetaInfoRoomDto(id, "algo", 0);

        ingredientesDao.insertarMetainfo(elem);
        List<MetaInfoRoomDto> resultado = ingredientesDao.getMetaInfo(id);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void anadeTresCaminos_devuelve2DelMismoId() {
        MetaInfoRoomDto elem =
                new MetaInfoRoomDto(id, "elem1", 0);
        MetaInfoRoomDto elem2 =
                new MetaInfoRoomDto(id, "elem2", 1);
        MetaInfoRoomDto elem3 =
                new MetaInfoRoomDto(id + 1, "elem3", 2);

        ingredientesDao.insertarMetainfo(elem);
        ingredientesDao.insertarMetainfo(elem2);
        ingredientesDao.insertarMetainfo(elem3);

        List<MetaInfoRoomDto> resultado = ingredientesDao.getMetaInfo(id);
        Assert.assertEquals(2, resultado.size());
    }


}
