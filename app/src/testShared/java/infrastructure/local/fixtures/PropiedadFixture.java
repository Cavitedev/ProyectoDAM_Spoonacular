package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.PropiedadGsonDto;

public class PropiedadFixture extends DecomposicionCaloricaFixture {
    private final String nombre = "Prop nombre";
    private final double cantidad = 23.2;
    private final String unidad = "g";

    protected Propiedad getPropiedadDominio() {
        return new Propiedad(nombre, cantidad, unidad);
    }

    protected PropiedadRoomDto getPropiedadRoomDto() {
        return new PropiedadRoomDto(getPropiedadDominio(), 0);
    }

    protected PropiedadGsonDto getPropiedadGsonDto() {
        PropiedadGsonDto dto = new PropiedadGsonDto();
        dto.setNombre(nombre);
        dto.setCantidad(cantidad);
        dto.setUnidad(unidad);
        return dto;
    }
}
