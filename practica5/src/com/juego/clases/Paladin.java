package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Paladin implements Clase {
    private String nombre;
    private Estadisticas estadisticas;

    public Paladin(String nombre, Estadisticas estadisticas){
        this.nombre=nombre;
        this.estadisticas=estadisticas;
    }
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
        estadisticas.setVidaMaxima(115);
    }
}
