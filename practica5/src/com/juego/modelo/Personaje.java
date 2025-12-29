package com.juego.modelo;
//creamos la clase personaje igualmente que habilidades antes para saber con qué personajes estamos jugando la partida
public class Personaje {
    //atributos
    private String nombre;
    private Estadisticas estadisticas;

    //constructor
    public Personaje(String nombre, Estadisticas estadisticas){
        this.nombre=nombre;
        //Esta linea crea un nuevo objeto de la clase Estadisticas y lo guarda en Personaje, es como cuando hacemos en el main Estadisticas e = new Estadisticas();
        this.estadisticas = new Estadisticas();
    }
}
