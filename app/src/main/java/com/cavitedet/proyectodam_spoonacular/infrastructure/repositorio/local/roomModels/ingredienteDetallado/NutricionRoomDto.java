package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;


import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

import java.util.List;
import java.util.stream.Collectors;

public class NutricionRoomDto implements IADominio<Nutricion> {

    private List<NutrienteRoomDto> nutrientes;

    private List<PropiedadRoomDto> propiedades;

    private DescomposicionCaloricaRoomDto descomposicionCalorica;

    private PesoUnidadRoomDto pesoPorRacion;

    public NutricionRoomDto() {
    }

    public NutricionRoomDto(Nutricion dominio) {
        this.nutrientes = dominio.getNutrientes().parallelStream().map(
                NutrienteRoomDto::new
        ).collect(Collectors.toList());

        this.propiedades = dominio.getPropiedades().parallelStream().map(
                PropiedadRoomDto::new
        ).collect(Collectors.toList());
        this.descomposicionCalorica = new DescomposicionCaloricaRoomDto(dominio.getDescomposicionCalorica());
        this.pesoPorRacion = new PesoUnidadRoomDto(dominio.getPesoPorRacion());
    }

    @Override
    public Nutricion aDominio() {
        return new Nutricion(
                nutrientes.parallelStream().map(NutrienteRoomDto::aDominio).collect(Collectors.toList())
                , propiedades.parallelStream().map(PropiedadRoomDto::aDominio).collect(Collectors.toList())
                , descomposicionCalorica.aDominio()
                , pesoPorRacion.aDominio());
    }

    public List<NutrienteRoomDto> getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(List<NutrienteRoomDto> nutrientes) {
        this.nutrientes = nutrientes;
    }

    public List<PropiedadRoomDto> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<PropiedadRoomDto> propiedades) {
        this.propiedades = propiedades;
    }

    public DescomposicionCaloricaRoomDto getDescomposicionCalorica() {
        return descomposicionCalorica;
    }

    public void setDescomposicionCalorica(DescomposicionCaloricaRoomDto descomposicionCalorica) {
        this.descomposicionCalorica = descomposicionCalorica;
    }

    public PesoUnidadRoomDto getPesoPorRacion() {
        return pesoPorRacion;
    }

    public void setPesoPorRacion(PesoUnidadRoomDto pesoPorRacion) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NutricionRoomDto)) return false;

        NutricionRoomDto nutricion = (NutricionRoomDto) o;

        if (getNutrientes() != null ? !getNutrientes().equals(nutricion.getNutrientes()) : nutricion.getNutrientes() != null)
            return false;
        if (getPropiedades() != null ? !getPropiedades().equals(nutricion.getPropiedades()) : nutricion.getPropiedades() != null)
            return false;
        if (getDescomposicionCalorica() != null ? !getDescomposicionCalorica().equals(nutricion.getDescomposicionCalorica()) : nutricion.getDescomposicionCalorica() != null)
            return false;
        return getPesoPorRacion() != null ? getPesoPorRacion().equals(nutricion.getPesoPorRacion()) : nutricion.getPesoPorRacion() == null;
    }

    @Override
    public int hashCode() {
        int result = getNutrientes() != null ? getNutrientes().hashCode() : 0;
        result = 31 * result + (getPropiedades() != null ? getPropiedades().hashCode() : 0);
        result = 31 * result + (getDescomposicionCalorica() != null ? getDescomposicionCalorica().hashCode() : 0);
        result = 31 * result + (getPesoPorRacion() != null ? getPesoPorRacion().hashCode() : 0);
        return result;
    }


}
