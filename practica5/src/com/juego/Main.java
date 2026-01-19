package com.juego;

import com.juego.clases.Bardo;
import com.juego.clases.Clase;
import com.juego.clases.Guerrero;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

public class Main {

    public static void main(String[] args) {

       Personaje Personaje1 =new Personaje("Alvarito",new Humano(),new Guerrero(),new Estadisticas());
       for(Habilidades habilidades:Personaje1.getListaHabilidades()){
           System.out.println("Habilidad : " +habilidades.getNombre());
       }

    }

}
