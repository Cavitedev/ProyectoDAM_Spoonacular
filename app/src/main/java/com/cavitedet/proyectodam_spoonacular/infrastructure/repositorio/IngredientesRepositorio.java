package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio;

import android.content.Context;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.IRepositorio;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.LlamadorDatosLocales;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.LocalSourceException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.ApiException;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.LlamadorApi;

public class IngredientesRepositorio implements IRepositorio {

    private static IngredientesRepositorio instance;
    private Context context;

    public IngredientesRepositorio(Context context) {
        this.context = context;
    }

    public static IngredientesRepositorio getInstance() {
        if (instance == null) {
            instance = new IngredientesRepositorio(null);
        }
        return instance;
    }

    public static IngredientesRepositorio buildInstance(Context context) {
        instance = new IngredientesRepositorio(context);
        return instance;
    }

    @Override
    public IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws ApiException {
        if (context == null)
            return LlamadorApi.getInstance().obtenerInformacionIngrediente(id, amount, unit);

        try {
            return LlamadorDatosLocales.getInstance(context).obtenerInformacionIngrediente(id, amount, unit);
        } catch (LocalSourceException e) {
            IngredienteDetallado ing = LlamadorApi.getInstance().obtenerInformacionIngrediente(id, amount, unit);

            new Thread() {
                @Override
                public void run() {
                    LlamadorDatosLocales.getInstance(context).insertarIngrediente(ing);
                }
            }.start();

            return ing;

        }

    }

    @Override
    public Ingredientes busquedaIngredientes(ParametrosBuscarIngredientes parametrosBusqueda) throws ApiException {
        return LlamadorApi.getInstance().busquedaIngredientes(parametrosBusqueda);
    }
}
