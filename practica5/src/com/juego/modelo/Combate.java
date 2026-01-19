package com.juego.modelo;

import java.sql.SQLOutput;

public class Combate {
    Personaje p1;
    Personaje p2;


    public Combate(Personaje p1, Personaje p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String iniciar(Personaje p1, Personaje p2){
        int contador=1;
        while(this.p1.getEstadisticas().getVida()>0&&this.p2.getEstadisticas().getVida()>0){
            System.out.println("Turno " +contador);
            System.out.println();
        }
    }
}
