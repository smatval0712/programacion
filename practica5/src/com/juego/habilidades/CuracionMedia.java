package com.juego.habilidades;

public class CuracionMedia implements Habilidades {
    private String nombre;
    private int danio;
    private int usos;

    //constructor
    public CuracionMedia() {
        this.nombre = "Poción de curación media";
        this.danio = 55;
        this.usos = 3;
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
        return "CuracionMedia{" +
                "nombre='" + nombre + '\'' +
                ", cura=" + danio +
                ", usos=" + usos +
                '}';
    }
}
