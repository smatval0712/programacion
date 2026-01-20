package com.juego;

import com.juego.clases.Bardo;
import com.juego.clases.Clase;
import com.juego.clases.Guerrero;
import com.juego.clases.Mago;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Combate;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

public class Main {

    public static void main(String[] args) {

       Personaje Personaje1 =new Personaje("Checo",new Humano(),new Guerrero(),new Estadisticas());
       Personaje Personaje2 =new Personaje("Maria",new Elfo(),new Mago(),new Estadisticas());
       Combate combate =new Combate();
       System.out.println("Vida p1: " +Personaje1.getEstadisticas().getVida());
       System.out.println("Vida p2: " +Personaje2.getEstadisticas().getVida());

       combate.iniciar(Personaje1,Personaje2);
    }

}
