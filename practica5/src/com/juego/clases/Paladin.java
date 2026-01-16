package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Paladin implements Clase {

    public Paladin(){
    }
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(estadisticas.getFuerza()+2);
        estadisticas.setInteligencia(estadisticas.getInteligencia()+1);
        estadisticas.setVida(estadisticas.getVida()+115);
    }
    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new GolpeContundente());
        listaHabilidades.add(new Flechazo());
        listaHabilidades.add(new CuracionMedia());
    }
}
