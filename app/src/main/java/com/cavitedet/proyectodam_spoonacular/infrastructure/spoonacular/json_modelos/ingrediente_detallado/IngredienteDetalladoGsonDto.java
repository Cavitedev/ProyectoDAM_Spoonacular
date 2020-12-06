package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.ingrediente_detallado;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import static com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil.getGson;

/**
 * Detalles de un ingrediente que devuelve en esta api https://spoonacular.com/food-api/docs#Get-Ingredient-Information
 */
public class IngredienteDetalladoGsonDto implements IADominio<IngredienteDetallado> {

    @SerializedName("id")
    private Integer id;

    @SerializedName("original")
    private String original;

    @SerializedName("originalName")
    private String nombreOriginal;

    @SerializedName("name")
    private String nombre;

    @SerializedName("amount")
    private Double cantidad;

    @SerializedName("unit")
    private String unidadDeMedida;

    @SerializedName("unitShort")
    private String unidadDeMedidaReducida;

    @SerializedName("unitLong")
    private String unidadDeMedidaAlargada;

    @SerializedName("possibleUnits")
    private List<String> posiblesUnidades;

    @SerializedName("estimatedCost")
    private ValorEstimadoGsonDto valorEstimado;

    @SerializedName("consistency")
    private String consistencia;

    @SerializedName("shoppingListUnits")
    private List<String> tiposDeUnidadesAlCobrar;

    @SerializedName("aisle")
    private String categoria;

    @SerializedName("image")
    private String imagen;

    @SerializedName("meta")
    private List<String> metaInformacion;

    @SerializedName("nutrition")
    private NutricionGsonDto nutricion;

    @SerializedName("categoryPath")
    private List<String> caminoDeCategorias;

    public static IngredienteDetalladoGsonDto desdeJson(String json) {
        return getGson().fromJson(json, new TypeToken<IngredienteDetalladoGsonDto>() {
        }.getType());
    }

    @Override
    public IngredienteDetallado aDominio() {
        return new IngredienteDetallado(id,
                original,
                nombreOriginal,
                nombre,
                cantidad,
                unidadDeMedida,
                unidadDeMedidaReducida,
                unidadDeMedidaAlargada,
                posiblesUnidades,
                valorEstimado.aDominio(),
                consistencia,
                tiposDeUnidadesAlCobrar,
                categoria,
                imagen,
                metaInformacion,
                nutricion.aDominio(),
                caminoDeCategorias
        );
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

    public ValorEstimadoGsonDto getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(ValorEstimadoGsonDto valorEstimado) {
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

    public NutricionGsonDto getNutricion() {
        return nutricion;
    }

    public void setNutricion(NutricionGsonDto nutricion) {
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


}
