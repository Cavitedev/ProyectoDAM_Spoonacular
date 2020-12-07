package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

public class NutricionGsonDto implements IADominio<Nutricion> {

    @SerializedName("nutrients")
    private List<NutrienteGsonDto> nutrientes;

    @SerializedName("properties")
    private List<PropiedadGsonDto> propiedades;

    @SerializedName("caloricBreakdown")
    private DescomposicionCaloricaGsonDto descomposicionCalorica;

    @SerializedName("weightPerServing")
    private PesoUnidadGsonDto pesoPorRacion;

    @Override
    public Nutricion aDominio() {
        return new Nutricion(nutrientes.parallelStream().map(NutrienteGsonDto::aDominio).collect(Collectors.toList()),
                propiedades.parallelStream().map(PropiedadGsonDto::aDominio).collect(Collectors.toList()),
                descomposicionCalorica.aDominio()
                , pesoPorRacion.aDominio());

    }

    public List<NutrienteGsonDto> getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(List<NutrienteGsonDto> nutrientes) {
        this.nutrientes = nutrientes;
    }

    public List<PropiedadGsonDto> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<PropiedadGsonDto> propiedades) {
        this.propiedades = propiedades;
    }

    public DescomposicionCaloricaGsonDto getDescomposicionCalorica() {
        return descomposicionCalorica;
    }

    public void setDescomposicionCalorica(DescomposicionCaloricaGsonDto descomposicionCalorica) {
        this.descomposicionCalorica = descomposicionCalorica;
    }

    public PesoUnidadGsonDto getPesoPorRacion() {
        return pesoPorRacion;
    }

    public void setPesoPorRacion(PesoUnidadGsonDto pesoPorRacion) {
        this.pesoPorRacion = pesoPorRacion;
    }

    @Override
    public String toString() {
        return "Nutricion{" +
                "nutrientes=" + nutrientes +
                ", propiedades=" + propiedades +
                ", descomposicionCalorica=" + descomposicionCalorica +
                ", pesoPorRacion=" + pesoPorRacion +
                '}';
    }
}
