package com.juego.razas;
import com.juego.modelo.Estadisticas;

//implementamos la clase raza en cada raza que creamos para que siga
public class Elfo implements Raza{

    public Elfo(){

    }

    //ponemos el override para indicar que vamos a poner el contenido real de la plantilla que teniamos en la interfaz raza
    @Override
    //rellenamos la funcion con los valores de las estadisticas de Elfo
    public void rellenarEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(4);
        estadisticas.setInteligencia(6);
        estadisticas.setDestreza(7);
        estadisticas.setVida(90);
    }
}
