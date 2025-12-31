package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Bardo implements Clase {
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
        estadisticas.setVidaMaxima(90);
    }
}