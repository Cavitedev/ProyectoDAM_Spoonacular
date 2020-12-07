package com.cavitedet.proyectodam_spoonacular.domain.repositorio;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;

public interface IFuenteDeDatos {
    Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda) throws Exception;

    IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws Exception;

}
