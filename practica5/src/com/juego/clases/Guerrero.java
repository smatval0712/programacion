package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Guerrero implements Clase{

    public Guerrero(){
    }
    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas) {
        estadisticas.setFuerza(estadisticas.getFuerza()+3);
        estadisticas.setVida(estadisticas.getVida()+120);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Espadazo());
        listaHabilidades.add(new Flechazo());
        listaHabilidades.add(new CuracionMayor());
    }
}
