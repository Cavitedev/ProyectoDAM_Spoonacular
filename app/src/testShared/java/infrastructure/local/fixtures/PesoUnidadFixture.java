package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.PesoUnidad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.PesoUnidadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.PesoUnidadGsonDto;

public class PesoUnidadFixture extends PropiedadFixture {
    private final double cantidad = 250.2;
    private final String unidad = "1";

    protected PesoUnidad getPesoPorUnidadDominio() {
        return new PesoUnidad(cantidad, unidad);
    }

    protected PesoUnidadRoomDto getPesoPorUnidadRoomDto() {
        return new PesoUnidadRoomDto(getPesoPorUnidadDominio());
    }


    protected PesoUnidadGsonDto getPesoPorUnidadGsonDto() {
        PesoUnidadGsonDto dto = new PesoUnidadGsonDto();
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        return dto;
    }
}
