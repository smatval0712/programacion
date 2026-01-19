package com.juego.habilidades;

public class Puñalada implements Habilidades{
    private String nombre;
    private int usos;
    private int daño;

    //constructor
    public Puñalada() {
        this.nombre = "Puñalada";
        this.usos = 5;
        this.daño = 37;
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
        return "Puñalada{" +
                "nombre='" + nombre + '\'' +
                ", usos=" + usos +
                ", danio=" + daño +
                '}';
    }
}
