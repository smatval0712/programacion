package com.juego.razas;
import com.juego.modelo.Estadisticas;

import java.util.ArrayList;

//implementamos la clase raza en cada raza que creamos para que siga
public class Elfo implements Raza{
    private String nombre;
    public Elfo(){
        this.nombre="Elfo";
    }

    public String getNombre() {
        return nombre;
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
