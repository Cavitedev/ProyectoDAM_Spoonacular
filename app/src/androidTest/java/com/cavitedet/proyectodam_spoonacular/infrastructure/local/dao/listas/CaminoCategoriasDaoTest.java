package com.cavitedet.proyectodam_spoonacular.infrastructure.local.dao.listas;


import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

@RunWith(JUnit4.class)
public class CaminoCategoriasDaoTest {

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
    public void getCaminoCategoriaDevuelveNulo() {
        List<CaminoCategoriasRoomDto> categorias = ingredientesDao.getCategorias(id);
        Assert.assertTrue(categorias.isEmpty());
    }

    @Test
    public void anadeCaminoCategoria_devuelveAlgo() {
        CaminoCategoriasRoomDto caminoCategorias =
                new CaminoCategoriasRoomDto(id, "fruta");

        ingredientesDao.insertarCaminoCategoria(caminoCategorias);
        List<CaminoCategoriasRoomDto> caminosDevueltos = ingredientesDao.getCategorias(id);
        Assert.assertNotNull(caminosDevueltos);
    }

    @Test
    public void anadeTresCaminos_devuelve2DelMismoId() {
        CaminoCategoriasRoomDto caminoCategorias =
                new CaminoCategoriasRoomDto(id, "fruta");
        CaminoCategoriasRoomDto caminoCategorias2 =
                new CaminoCategoriasRoomDto(id, "verdura");
        CaminoCategoriasRoomDto caminoCategorias3 =
                new CaminoCategoriasRoomDto(id + 1, "carne");

        ingredientesDao.insertarCaminoCategoria(caminoCategorias);
        ingredientesDao.insertarCaminoCategoria(caminoCategorias2);
        ingredientesDao.insertarCaminoCategoria(caminoCategorias3);

        List<CaminoCategoriasRoomDto> caminosDevueltos = ingredientesDao.getCategorias(id);
        Assert.assertEquals(2, caminosDevueltos.size());
    }


}
