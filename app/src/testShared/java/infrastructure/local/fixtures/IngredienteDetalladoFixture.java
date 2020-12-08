package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.IngredienteDetalladoGsonDto;

import java.util.Arrays;
import java.util.List;

public class IngredienteDetalladoFixture extends NutricionFixture {
    protected static final int id = 5;
    private static final String original = "Original";
    private static final String nombreOriginal = "Nombre original";
    private static final String nombre = "Nombre";
    private static final double cantidad = 123;
    private static final String unidadMedida = "Kilo";
    private static final String unidadReducida = "Kg";
    private static final String unidadAlargada = "Kilogramo";
    private static final List<String> unidades = Arrays.asList("g", "tonelada", "kg");
    private static final String consistencia = "solida";
    private static final List<String> tiposDeUnidadesAlCobrar = Arrays.asList("€", "$");
    private static final String categoria = "Categoria";
    private static final String imagen = "imag";
    private static final List<String> metaInfo = Arrays.asList("info", "more info", "less info");
    private static final List<String> caminoCategorias = Arrays.asList("Fruta", "Vegetal", "Comida");


    protected IngredienteDetallado getIngredienteDetalladoDominio() {
        return new IngredienteDetallado
                (id, original, nombreOriginal, nombre, cantidad, unidadMedida, unidadReducida, unidadAlargada,
                        unidades, getValorEstimadoDominio(), consistencia, tiposDeUnidadesAlCobrar,
                        categoria, imagen, metaInfo, getNutricionDominio(), caminoCategorias);
    }

    protected IngredienteDetalladoRoomDto getIngredienteDetalladoRoomDto() {
        return new IngredienteDetalladoRoomDto(getIngredienteDetalladoDominio());
    }

    protected IngredienteDetalladoRoomDto getIngredienteDetalladoDao() {
        IngredienteDetalladoRoomDto dto = new IngredienteDetalladoRoomDto();
        dto.setId(id);
        dto.setOriginal(original);
        dto.setNombreOriginal(nombreOriginal);
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidadDeMedida(unidadMedida);
        dto.setUnidadDeMedidaReducida(unidadReducida);
        dto.setUnidadDeMedidaAlargada(unidadAlargada);
        dto.setConsistencia(consistencia);
        dto.setCategoria(categoria);
        dto.setImagen(imagen);
        dto.setValorEstimado(getValorEstimadoRoomDto());
        dto.setNutricion(getNutricionDao());
        return dto;
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
