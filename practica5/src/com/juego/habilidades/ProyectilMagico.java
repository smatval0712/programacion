package com.juego.habilidades;

public class ProyectilMagico implements Habilidades {
    private String nombre;
    private int danio;
    private int usos;

    //constructor
    public ProyectilMagico() {
        this.nombre = "ProyectilMagico";
        this.danio = 120;
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
        return "ProyectilMagico{" +
                "nombre='" + nombre + '\'' +
                ", daño=" + danio +
                ", usos=" + usos +
                '}';
    }
}
