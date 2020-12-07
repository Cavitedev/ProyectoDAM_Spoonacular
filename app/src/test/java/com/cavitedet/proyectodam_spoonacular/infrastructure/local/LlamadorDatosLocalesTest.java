package com.cavitedet.proyectodam_spoonacular.infrastructure.local;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LlamadorDatosLocales;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.IngredienteDetalladoRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.NutrienteRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.PropiedadRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.CaminoCategoriasRoomDto;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.roomModels.ingredienteDetallado.listas.MetaInfoRoomDto;
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
import java.util.Collections;

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
    public void insertaNulo_noInsertaNada() {
        llamadorDatosLocales.insertarIngrediente(null);
        Mockito.verifyNoInteractions(dao);
    }

    @Test
    public void insertaIng_llamaDaosCorrespondientes() {
        IngredienteDetallado domain = getIngredienteDetalladoDominio();
        llamadorDatosLocales.insertarIngrediente(domain);
        PropiedadRoomDto prop = new PropiedadRoomDto(domain.getNutricion().getPropiedades().get(0));
        prop.setIdDetalles(domain.getId());
        NutrienteRoomDto nut = new NutrienteRoomDto(domain.getNutricion().getNutrientes().get(0));
        nut.setIdDetalles(domain.getId());

        Mockito.verify(dao).insertarCaminoCategoria(
                new CaminoCategoriasRoomDto(domain.getId(), domain.getCaminoDeCategorias().get(0)));

        Mockito.verify(dao).insertarPosibleUnidad(
                new PosiblesUnidadesRoomDto(domain.getId(), domain.getPosiblesUnidades().get(0))
        );
        Mockito.verify(dao).insertarUnidadCobrar(
                new TipoUnidadesAlCobrarRoomDto(domain.getId(), domain.getTiposDeUnidadesAlCobrar().get(0))
        );
        Mockito.verify(dao).insertarNutriente(nut);
        Mockito.verify(dao).insertarPropiedad(prop);
        Mockito.verify(dao).insertarMetainfo(
                new MetaInfoRoomDto(domain.getId(), domain.getMetaInformacion().get(0))
        );
    }


    @Test
    public void obtenerIng_llamaDaosCorrespondientes() throws Exception {
        Mockito.when(dao.getIngrediente(id)).thenReturn(getIngredienteDetalladoDao());
        llamadorDatosLocales.obtenerInformacionIngrediente(id, 20.0, "hola");
        Mockito.verify(dao).getIngrediente(id);
        Mockito.verify(dao).getCategorias(id);
        Mockito.verify(dao).getPosiblesUnidades(id);
        Mockito.verify(dao).getUnidadesCobrar(id);
        Mockito.verify(dao).getNutrientes(id);
        Mockito.verify(dao).getPropiedades(id);
        Mockito.verify(dao).getMetaInfo(id);
    }

    @Test
    public void obtenerIng_noExiste_noDevuleveNada() throws Exception {
        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, null);
        Assert.assertNull(ing);
    }

    @Test
    public void obtenerIng_noExisteNutricion_noLlamaSusDtos() throws Exception {
        IngredienteDetalladoRoomDto dto = getIngredienteDetalladoDao();
        dto.setNutricion(null);
        Mockito.when(dao.getIngrediente(id)).thenReturn(dto);
        llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, null);
        Mockito.verify(dao, Mockito.never()).getNutrientes(id);
        Mockito.verify(dao, Mockito.never()).getPropiedades(id);
    }

    @Test
    public void obtenerIng_existe_devuelveIngrediente() throws Exception {
        Mockito.when(dao.getIngrediente(id)).thenReturn(getIngredienteDetalladoDao());
        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, "hola");
        Assert.assertNotNull(ing);
    }

    @Test
    public void obtenerIng_existeTodo_devuelveCompleto() throws Exception {

        simularDevolverMockitoTodosLosDatos();

        IngredienteDetallado ing = llamadorDatosLocales.obtenerInformacionIngrediente(id, 1.00, "hola");
        Assert.assertNotNull(ing);
        Assert.assertEquals(Arrays.asList("fruta", "verdura"), ing.getCaminoDeCategorias());
        Assert.assertEquals(Arrays.asList("cm", "km"), ing.getPosiblesUnidades());
        Assert.assertEquals(Arrays.asList("€", "$"), ing.getTiposDeUnidadesAlCobrar());
        Assert.assertEquals(Arrays.asList("info1", "info2"), ing.getMetaInformacion());

        Assert.assertEquals(getIngredienteDetalladoDominio().getValorEstimado(), ing.getValorEstimado());
        Assert.assertEquals(getIngredienteDetalladoDominio().getNutricion().getNutrientes().get(0),
                ing.getNutricion().getNutrientes().get(0));
        Assert.assertEquals(getIngredienteDetalladoDominio().getNutricion().getPropiedades().get(0),
                ing.getNutricion().getPropiedades().get(0));
    }

    private void simularDevolverMockitoTodosLosDatos() {
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

        Mockito.when(dao.getMetaInfo(id)).thenReturn(
                Arrays.asList(new MetaInfoRoomDto(id, "info1"),
                        new MetaInfoRoomDto(id, "info2")
                ));

        Mockito.when(dao.getNutrientes(id)).thenReturn(
                Collections.singletonList(getNutrienteRoomDto())
        );
        Mockito.when(dao.getPropiedades(id)).thenReturn(
                Collections.singletonList(getPropiedadRoomDto())
        );
    }
}
