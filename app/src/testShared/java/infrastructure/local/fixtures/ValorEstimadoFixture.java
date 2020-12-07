package infrastructure.local.fixtures;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.ValorEstimado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.ValorEstimadoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.remoto.json_modelos.ingrediente_detallado.ValorEstimadoGsonDto;

public class ValorEstimadoFixture extends NutrienteFixture {
    private final double uniValor = 12.23;
    private final String uniMoneda = "€";

    protected ValorEstimado getValorEstimadoDominio() {
        return new ValorEstimado(uniValor, uniMoneda);
    }

    protected ValorEstimadoRoomDto getValorEstimadoRoomDto() {
        return new ValorEstimadoRoomDto(getValorEstimadoDominio());
    }

    protected ValorEstimadoGsonDto getValorEstimadoGsonDto() {
        ValorEstimadoGsonDto valEstim;
        valEstim = new ValorEstimadoGsonDto();
        valEstim.setUnidad(uniMoneda);
        valEstim.setValor(uniValor);
        return valEstim;
    }
}
