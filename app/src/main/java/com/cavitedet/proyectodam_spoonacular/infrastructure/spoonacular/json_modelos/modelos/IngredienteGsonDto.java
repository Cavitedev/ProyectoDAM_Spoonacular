package com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.json_modelos.modelos;

import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.Ingrediente;
import com.cavitedet.proyectodam_spoonacular.domain.spoonacular.modelos.reglas.IADominio;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import static com.cavitedet.proyectodam_spoonacular.infrastructure.spoonacular.JsonUtil.getGson;


public class IngredienteGsonDto implements IADominio<Ingrediente> {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String nombre;

    @SerializedName("image")
    private String imagen;

    public static IngredienteGsonDto desdeJson(String json) {
        return getGson().fromJson(json, new TypeToken<IngredienteGsonDto>() {
        }.getType());
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
