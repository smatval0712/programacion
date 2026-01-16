package com.juego.habilidades;

public class GolpeContundente implements Habilidades {
    private String nombre;
    private int daño;
    private int usos;

    //constructor
    public GolpeContundente() {
        this.nombre = "Golpe Contundente";
        this.daño = 50;
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
}
