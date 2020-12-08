package com.cavitedet.proyectodam_spoonacular.domain.repositorio;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.ApiException;

public interface IRepositorio {

    IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws ApiException;


    public Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda)
            throws ApiException;


}
