package com.juego.habilidades;

public class CuracionMayor implements Habilidades {
    private String nombre;
    private int danio;
    private int usos;

    //constructor
    public CuracionMayor() {
        this.nombre = "Poción de curación mayor";
        this.danio = 70;
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
        return "CuracionMayor{" +
                "nombre='" + nombre + '\'' +
                ", cura=" + danio +
                ", usos=" + usos +
                '}';
    }
}
