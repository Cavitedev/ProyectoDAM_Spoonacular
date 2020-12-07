package com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.ingrediente;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.IngredienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels.ingrediente.fixtures.IngredienteFixture;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class IngredienteRoomDtoTest extends IngredienteFixture {


    @Test
    public void ingredienteImplementaDominio() {
        Assert.assertTrue(IADominio.class.isAssignableFrom(IngredienteRoomDto.class));
    }

    @Test
    public void crearDesdeDominioFunciona() {
        Ingrediente ingrediente = getIngredienteDominio();
        IngredienteRoomDto ingredienteRoom = getIngredienteRoomDto();
        Assert.assertEquals(ingrediente.getId(), ingredienteRoom.getId());
        Assert.assertEquals(ingrediente.getNombre(), ingredienteRoom.getNombre());
        Assert.assertEquals(ingrediente.getImagen(), ingredienteRoom.getImagen());
    }

    @Test
    public void aDominioFunciona() {
        Ingrediente ingrediente = getIngredienteDominio();
        IngredienteRoomDto ingredienteRoom = getIngredienteRoomDto();
        Assert.assertEquals(ingrediente, ingredienteRoom.aDominio());
    }


}
