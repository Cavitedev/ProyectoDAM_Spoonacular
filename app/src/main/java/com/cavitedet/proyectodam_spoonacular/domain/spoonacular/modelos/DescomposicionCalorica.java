package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos;

import com.google.gson.annotations.SerializedName;

public class DescomposicionCalorica {

    @SerializedName("percentProtein")
    private Double porcentajeProteinas;

    @SerializedName("percentFats")
    private Double porcentajeGrasas;

    @SerializedName("percentCarbs")
    private Double porcentajeCarbohidratos;

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
