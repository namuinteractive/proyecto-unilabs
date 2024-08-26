package com.unilabs.agenda;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> listaContactos;
    private ArrayList<Grupo> listaGrupos;
    private ArrayList<Reunion> listaReuniones;

    public Agenda(ArrayList<Contacto> listaContactos, ArrayList<Grupo> listaGrupos, ArrayList<Reunion> listaReuniones){
        this.listaContactos = listaContactos;
        this.listaGrupos = listaGrupos;
        this.listaReuniones = listaReuniones;
    }
    /** Estos son los setters and getters, junto al toString*/

    public ArrayList<Contacto> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(ArrayList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    public ArrayList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(ArrayList<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public ArrayList<Reunion> getListaReuniones() {
        return listaReuniones;
    }

    public void setListaReuniones(ArrayList<Reunion> listaReuniones) {
        this.listaReuniones = listaReuniones;
    }




    @Override
    public String toString() {
        return "Agenda{" +
                "listaContactos=" + listaContactos +
                ", listaGrupos=" + listaGrupos +
                ", listaReuniones=" + listaReuniones +
                '}';
    }

    public String agregarContacto(Contacto contacto){
        for(Contacto c : listaContactos){
            if(c.getNombre().equals(contacto.getNombre()) && c.getTelefono().equals(contacto.getTelefono())){
                return "El contacto ya existe";
            }
        }
        listaContactos.add(contacto);
        return "Contacto agregado";
    }

    public String eliminarContacto(Contacto contacto){
        for(Contacto c : listaContactos){
            if(c.getNombre().equals(contacto.getNombre()) && c.getTelefono().equals(contacto.getTelefono())){
                listaContactos.remove(contacto);
                return "Contacto eliminado";
            }
        }
        return "El contacto no existe";
    }

    public String agregarGrupo(Grupo grupo){
        listaGrupos.add(grupo);
        return "Grupo agregado";
    }

    public String eliminarGrupo(Grupo grupo){
        listaGrupos.remove(grupo);
        return "Grupo eliminado";
    }

    public String agregarReunion(Reunion reunion){
        listaReuniones.add(reunion);
        return "Reunion agregada";
    }

    public String eliminarReunion(Reunion reunion){
        listaReuniones.remove(reunion);
        return "Reunion eliminada";
    }
}