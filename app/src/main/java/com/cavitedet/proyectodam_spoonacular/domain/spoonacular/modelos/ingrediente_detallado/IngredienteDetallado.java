package com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado;


import java.util.List;


public class IngredienteDetallado {

    private Integer id;

    private String original;

    private String nombreOriginal;

    private String nombre;

    private Double cantidad;

    private String unidadDeMedida;

    private String unidadDeMedidaReducida;

    private String unidadDeMedidaAlargada;

    private List<String> posiblesUnidades;

    private ValorEstimado valorEstimado;

    private String consistencia;

    private List<String> tiposDeUnidadesAlCobrar;

    private String categoria;

    private String imagen;

    private List<String> metaInformacion;

    private Nutricion nutricion;

    private List<String> caminoDeCategorias;

    public IngredienteDetallado(Integer id) {
        this.id = id;
    }

    public IngredienteDetallado(Integer id, String original, String nombreOriginal, String nombre, Double cantidad, String unidadDeMedida, String unidadDeMedidaReducida, String unidadDeMedidaAlargada, List<String> posiblesUnidades, ValorEstimado valorEstimado, String consistencia, List<String> tiposDeUnidadesAlCobrar, String categoria, String imagen, List<String> metaInformacion, Nutricion nutricion, List<String> caminoDeCategorias) {
        this.id = id;
        this.original = original;
        this.nombreOriginal = nombreOriginal;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadDeMedida = unidadDeMedida;
        this.unidadDeMedidaReducida = unidadDeMedidaReducida;
        this.unidadDeMedidaAlargada = unidadDeMedidaAlargada;
        this.posiblesUnidades = posiblesUnidades;
        this.valorEstimado = valorEstimado;
        this.consistencia = consistencia;
        this.tiposDeUnidadesAlCobrar = tiposDeUnidadesAlCobrar;
        this.categoria = categoria;
        this.imagen = imagen;
        this.metaInformacion = metaInformacion;
        this.nutricion = nutricion;
        this.caminoDeCategorias = caminoDeCategorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getUnidadDeMedidaReducida() {
        return unidadDeMedidaReducida;
    }

    public void setUnidadDeMedidaReducida(String unidadDeMedidaReducida) {
        this.unidadDeMedidaReducida = unidadDeMedidaReducida;
    }

    public String getUnidadDeMedidaAlargada() {
        return unidadDeMedidaAlargada;
    }

    public void setUnidadDeMedidaAlargada(String unidadDeMedidaAlargada) {
        this.unidadDeMedidaAlargada = unidadDeMedidaAlargada;
    }

    public List<String> getPosiblesUnidades() {
        return posiblesUnidades;
    }

    public void setPosiblesUnidades(List<String> posiblesUnidades) {
        this.posiblesUnidades = posiblesUnidades;
    }

    public ValorEstimado getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(ValorEstimado valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public String getConsistencia() {
        return consistencia;
    }

    public void setConsistencia(String consistencia) {
        this.consistencia = consistencia;
    }

    public List<String> getTiposDeUnidadesAlCobrar() {
        return tiposDeUnidadesAlCobrar;
    }

    public void setTiposDeUnidadesAlCobrar(List<String> tiposDeUnidadesAlCobrar) {
        this.tiposDeUnidadesAlCobrar = tiposDeUnidadesAlCobrar;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<String> getMetaInformacion() {
        return metaInformacion;
    }

    public void setMetaInformacion(List<String> metaInformacion) {
        this.metaInformacion = metaInformacion;
    }

    public Nutricion getNutricion() {
        return nutricion;
    }

    public void setNutricion(Nutricion nutricion) {
        this.nutricion = nutricion;
    }

    public List<String> getCaminoDeCategorias() {
        return caminoDeCategorias;
    }

    public void setCaminoDeCategorias(List<String> caminoDeCategorias) {
        this.caminoDeCategorias = caminoDeCategorias;
    }

    @Override
    public String toString() {
        return "IngredienteDetallado{" +
                "id=" + id +
                ", original='" + original + '\'' +
                ", nombreOriginal='" + nombreOriginal + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", unidadDeMedida='" + unidadDeMedida + '\'' +
                ", unidadDeMedidaReducida='" + unidadDeMedidaReducida + '\'' +
                ", unidadDeMedidaAlargada='" + unidadDeMedidaAlargada + '\'' +
                ", posiblesUnidades=" + posiblesUnidades +
                ", valorEstimado=" + valorEstimado +
                ", consistencia='" + consistencia + '\'' +
                ", tiposDeUnidadesAlCobrar=" + tiposDeUnidadesAlCobrar +
                ", categoria='" + categoria + '\'' +
                ", imagen='" + imagen + '\'' +
                ", metaInformacion=" + metaInformacion +
                ", nutricion=" + nutricion +
                ", caminoDeCategorias=" + caminoDeCategorias +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IngredienteDetallado)) return false;

        IngredienteDetallado that = (IngredienteDetallado) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getOriginal() != null ? !getOriginal().equals(that.getOriginal()) : that.getOriginal() != null)
            return false;
        if (getNombreOriginal() != null ? !getNombreOriginal().equals(that.getNombreOriginal()) : that.getNombreOriginal() != null)
            return false;
        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null)
            return false;
        if (getCantidad() != null ? !getCantidad().equals(that.getCantidad()) : that.getCantidad() != null)
            return false;
        if (getUnidadDeMedida() != null ? !getUnidadDeMedida().equals(that.getUnidadDeMedida()) : that.getUnidadDeMedida() != null)
            return false;
        if (getUnidadDeMedidaReducida() != null ? !getUnidadDeMedidaReducida().equals(that.getUnidadDeMedidaReducida()) : that.getUnidadDeMedidaReducida() != null)
            return false;
        if (getUnidadDeMedidaAlargada() != null ? !getUnidadDeMedidaAlargada().equals(that.getUnidadDeMedidaAlargada()) : that.getUnidadDeMedidaAlargada() != null)
            return false;
        if (getPosiblesUnidades() != null ? !getPosiblesUnidades().equals(that.getPosiblesUnidades()) : that.getPosiblesUnidades() != null)
            return false;
        if (getValorEstimado() != null ? !getValorEstimado().equals(that.getValorEstimado()) : that.getValorEstimado() != null)
            return false;
        if (getConsistencia() != null ? !getConsistencia().equals(that.getConsistencia()) : that.getConsistencia() != null)
            return false;
        if (getTiposDeUnidadesAlCobrar() != null ? !getTiposDeUnidadesAlCobrar().equals(that.getTiposDeUnidadesAlCobrar()) : that.getTiposDeUnidadesAlCobrar() != null)
            return false;
        if (getCategoria() != null ? !getCategoria().equals(that.getCategoria()) : that.getCategoria() != null)
            return false;
        if (getImagen() != null ? !getImagen().equals(that.getImagen()) : that.getImagen() != null)
            return false;
        if (getMetaInformacion() != null ? !getMetaInformacion().equals(that.getMetaInformacion()) : that.getMetaInformacion() != null)
            return false;
        if (getNutricion() != null ? !getNutricion().equals(that.getNutricion()) : that.getNutricion() != null)
            return false;
        return getCaminoDeCategorias() != null ? getCaminoDeCategorias().equals(that.getCaminoDeCategorias()) : that.getCaminoDeCategorias() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOriginal() != null ? getOriginal().hashCode() : 0);
        result = 31 * result + (getNombreOriginal() != null ? getNombreOriginal().hashCode() : 0);
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getCantidad() != null ? getCantidad().hashCode() : 0);
        result = 31 * result + (getUnidadDeMedida() != null ? getUnidadDeMedida().hashCode() : 0);
        result = 31 * result + (getUnidadDeMedidaReducida() != null ? getUnidadDeMedidaReducida().hashCode() : 0);
        result = 31 * result + (getUnidadDeMedidaAlargada() != null ? getUnidadDeMedidaAlargada().hashCode() : 0);
        result = 31 * result + (getPosiblesUnidades() != null ? getPosiblesUnidades().hashCode() : 0);
        result = 31 * result + (getValorEstimado() != null ? getValorEstimado().hashCode() : 0);
        result = 31 * result + (getConsistencia() != null ? getConsistencia().hashCode() : 0);
        result = 31 * result + (getTiposDeUnidadesAlCobrar() != null ? getTiposDeUnidadesAlCobrar().hashCode() : 0);
        result = 31 * result + (getCategoria() != null ? getCategoria().hashCode() : 0);
        result = 31 * result + (getImagen() != null ? getImagen().hashCode() : 0);
        result = 31 * result + (getMetaInformacion() != null ? getMetaInformacion().hashCode() : 0);
        result = 31 * result + (getNutricion() != null ? getNutricion().hashCode() : 0);
        result = 31 * result + (getCaminoDeCategorias() != null ? getCaminoDeCategorias().hashCode() : 0);
        return result;
    }
}
