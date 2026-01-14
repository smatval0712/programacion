package com.juego.clases;
import com.juego.modelo.Estadisticas;

public class Sacerdote implements Clase {
    private String nombre;
    private Estadisticas estadisticas;

    public Sacerdote(String nombre, Estadisticas estadisticas){
        this.nombre=nombre;
        this.estadisticas=estadisticas;
    }
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
        estadisticas.setVida(estadisticas.getVida()+95);
    }
}