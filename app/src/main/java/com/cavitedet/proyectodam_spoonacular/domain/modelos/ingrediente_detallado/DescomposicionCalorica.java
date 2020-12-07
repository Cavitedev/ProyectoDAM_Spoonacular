package com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado;


public class DescomposicionCalorica {

    private Double porcentajeProteinas;

    private Double porcentajeGrasas;

    private Double porcentajeCarbohidratos;

    public DescomposicionCalorica() {
    }

    public DescomposicionCalorica(Double porcentajeProteinas, Double porcentajeGrasas, Double porcentajeCarbohidratos) {
        this.porcentajeProteinas = porcentajeProteinas;
        this.porcentajeGrasas = porcentajeGrasas;
        this.porcentajeCarbohidratos = porcentajeCarbohidratos;
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
        if (!(o instanceof DescomposicionCalorica)) return false;

        DescomposicionCalorica that = (DescomposicionCalorica) o;

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
