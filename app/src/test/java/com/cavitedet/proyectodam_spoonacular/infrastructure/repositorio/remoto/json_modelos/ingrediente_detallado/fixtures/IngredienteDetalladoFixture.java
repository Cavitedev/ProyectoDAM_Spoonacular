package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.IngredienteDetalladoGsonDto;

import java.util.Arrays;
import java.util.List;

public class IngredienteDetalladoFixture extends NutricionFixture {
    private final int id = 5;
    private final String original = "Original";
    private final String nombreOriginal = "Nombre original";
    private final String nombre = "Nombre";
    private final double cantidad = 123;
    private final String unidadMedida = "Kilo";
    private final String unidadReducida = "Kg";
    private final String unidadAlargada = "Kilogramo";
    private final List<String> unidades = Arrays.asList("g", "tonelada");
    private final String consistencia = "solida";
    private final List<String> tiposDeUnidadesAlCobrar = Arrays.asList("€", "$");
    private final String categoria = "Categoria";
    private final String imagen = "imag";
    private final List<String> metaInfo = Arrays.asList("info", "more info");
    private final List<String> caminoCategorias = Arrays.asList("Fruta", "Vegetal", "Comida");

    protected IngredienteDetallado getIngredienteDetalladoDominio() {
        return new IngredienteDetallado
                (id, original, nombreOriginal, nombre, cantidad, unidadMedida, unidadReducida, unidadAlargada,
                        unidades, getValorEstimadoDominio(), consistencia, tiposDeUnidadesAlCobrar,
                        categoria, imagen, metaInfo, getNutricionDominio(), caminoCategorias);
    }

    protected IngredienteDetalladoGsonDto getIngredienteDetalladoGsonDto() {
        IngredienteDetalladoGsonDto dto = new IngredienteDetalladoGsonDto();
        dto.setId(id);
        dto.setOriginal(original);
        dto.setNombreOriginal(nombreOriginal);
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidadDeMedida(unidadMedida);
        dto.setUnidadDeMedidaReducida(unidadReducida);
        dto.setUnidadDeMedidaAlargada(unidadAlargada);
        dto.setPosiblesUnidades(unidades);
        dto.setValorEstimado(getValorEstimadoGsonDto());
        dto.setConsistencia(consistencia);
        dto.setTiposDeUnidadesAlCobrar(tiposDeUnidadesAlCobrar);
        dto.setCategoria(categoria);
        dto.setImagen(imagen);
        dto.setMetaInformacion(metaInfo);
        dto.setNutricion(getNutricionGsonDto());
        dto.setCaminoDeCategorias(caminoCategorias);
        return dto;
    }
}
