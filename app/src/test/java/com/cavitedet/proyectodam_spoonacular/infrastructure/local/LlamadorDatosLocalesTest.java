package com.cavitedet.proyectodam_spoonacular.infrastructure.local;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LlamadorDatosLocales;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.PosiblesUnidadesRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.TipoUnidadesAlCobrarRoomDto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import infrastructure.local.fixtures.IngredienteDetalladoFixture;

@RunWith(MockitoJUnitRunner.class)
public class LlamadorDatosLocalesTest extends IngredienteDetalladoFixture {

    private LlamadorDatosLocales llamadorDatosLocales;

    @Mock
    private LocalDatabase database;
    @Mock
    private IngredientesDao dao;

    @Before
    public void setUp() {
        Mockito.when(database.ingredientesDao()).thenReturn(dao);
        llamadorDatosLocales = new LlamadorDatosLocales(database);
    }

    @Test
    public void obtenerIng_llamaDaosCorrespondientes() throws Exception {
        Mockito.when(dao.getIngrediente(id)).thenReturn(new IngredienteDetalladoRoomDto());
        llamadorDatosLocales.obtenerInformacionIngrediente(id, 20.0, "hola");
        Mockito.verify(dao).getIngrediente(id);
        Mockito.verify(dao).getCategorias(id);
        Mockito.verify(dao).getPosiblesUnidades(id);
        Mockito.verify(dao).getUnidadesCobrar(id);


    }

    @Test
    public void obtenerIng_noExiste_noDevuleveNada() throws Exception {
        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, null);
        Assert.assertNull(ing);
    }

    @Test
    public void obtenerIng_existe_devuelveIngrediente() throws Exception {
        Mockito.when(dao.getIngrediente(id)).thenReturn(getIngredienteDetalladoDao());
        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, "hola");
        Assert.assertNotNull(ing);
    }

    @Test
    public void obtenerIng_existeTodo_devuelveCompleto() throws Exception {

        Mockito.when(dao.getIngrediente(id)).thenReturn(getIngredienteDetalladoDao());
        Mockito.when(dao.getCategorias(id)).thenReturn(
                Arrays.asList(new CaminoCategoriasRoomDto(id, "fruta"),
                        new CaminoCategoriasRoomDto(id, "verdura")
                ));
        Mockito.when(dao.getPosiblesUnidades(id)).thenReturn(
                Arrays.asList(new PosiblesUnidadesRoomDto(id, "cm"),
                        new PosiblesUnidadesRoomDto(id, "km")
                ));

        Mockito.when(dao.getUnidadesCobrar(id)).thenReturn(
                Arrays.asList(new TipoUnidadesAlCobrarRoomDto(id, "€"),
                        new TipoUnidadesAlCobrarRoomDto(id, "$")
                ));

        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, "hola");
        Assert.assertNotNull(ing);
        Assert.assertEquals(Arrays.asList("fruta", "verdura"), ing.getCaminoDeCategorias());
        Assert.assertEquals(Arrays.asList("cm", "km"), ing.getPosiblesUnidades());
        Assert.assertEquals(Arrays.asList("€", "$"), ing.getTiposDeUnidadesAlCobrar());

    }
}
