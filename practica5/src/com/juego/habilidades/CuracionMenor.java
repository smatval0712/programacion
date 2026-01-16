package com.juego.habilidades;

public class CuracionMenor implements Habilidades {
    private String nombre;
    private int cura;
    private int usos;

    //constructor
    public CuracionMenor() {
        this.nombre = "Poción de curación menor";
        this.cura = 40;
        this.usos = 3;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDaño() {
        return cura;
    }

    public void setDaño(int daño) {
        this.cura = daño;
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
