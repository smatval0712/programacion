package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Bardo implements Clase {
    private String nombre;
    //constructor
    public Bardo(){
        this.nombre="Bardo";
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
        estadisticas.setVida(estadisticas.getVida()+90);
    }

    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new GolpeArmonico());
        listaHabilidades.add(new ChillidoEstrondoso());
        listaHabilidades.add(new CuracionMedia());
    }
}