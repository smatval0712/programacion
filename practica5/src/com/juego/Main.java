package com.juego;

import com.juego.modelo.Estadisticas;
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

public class Main {

    public static void main(String[] args) {

        //codigo para probar si funcionan las diferentes razas
        Estadisticas e = new Estadisticas();
        Raza h = new Humano();

        h.rellenarEstadisticas(e);

        System.out.println("Fuerza: " + e.getFuerza());
        System.out.println("Inteligencia: " + e.getInteligencia());
        System.out.println("Destreza: " + e.getDestreza());
        System.out.println("Vida: " + e.getVida());
    }
}
