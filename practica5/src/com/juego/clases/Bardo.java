package com.juego.clases;
import com.juego.habilidades.ChillidoEstrondoso;
import com.juego.habilidades.CuracionMayor;
import com.juego.habilidades.GolpeArmonico;
import com.juego.habilidades.Habilidades;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Bardo implements Clase {
    private String nombre;
    private Estadisticas estadisticas;

    public Bardo(String nombre, Estadisticas estadisticas){
        this.nombre=nombre;
        this.estadisticas=estadisticas;
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
        listaHabilidades.add(new CuracionMayor());
    }
}