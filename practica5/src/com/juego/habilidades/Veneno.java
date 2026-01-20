package com.juego.habilidades;

public class Veneno implements Habilidades {
    private String nombre;
    private int danio;
    private int usos;

    //constructor
    public Veneno() {
        this.nombre = "Veneno";
        this.danio = 110;
        this.usos = 1;
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
        return "Veneno{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + danio +
                ", usos=" + usos +
                '}';
    }
}
