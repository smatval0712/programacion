package com.juego.habilidades;

public class Puñalada implements Habilidades{
    private String nombre;
    private int usos;
    private int danio;

    //constructor
    public Puñalada() {
        this.nombre = "Espadazo";
        this.usos = 5;
        this.danio = 37;
    }
    //get

    public String getNombre() {
        return nombre;
    }

    public int getUsos() {
        return usos;
    }

    public int getDanio() {
        return danio;
    }

    //set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    @Override
    public void usarHabilidad() {
        this.usos--;
    }
}
