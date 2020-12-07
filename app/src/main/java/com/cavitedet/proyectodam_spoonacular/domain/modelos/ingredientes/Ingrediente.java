package com.cavitedet.proyectodam_spoonacular.domain.modelos.ingredientes;



public class Ingrediente {

    private Integer id;

    private String nombre;

    private String imagen;

    public Ingrediente() {
    }

    public Ingrediente(Integer id, String nombre, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingrediente)) return false;

        Ingrediente that = (Ingrediente) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getNombre() != null ? !getNombre().equals(that.getNombre()) : that.getNombre() != null)
            return false;
        return getImagen() != null ? getImagen().equals(that.getImagen()) : that.getImagen() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getImagen() != null ? getImagen().hashCode() : 0);
        return result;
    }
}
