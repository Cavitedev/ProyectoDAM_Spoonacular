package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.nutricion;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.NutrienteRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class NutrienteDaoTest {

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

        List<NutrienteRoomDto> resultado = ingredientesDao.getNutrientes(id);
        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void anadePosibleUnidades_devuelveAlgo() {
        NutrienteRoomDto elem =
                new NutrienteRoomDto();
        elem.setIdDetalles(id);
        elem.setNombre("prot");
        elem.setCantidad(12.4);
        elem.setPorcentajeNecesitadoAlDia(12.3);
        elem.setUnidad("cm");

        ingredientesDao.insertarNutriente(elem);
        List<NutrienteRoomDto> resultado = ingredientesDao.getNutrientes(id);
        Assert.assertNotNull(resultado);
    }


}
