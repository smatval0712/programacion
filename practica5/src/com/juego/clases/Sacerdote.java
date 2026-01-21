package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Sacerdote implements Clase {
    private String nombre;
    public Sacerdote(){
        this.nombre="Sacerdote";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
        estadisticas.setVida(estadisticas.getVida()+95);
    }
    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Rezo());
        listaHabilidades.add(new RayoDivino());
        listaHabilidades.add(new CuracionMedia());
    }
}