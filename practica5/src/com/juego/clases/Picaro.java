package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Picaro implements Clase {
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setDestreza(estadisticas.getDestreza()+3);
        estadisticas.setVidaMaxima(105);
    }
}