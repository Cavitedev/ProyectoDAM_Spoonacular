package com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador;

import android.content.Context;

import androidx.room.Room;

import com.cavitedet.proyectodam_spoonacular.domain.modelos.ingrediente_detallado.IngredienteDetallado;
import com.cavitedet.proyectodam_spoonacular.domain.repositorio.IFuenteDeDatos;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.llamadas.InsertarIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.llamador.llamadas.LeerDetallesIngredientes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.IngredientesDao;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.LocalDatabase;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room.RoomConstantes;
import com.cavitedet.proyectodam_spoonacular.infrastructure.repositorio.local.room_models.ingredienteDetallado.IngredienteDetalladoRoomDto;

public class LlamadorDatosLocales implements IFuenteDeDatos {

    private static LlamadorDatosLocales instance;
    private LocalDatabase database;


    public LlamadorDatosLocales(LocalDatabase database) {
        this.database = database;
    }

    public static LlamadorDatosLocales getInstance(Context context) {
        if (instance == null) {
            instance = new LlamadorDatosLocales(
                    Room.databaseBuilder(context,
                            LocalDatabase.class, RoomConstantes.BASEDEDATOS_NOMBRE)
                            .allowMainThreadQueries().build()
            );
        }
        return instance;
    }

    public void limpiar() {
        if (instance != null)
            instance.database.close();
        instance = null;
    }

    public void insertarIngrediente(IngredienteDetallado ingredienteDetalladoDominio) {

        if (ingredienteDetalladoDominio == null)
            return;
        getIngredientesDao().insertarIngrediente(new IngredienteDetalladoRoomDto(ingredienteDetalladoDominio));
        int ingId = ingredienteDetalladoDominio.getId();

        InsertarIngredientes.insertarListas(ingredienteDetalladoDominio, ingId, getIngredientesDao());
    }




    @Override
    public IngredienteDetallado obtenerInformacionIngrediente(Integer id, Double amount, String unit) throws LocalSourceException {
        //Amount y Unit no funcionan porque no necesitó esos datos en la app por ahora
        IngredienteDetalladoRoomDto ingDetalladoDto = getIngredientesDao().getIngrediente(id);
        if (ingDetalladoDto == null)
            throw new LocalSourceException(400, "No se ha encontrado ingDetalladoDto");

        LeerDetallesIngredientes.leerListas(id, ingDetalladoDto, getIngredientesDao());

        return ingDetalladoDto.aDominio();
    }


    private IngredientesDao getIngredientesDao() {
        return database.ingredientesDao();
    }


}
