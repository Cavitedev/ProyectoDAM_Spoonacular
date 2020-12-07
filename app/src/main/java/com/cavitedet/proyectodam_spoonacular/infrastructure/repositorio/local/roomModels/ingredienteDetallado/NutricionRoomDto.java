package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;


import androidx.room.Embedded;
import androidx.room.Ignore;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

import java.util.List;
import java.util.stream.Collectors;


public class NutricionRoomDto implements IADominio<Nutricion> {


    @Ignore
    private List<NutrienteRoomDto> nutrientes;

    @Ignore
    private List<PropiedadRoomDto> propiedades;

    @Embedded
    private DescomposicionCaloricaRoomDto descomposicionCalorica;

    @Embedded
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

        List<Nutriente> nutrientes = null;
        if (this.nutrientes != null)
            nutrientes = this.nutrientes.parallelStream().map(NutrienteRoomDto::aDominio).collect(Collectors.toList());

        List<Propiedad> propiedades = null;
        if (this.propiedades != null) {
            propiedades = this.propiedades.parallelStream().map(PropiedadRoomDto::aDominio).collect(Collectors.toList());
        }


        return new Nutricion(nutrientes
                , propiedades
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


}
