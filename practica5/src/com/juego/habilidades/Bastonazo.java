package com.juego.habilidades;

public class Bastonazo implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    //constructor
    public Bastonazo() {
        this.nombre = "Bastonazo";
        this.daño = 38;
        this.usos = 5;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
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
        return "Bastonazo{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + daño +
                ", usos=" + usos +
                '}';
    }
}
