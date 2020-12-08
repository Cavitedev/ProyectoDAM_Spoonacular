package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Nutricion;
import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.Propiedad;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.NutricionRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.NutricionGsonDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.PropiedadGsonDto;

import java.util.Arrays;
import java.util.Collections;

public class NutricionFixture extends PesoUnidadFixture {


    protected Nutricion getNutricionDominio() {
        // Para testear el orden
        Propiedad prop2 = getPropiedadDominio();
        prop2.setNombre("a");
        prop2.setCantidad(0.0);
        prop2.setUnidad("g");
        return new Nutricion(Collections.singletonList(getNutrienteDominio()),
                Arrays.asList(getPropiedadDominio(), prop2),
                getDecomposicionCaloricaDominio(), getPesoPorUnidadDominio());
    }

    protected NutricionRoomDto getNutricionRoomDto() {
        return new NutricionRoomDto(getNutricionDominio());
    }

    protected NutricionRoomDto getNutricionDao() {
        NutricionRoomDto dto = new NutricionRoomDto();
        dto.setDescomposicionCalorica(getDecomposicionCaloricaRoomDto());
        dto.setPesoPorRacion(getPesoPorUnidadRoomDto());
        return dto;
    }


    protected NutricionGsonDto getNutricionGsonDto() {
        PropiedadGsonDto prop2 = getPropiedadGsonDto();
        prop2.setNombre("a");
        prop2.setCantidad(0.0);
        prop2.setUnidad("g");
        NutricionGsonDto dto = new NutricionGsonDto();
        dto.setNutrientes(Collections.singletonList(getNutrienteGsonDto()));
        dto.setPropiedades(Arrays.asList(getPropiedadGsonDto(), prop2));
        dto.setDescomposicionCalorica(getDecomposicionCaloricaGsonDto());
        dto.setPesoPorRacion(getPesoPorUnidadGsonDto());
        return dto;
    }


}
