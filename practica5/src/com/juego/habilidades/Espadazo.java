package com.juego.habilidades;

public class Espadazo implements Habilidades{
    private String nombre;
    private int usos;
    private int daño;

    //constructor
    public Espadazo() {
        this.nombre = "Espadazo";
        this.usos = 5;
        this.daño = 40;
    }
    //get

    public String getNombre() {
        return nombre;
    }

    public int getUsos() {
        return usos;
    }

    public int getDaño() {
        return daño;
    }

    //set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    @Override
    public void usarHabilidad() {
        this.usos--;
    }

    @Override
    public String toString() {
        return "Espadazo{" +
                "nombre='" + nombre + '\'' +
                ", usos=" + usos +
                ", daño=" + daño +
                '}';
    }
}
