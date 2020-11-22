package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.usecases;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.LlamadorApi;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ObtenerDetallesIngredienteUsecase {

    private Integer id;
    private Double cantidad;
    private String unidad;

    public ObtenerDetallesIngredienteUsecase(Integer id) {
        this.id = id;
    }

    public FutureTask<IngredienteDetallado> obtenerDetallesIngredienteEnOtroHilo() {
        Callable<IngredienteDetallado> callDetallesIngrediente = new Callable<IngredienteDetallado>() {
            @Override
            public IngredienteDetallado call() throws Exception {
                return LlamadorApi.getInstance().obtenerInformacionIngrediente(id, cantidad, unidad);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        FutureTask<IngredienteDetallado> futureTask = new FutureTask<>(callDetallesIngrediente);
        executor.submit(futureTask);
        return futureTask;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}
