package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.nutricion;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.PropiedadRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PropiedadDaoTest {

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

        List<PropiedadRoomDto> resultado = ingredientesDao.getPropiedades(id);
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void anadePosibleUnidades_devuelveAlgo() {
        PropiedadRoomDto elem =
                new PropiedadRoomDto();
        elem.setIdDetalles(id);
        elem.setNombre("prot");
        elem.setCantidad(12.4);
        elem.setUnidad("g");

        ingredientesDao.insertarPropiedad(elem);
        List<PropiedadRoomDto> resultado = ingredientesDao.getPropiedades(id);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void anade2_devuelveEnOrden() {
        PropiedadRoomDto elem =
                new PropiedadRoomDto();
        elem.setIdDetalles(id);
        elem.setNombre("prot");
        elem.setCantidad(12.4);
        elem.setUnidad("g");
        elem.setIndice(0);

        PropiedadRoomDto elem2 =
                new PropiedadRoomDto();
        elem2.setIdDetalles(id);
        elem2.setNombre("fats");
        elem2.setCantidad(12.4);
        elem2.setUnidad("g");
        elem2.setIndice(1);

        ingredientesDao.insertarPropiedad(elem);
        ingredientesDao.insertarPropiedad(elem2);
        List<PropiedadRoomDto> resultado = ingredientesDao.getPropiedades(id);
        Assert.assertEquals(Arrays.asList(elem, elem2), resultado);
    }


}
