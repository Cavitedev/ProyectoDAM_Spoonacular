package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.nutricion;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.NutrienteRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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
    public void anadeNutrientes_devuelveAlgo() {
        NutrienteRoomDto elem =
                new NutrienteRoomDto();
        elem.setIdDetalles(id);
        elem.setNombre("prot");
        elem.setCantidad(12.4);
        elem.setPorcentajeNecesitadoAlDia(12.3);
        elem.setUnidad("g");

        ingredientesDao.insertarNutriente(elem);
        List<NutrienteRoomDto> resultado = ingredientesDao.getNutrientes(id);
        Assert.assertNotNull(resultado);
    }

    @Test
    public void anade2_devuelveEnOrden() {
        NutrienteRoomDto elem =
                new NutrienteRoomDto();
        elem.setIdDetalles(id);
        elem.setNombre("prot");
        elem.setCantidad(12.4);
        elem.setPorcentajeNecesitadoAlDia(12.3);
        elem.setUnidad("g");
        elem.setIndice(0);


        NutrienteRoomDto elem2 =
                new NutrienteRoomDto();
        elem2.setIdDetalles(id);
        elem2.setNombre("fat");
        elem2.setCantidad(12.4);
        elem2.setPorcentajeNecesitadoAlDia(12.3);
        elem2.setUnidad("g");
        elem2.setIndice(1);

        ingredientesDao.insertarNutriente(elem);
        ingredientesDao.insertarNutriente(elem2);
        List<NutrienteRoomDto> resultado = ingredientesDao.getNutrientes(id);
        Assert.assertEquals(Arrays.asList(elem, elem2), resultado);
    }


}
