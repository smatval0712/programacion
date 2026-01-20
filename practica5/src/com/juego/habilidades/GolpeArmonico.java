package com.juego.habilidades;

public class GolpeArmonico implements Habilidades{
    private String nombre;
    private int danio;
    private int usos;

    //constructor
    public GolpeArmonico() {
        this.nombre = "Golpe Armónico";
        this.danio = 35;
        this.usos = 5;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getdanio() {
        return danio;
    }

    public void setdanio(int danio) {
        this.danio = danio;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    @Override
    public void usarHabilidad() {
        this.usos--;
    }

    @Override
    public String toString() {
        return "GolpeArmonico{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + danio +
                ", usos=" + usos +
                '}';
    }
}

