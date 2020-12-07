package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.nutricion;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.PropiedadRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        elem.setUnidad("cm");

        ingredientesDao.insertarPropiedad(elem);
        List<PropiedadRoomDto> resultado = ingredientesDao.getPropiedades(id);
        Assert.assertNotNull(resultado);
    }


}
