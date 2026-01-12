package com.juego;

import com.juego.clases.Bardo;
import com.juego.clases.Clase;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

public class Main {

    public static void main(String[] args) {

        //codigo para probar si funcionan las diferentes razas
        Estadisticas e1 = new Estadisticas();
        Clase Bardo= new Bardo("Bardo",e1);

        Raza h = new Humano("Humano",e1);


        Personaje p1=new Personaje("Personaje 1",h,Bardo,e1);
        System.out.println("Fuerza "+p1.getEstadisticas().getFuerza());
        System.out.println("Inteligencia "+p1.getEstadisticas().getInteligencia());
        System.out.println("Destreza "+p1.getEstadisticas().getDestreza());
        System.out.println("Vida "+p1.getEstadisticas().getVida());
    }

}
