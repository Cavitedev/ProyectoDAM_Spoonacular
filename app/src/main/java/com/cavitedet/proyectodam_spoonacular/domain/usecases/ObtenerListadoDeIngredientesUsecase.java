package com.cavitedet.proyectodam_spoonacular.domain.usecases;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes.Ingredientes;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.ParametrosBuscarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.IngredientesRepositorio;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ObtenerListadoDeIngredientesUsecase {

    private ParametrosBuscarIngredientes parametrosBuscarIngredientes;

    public ObtenerListadoDeIngredientesUsecase(String query) {
        parametrosBuscarIngredientes = new ParametrosBuscarIngredientes(query);
        parametrosBuscarIngredientes.setSortDirection("desc");
        parametrosBuscarIngredientes.setSort("calories");
    }


    public FutureTask<Ingredientes> buscarIngredientesEnOtroHilo() {
        Callable<Ingredientes> callIngredientes = new Callable<Ingredientes>() {
            @Override
            public Ingredientes call() throws Exception {

                return IngredientesRepositorio.getInstance().busquedaIngredientes(parametrosBuscarIngredientes);

            }


        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<Ingredientes> futureTask = new FutureTask<>(callIngredientes);


        executor.submit(futureTask);
        executor.shutdown();
        return futureTask;
    }

    public ParametrosBuscarIngredientes getParametrosBuscarIngredientes() {
        return parametrosBuscarIngredientes;
    }

    public void setParametrosBuscarIngredientes(ParametrosBuscarIngredientes parametrosBuscarIngredientes) {
        this.parametrosBuscarIngredientes = parametrosBuscarIngredientes;
    }
}
