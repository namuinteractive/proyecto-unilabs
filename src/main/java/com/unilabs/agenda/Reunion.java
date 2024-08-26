package com.unilabs.agenda;

import java.util.ArrayList;

public class Reunion {

    private String descripcion;
    private String fechaReunion;
    private ArrayList<Contacto> integrantesReunion;
    private String tiempoReunion;

    public Reunion(String descripcion, String fechaReunion, ArrayList<Contacto> integrantesReunion, String tiempoReunion) {
        this.descripcion = descripcion;
        this.fechaReunion = fechaReunion;
        this.integrantesReunion = integrantesReunion;
        this.tiempoReunion = tiempoReunion;
    }
    /** Estos son los setters and getters, junto al toString*/

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(String fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public ArrayList<Contacto> getIntegrantesReunion() {
        return integrantesReunion;
    }

    public void setIntegrantesReunion(ArrayList<Contacto> integrantesReunion) {
        this.integrantesReunion = integrantesReunion;
    }

    public String getTiempoReunion() {
        return tiempoReunion;
    }

    public void setTiempoReunion(String tiempoReunion) {
        this.tiempoReunion = tiempoReunion;
    }

    @Override
    public String toString() {
        return "reunion{" +
                "descripcion='" + descripcion + '\'' +
                ", fechaReunion='" + fechaReunion + '\'' +
                ", integrantesReunion=" + integrantesReunion +
                ", tiempoReunion='" + tiempoReunion + '\'' +
                '}';
    }

    public String agregarContacto(Contacto contacto){
        integrantesReunion.add(contacto);
        return "Contacto agregado a la reunion";

    }

    public String eliminarContacto(Contacto contacto){
        if(integrantesReunion.contains(contacto)){
            integrantesReunion.remove(contacto);
            return "Contacto eliminado de la reunion";
        }else{
            return "El contacto no pertenece a la reunion";
        }
    }
}