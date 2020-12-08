package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutriente;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.NutrienteGsonDto;

public class NutrienteFixture {
    private final String nombre = "Proteina";
    private final double cantidad = 12.3;
    private final String unidad = "g";
    private final double porcentajeDiario = 0.23;

    protected Nutriente getNutrienteDominio() {
        return new Nutriente(nombre, cantidad, unidad, porcentajeDiario);
    }

    protected NutrienteRoomDto getNutrienteRoomDto() {
        return new NutrienteRoomDto(getNutrienteDominio(), 0);
    }


    protected NutrienteGsonDto getNutrienteGsonDto() {
        NutrienteGsonDto dto = new NutrienteGsonDto();
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        dto.setPorcentajeNecesitadoAlDia(porcentajeDiario);
        return dto;
    }
}
