package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado;


import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.ValorEstimado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;

import java.util.List;

@Entity(tableName = RoomConstantes.INGREDIENTES_NOMBRE_TABLA)
public class IngredienteDetalladoRoomDto implements IADominio<IngredienteDetallado> {

    @PrimaryKey
    private Integer id;

    private String original;

    private String nombreOriginal;

    private String nombre;

    private Double cantidad;

    private String unidadDeMedida;

    private String unidadDeMedidaReducida;

    private String unidadDeMedidaAlargada;

    @Ignore
    private List<String> posiblesUnidades;

    @Embedded
    private ValorEstimadoRoomDto valorEstimado;

    private String consistencia;

    @Ignore
    private List<String> tiposDeUnidadesAlCobrar;

    private String categoria;

    private String imagen;

    @Ignore
    private List<String> metaInformacion;

    @Embedded
    private NutricionRoomDto nutricion;

    @Ignore
    private List<String> caminoDeCategorias;


    public IngredienteDetalladoRoomDto() {
    }

    public IngredienteDetalladoRoomDto(@NonNull IngredienteDetallado dominio) {
        this.id = dominio.getId();
        this.original = dominio.getOriginal();
        this.nombreOriginal = dominio.getNombreOriginal();
        this.nombre = dominio.getNombre();
        this.cantidad = dominio.getCantidad();
        this.unidadDeMedida = dominio.getUnidadDeMedida();
        this.unidadDeMedidaReducida = dominio.getUnidadDeMedidaReducida();
        this.unidadDeMedidaAlargada = dominio.getUnidadDeMedidaAlargada();
        this.posiblesUnidades = dominio.getPosiblesUnidades();
        this.valorEstimado = new ValorEstimadoRoomDto(dominio.getValorEstimado());
        this.consistencia = dominio.getConsistencia();
        this.tiposDeUnidadesAlCobrar = dominio.getTiposDeUnidadesAlCobrar();
        this.categoria = dominio.getCategoria();
        this.imagen = dominio.getImagen();
        this.nutricion = new NutricionRoomDto(dominio.getNutricion());
        this.caminoDeCategorias = dominio.getCaminoDeCategorias();
    }


    @Override
    public IngredienteDetallado aDominio() {
        ValorEstimado valorEstimado = null;
        if (this.valorEstimado != null)
            valorEstimado = this.valorEstimado.aDominio();

        Nutricion nutricion = null;
        if (this.nutricion != null)
            nutricion = this.nutricion.aDominio();

        return new IngredienteDetallado(id, original, nombreOriginal, nombre, cantidad, unidadDeMedida
                , unidadDeMedidaReducida, unidadDeMedidaAlargada, posiblesUnidades, valorEstimado, consistencia, tiposDeUnidadesAlCobrar, categoria,
                imagen, metaInformacion, nutricion, caminoDeCategorias);

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

    public ValorEstimadoRoomDto getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(ValorEstimadoRoomDto valorEstimado) {
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

    public NutricionRoomDto getNutricion() {
        return nutricion;
    }

    public void setNutricion(NutricionRoomDto nutricion) {
        this.nutricion = nutricion;
    }

    public List<String> getCaminoDeCategorias() {
        return caminoDeCategorias;
    }

    public void setCaminoDeCategorias(List<String> caminoDeCategorias) {
        this.caminoDeCategorias = caminoDeCategorias;
    }
}
