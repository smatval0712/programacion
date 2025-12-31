package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Monje implements Clase {
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setDestreza(estadisticas.getDestreza()+1);
        estadisticas.setVidaMaxima(110);
    }
}