package com.cavitedet.proyectodam_spoonacular.infrastructure.local.roomModels;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.ingredientes.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.cavitedet.proyectodam_spoonacular.infrastructure.local.RoomConstantes;

@Entity(tableName = RoomConstantes.INGREDIENTES_NOMBRE_TABLA)
public class IngredienteRoomDto implements IADominio<Ingrediente> {

    @PrimaryKey
    private Integer id;

    private String nombre;

    private String imagen;


    public IngredienteRoomDto() {
    }

    public IngredienteRoomDto(Ingrediente dominio) {
        this.id = dominio.getId();
        this.nombre = dominio.getNombre();
        this.imagen = dominio.getImagen();
    }

    @Override
    public Ingrediente aDominio() {
        return new Ingrediente(id, nombre, imagen);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + nombre + '\'' +
                ", image='" + imagen + '\'' +
                '}';
    }


}
