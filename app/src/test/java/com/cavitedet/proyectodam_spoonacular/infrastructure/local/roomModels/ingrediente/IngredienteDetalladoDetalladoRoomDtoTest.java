package com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.ingrediente;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.ingrediente.fixtures.IngredienteDetalladoFixture;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IngredienteDetalladoDetalladoRoomDtoTest extends IngredienteDetalladoFixture {


    @Test
    public void ingredienteImplementaDominio() {
        Assert.assertTrue(IADominio.class.isAssignableFrom(IngredienteDetalladoRoomDto.class));
    }

//    @Test
//    public void crearDesdeDominioFunciona() {
//        Ingrediente ingrediente = getIngredienteDominio();
//        IngredienteDetalladoRoomDto ingredienteRoom = getIngredienteRoomDto();
//        Assert.assertEquals(ingrediente.getId(), ingredienteRoom.getId());
//        Assert.assertEquals(ingrediente.getNombre(), ingredienteRoom.getNombre());
//        Assert.assertEquals(ingrediente.getImagen(), ingredienteRoom.getImagen());
//    }
//
//    @Test
//    public void aDominioFunciona() {
//        Ingrediente ingrediente = getIngredienteDominio();
//        IngredienteDetalladoRoomDto ingredienteRoom = getIngredienteRoomDto();
//        Assert.assertEquals(ingrediente, ingredienteRoom.aDominio());
//    }


}
