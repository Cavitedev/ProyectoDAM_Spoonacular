package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.listas;


import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class TipoUnidadesCobrarDaoTest {

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

        List<TipoUnidadesAlCobrarRoomDto> resultado = ingredientesDao.getUnidadesCobrar(id);
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void anadePosibleUnidades_devuelveAlgo() {
        TipoUnidadesAlCobrarRoomDto elem =
                new TipoUnidadesAlCobrarRoomDto(id, "algo");

        ingredientesDao.insertarUnidadCobrar(elem);
        List<TipoUnidadesAlCobrarRoomDto> resultado = ingredientesDao.getUnidadesCobrar(id);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void anadeTresCaminos_devuelve2DelMismoId() {
        TipoUnidadesAlCobrarRoomDto elem =
                new TipoUnidadesAlCobrarRoomDto(id, "elem1");
        TipoUnidadesAlCobrarRoomDto elem2 =
                new TipoUnidadesAlCobrarRoomDto(id, "elem2");
        TipoUnidadesAlCobrarRoomDto elem3 =
                new TipoUnidadesAlCobrarRoomDto(id + 1, "elem3");

        ingredientesDao.insertarUnidadCobrar(elem);
        ingredientesDao.insertarUnidadCobrar(elem2);
        ingredientesDao.insertarUnidadCobrar(elem3);

        List<TipoUnidadesAlCobrarRoomDto> resultado = ingredientesDao.getUnidadesCobrar(id);
        Assert.assertEquals(2, resultado.size());
    }


}
