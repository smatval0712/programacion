package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Guerrero implements Clase{
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas) {
        estadisticas.setFuerza(estadisticas.getFuerza()+3);
        estadisticas.setVidaMaxima(120);
    }
}
