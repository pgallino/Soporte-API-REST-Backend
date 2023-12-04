package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Recurso {
    @Id
    private long legajo;
    private String Nombre;
    private String Apellido;

    // Getters y setters
    public Recurso(){}

    public void setNombre(String name){
        Nombre = name;
    }
    public void setApellido(String name){
        Apellido = name;
    }
    public void setLegajo(Long legajo){
        legajo = legajo;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public Long getLegajo() {
        return legajo;
    }
}