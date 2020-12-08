package com.cavitedet.proyectodam_spoonacular.infrastructure;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.IngredientesRepositorio;

import org.junit.Test;

public class IngredientesRepositorioTest {


    private int id = 1102047;

    @Test
    public void insertaYLeeElementoDevuelveElMismo() throws Exception {

        IngredienteDetallado ing = IngredientesRepositorio.getInstance().obtenerInformacionIngrediente(id, 1.0, null);

    }


}
