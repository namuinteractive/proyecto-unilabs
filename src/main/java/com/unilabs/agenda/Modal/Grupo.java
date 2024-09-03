package com.unilabs.agenda.Modal;

import java.util.ArrayList;

public class Grupo {

    private String nombre;
    private ArrayList<Contacto> integrantes;
    private String categoria;

    public Grupo(String nombre, ArrayList<Contacto> integrantes, String categoria){

        this.nombre = nombre;
        this.integrantes = integrantes;
        this.categoria = categoria;

    }
    /** estos son los settes y getters, junto con el toString*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Contacto> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Contacto> integrantes) {
        this.integrantes = integrantes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "grupo{" +
                "nombre='" + nombre + '\'' +
                ", integrantes=" + integrantes +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public String agregarContacto(Contacto contacto){
        if(integrantes.size() < 5){
            integrantes.add(contacto);
            return "Contacto agregado al grupo";
        }else{
            return "El grupo ya tiene 5 contactos";
        }
    }

    public String eliminarContacto(Contacto contacto){
        if(integrantes.contains(contacto)){
            integrantes.remove(contacto);
            return "Contacto eliminado del grupo";
        }else{
            return "El contacto no pertenece al grupo";
        }
    }
}