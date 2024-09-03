package com.unilabs.agenda.Modal;

import java.util.Objects;

public class Contacto {

    private String nombre;
    private String telefono;
    private String alias;
    private String direccion;
    private String email;

    public Contacto (){}

    public Contacto(String nombre, String telefono, String alias, String direccion, String email){
        this.alias = alias;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    /** estos son los setters y getters, junto a el toString*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "contacto{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", alias='" + alias + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public String CrearContacto(String nombre, String telefono, String alias, String direccion, String email){
        Contacto contacto1 = new Contacto(nombre, telefono, alias, direccion, email);
        if (Objects.equals(this.telefono, telefono)){
            String mensaje = "el contacto ya existe";
            return mensaje;

        }
        return contacto1.toString();
    }

    public String eliminarContacto(Contacto contacto){
        if (this == contacto){
            contacto = null;
            String mensaje = "Contacto borrado";
            return mensaje;
        }


        return "No existe el contacto";
    }
    public String actualizarContacto(Contacto contacto, String nuevoNombre, String nuevoTelefono, String nuevoAlias, String nuevaDireccion, String nuevoEmail){
        if(this == contacto){
            this.nombre = nuevoNombre;
            this.telefono = nuevoTelefono;
            this.alias = nuevoAlias;
            this.direccion = nuevaDireccion;
            this.email = nuevoEmail;

            return "Contacto actualizado";
        }
        return "No existe el contacto";


    }
}