package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Monje implements Clase {
    private String nombre;
    public Monje(){
        this.nombre="Monje";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setDestreza(estadisticas.getDestreza()+1);
        estadisticas.setVida(estadisticas.getVida()+110);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Rezo());
        listaHabilidades.add(new RayoDivino());
        listaHabilidades.add(new CuracionMayor());
    }
}