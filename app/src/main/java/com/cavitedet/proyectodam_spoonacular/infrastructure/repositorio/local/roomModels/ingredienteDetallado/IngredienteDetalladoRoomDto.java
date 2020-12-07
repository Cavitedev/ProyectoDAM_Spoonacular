package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.RoomConstantes;

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

    //    private PosiblesUnidadesRoomDto posiblesUnidades;
//
//    private ValorEstimadoRoomDto valorEstimado;
//
//    private String consistencia;
//
//    private TipoUnidadesAlCobrar tiposDeUnidadesAlCobrar;
//
//    private String categoria;
//
//    private String imagen;
//
//
//    private NutricionRoomDto nutricion;
    private Integer caminoDeCategoriasId;

    public IngredienteDetalladoRoomDto() {
    }

    public IngredienteDetalladoRoomDto(IngredienteDetallado dominio) {
        this.id = dominio.getId();
        this.original = dominio.getOriginal();
        this.nombreOriginal = dominio.getNombreOriginal();
        this.nombre = dominio.getNombre();
        this.cantidad = dominio.getCantidad();
        this.unidadDeMedida = dominio.getUnidadDeMedida();
        this.unidadDeMedidaReducida = dominio.getUnidadDeMedidaReducida();
        this.unidadDeMedidaAlargada = dominio.getUnidadDeMedidaAlargada();
//        this.posiblesUnidades = dominio.getPosiblesUnidades();
////        this.valorEstimado = new ValorEstimadoRoomDto(dominio.getValorEstimado()).aDomino();
//        this.consistencia = dominio.getConsistencia();
//        this.tiposDeUnidadesAlCobrar = dominio.getTiposDeUnidadesAlCobrar();
//        this.categoria = dominio.getCategoria();
//        this.imagen = dominio.getImagen();
//        this.nutricion = new NutricionRoomDto(dominio.getNutricion()).aDominio();
//        this.caminoDeCategorias = dominio.getCaminoDeCategorias();
    }

    public Integer getCaminoDeCategoriasId() {
        return caminoDeCategoriasId;
    }

    public void setCaminoDeCategoriasId(Integer caminoDeCategoriasId) {
        this.caminoDeCategoriasId = caminoDeCategoriasId;
    }

    @Override
    public IngredienteDetallado aDominio() {
        IngredienteDetallado dominio = new IngredienteDetallado(id);
        return dominio;
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


}
