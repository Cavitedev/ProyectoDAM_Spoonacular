package com.cavitedet.proyectodam_spoonacular.domain.repositorio;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.DataSourceException;

public interface IFuenteDeDatos {
    Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda) throws DataSourceException;

    IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws DataSourceException;

}
