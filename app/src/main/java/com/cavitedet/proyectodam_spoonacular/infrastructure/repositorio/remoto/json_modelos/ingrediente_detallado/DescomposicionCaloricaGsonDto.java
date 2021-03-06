package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.DescomposicionCalorica;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;

public class DescomposicionCaloricaGsonDto implements IADominio<DescomposicionCalorica> {

    @SerializedName("percentProtein")
    private Double porcentajeProteinas;

    @SerializedName("percentFats")
    private Double porcentajeGrasas;

    @SerializedName("percentCarbs")
    private Double porcentajeCarbohidratos;

    @Override
    public DescomposicionCalorica aDominio() {
        return new DescomposicionCalorica(porcentajeProteinas, porcentajeGrasas, porcentajeCarbohidratos);
    }


    public Double getPorcentajeProteinas() {
        return porcentajeProteinas;
    }

    public void setPorcentajeProteinas(Double porcentajeProteinas) {
        this.porcentajeProteinas = porcentajeProteinas;
    }

    public Double getPorcentajeGrasas() {
        return porcentajeGrasas;
    }

    public void setPorcentajeGrasas(Double porcentajeGrasas) {
        this.porcentajeGrasas = porcentajeGrasas;
    }

    public Double getPorcentajeCarbohidratos() {
        return porcentajeCarbohidratos;
    }

    public void setPorcentajeCarbohidratos(Double porcentajeCarbohidratos) {
        this.porcentajeCarbohidratos = porcentajeCarbohidratos;
    }

    @Override
    public String toString() {
        return "DescomposicionCalorica{" +
                "porcentajeProteinas=" + porcentajeProteinas +
                ", porcentajeGrasas=" + porcentajeGrasas +
                ", porcentajeCarbohidratos=" + porcentajeCarbohidratos +
                '}';
    }


}
