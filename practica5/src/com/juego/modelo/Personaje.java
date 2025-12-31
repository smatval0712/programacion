package com.juego.modelo;
import com.juego.clases.Clase;
import com.juego.razas.Raza;

//creamos la clase personaje igualmente que habilidades antes para saber con qué personajes estamos jugando la partida
public class Personaje {
    //atributos
    private String nombre;
    private Estadisticas estadisticas;
    private Raza raza;
    private Clase clase;

    //constructor
    public Personaje(String nombre, Raza raza, Clase clase){
        this.nombre=nombre;
        //Esta linea crea un nuevo objeto de la clase Estadisticas y lo guarda en Personaje, es como cuando hacemos en el main Estadisticas e = new Estadisticas();
        this.estadisticas = new Estadisticas();
        //Añadimos el tipo de raza al personaje
        this.raza= raza;
        //llamamos a la funcion de la raza de rellenar estadisticas
        raza.rellenarEstadisticas(this.estadisticas);
        //Añadimos la clase
        this.clase=clase;
        //llamamos a la funcion de bonificadorEstadisticas de la clase para que se apliquen las bonificaciones
        clase.bonificadorEstadisticas(this.estadisticas);
    }
}
