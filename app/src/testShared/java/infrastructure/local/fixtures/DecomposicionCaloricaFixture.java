package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.DescomposicionCalorica;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.DescomposicionCaloricaRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.DescomposicionCaloricaGsonDto;

public class DecomposicionCaloricaFixture extends ValorEstimadoFixture {
    private final double proteinas = 10.0;
    private final double grasas = 20.0;
    private final double carbohidratos = 30.0;

    protected DescomposicionCalorica getDecomposicionCaloricaDominio() {
        return new DescomposicionCalorica(proteinas, grasas, carbohidratos);
    }

    protected DescomposicionCaloricaRoomDto getDecomposicionCaloricaRoomDto() {
        return new DescomposicionCaloricaRoomDto(getDecomposicionCaloricaDominio());
    }

    protected DescomposicionCaloricaGsonDto getDecomposicionCaloricaGsonDto() {
        DescomposicionCaloricaGsonDto dto = new DescomposicionCaloricaGsonDto();
        dto.setPorcentajeProteinas(10.0);
        dto.setPorcentajeGrasas(20.0);
        dto.setPorcentajeCarbohidratos(30.0);
        return dto;
    }


}
