package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado;


import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.DescomposicionCalorica;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;

public class DescomposicionCaloricaRoomDto implements IADominio<DescomposicionCalorica> {

    private Double porcentajeProteinas;

    private Double porcentajeGrasas;

    private Double porcentajeCarbohidratos;

    public DescomposicionCaloricaRoomDto() {
    }

    public DescomposicionCaloricaRoomDto(DescomposicionCalorica dominio) {
        this.porcentajeProteinas = dominio.getPorcentajeProteinas();
        this.porcentajeGrasas = dominio.getPorcentajeGrasas();
        this.porcentajeCarbohidratos = dominio.getPorcentajeCarbohidratos();
    }

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


}
