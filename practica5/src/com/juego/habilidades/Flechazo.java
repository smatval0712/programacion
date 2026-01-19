package com.juego.habilidades;

public class Flechazo implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    //constructor
    public Flechazo() {
        this.nombre = "Flechazo";
        this.daño = 100;
        this.usos = 1;
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
        return "Flechazo{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + daño +
                ", usos=" + usos +
                '}';
    }
}
