package com.juego.clases;
import com.juego.habilidades.Bastonazo;
import com.juego.habilidades.CuracionMayor;
import com.juego.habilidades.Habilidades;
import com.juego.habilidades.Veneno;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Druida implements Clase {

    public Druida(){
    }

    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
        estadisticas.setVida(estadisticas.getVida()+100);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades= personaje.getListaHabilidades();
        listaHabilidades.add(new Bastonazo());
        listaHabilidades.add(new Veneno());
        listaHabilidades.add(new CuracionMayor());
    }
}
