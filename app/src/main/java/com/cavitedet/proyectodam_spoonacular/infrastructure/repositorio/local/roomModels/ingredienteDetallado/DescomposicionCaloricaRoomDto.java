package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;


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

    @Override
    public String toString() {
        return "DescomposicionCalorica{" +
                "porcentajeProteinas=" + porcentajeProteinas +
                ", porcentajeGrasas=" + porcentajeGrasas +
                ", porcentajeCarbohidratos=" + porcentajeCarbohidratos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DescomposicionCaloricaRoomDto)) return false;

        DescomposicionCaloricaRoomDto that = (DescomposicionCaloricaRoomDto) o;

        if (getPorcentajeProteinas() != null ? !getPorcentajeProteinas().equals(that.getPorcentajeProteinas()) : that.getPorcentajeProteinas() != null)
            return false;
        if (getPorcentajeGrasas() != null ? !getPorcentajeGrasas().equals(that.getPorcentajeGrasas()) : that.getPorcentajeGrasas() != null)
            return false;
        return getPorcentajeCarbohidratos() != null ? getPorcentajeCarbohidratos().equals(that.getPorcentajeCarbohidratos()) : that.getPorcentajeCarbohidratos() == null;
    }

    @Override
    public int hashCode() {
        int result = getPorcentajeProteinas() != null ? getPorcentajeProteinas().hashCode() : 0;
        result = 31 * result + (getPorcentajeGrasas() != null ? getPorcentajeGrasas().hashCode() : 0);
        result = 31 * result + (getPorcentajeCarbohidratos() != null ? getPorcentajeCarbohidratos().hashCode() : 0);
        return result;
    }
}
