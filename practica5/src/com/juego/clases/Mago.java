package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Mago implements Clase {

    public Mago(){
    }
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setInteligencia(estadisticas.getInteligencia()+3);
        estadisticas.setVida(estadisticas.getVida()+90);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Bastonazo());
        listaHabilidades.add(new ProyectilMagico());
        listaHabilidades.add(new CuracionMenor());
    }
}