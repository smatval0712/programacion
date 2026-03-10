package com.rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private String nombre;
    private String raza;
    private Integer nivel;
    private List<String> equipo;
    public Personaje(String nombre, String raza,Integer nivel, List<String> equipo){
        this.nombre=nombre;
        this.raza=raza;
        this.nivel=nivel;
        this.equipo=equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public List<String> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<String> equipo) {
        this.equipo = equipo;
    }
}
