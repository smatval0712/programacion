package com.juego.clases;
import com.juego.habilidades.*;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;

import java.util.ArrayList;

public class Picaro implements Clase {
    private String nombre;
    public Picaro(){
        this.nombre="Picaro";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //añadimos el override para sobreescribir sobre la interfaz
    @Override
    //funcion añadiendo bonificaciones
    public void bonificadorEstadisticas(Estadisticas estadisticas){
        estadisticas.setDestreza(estadisticas.getDestreza()+3);
        estadisticas.setVida(estadisticas.getVida()+105);
    }
    @Override
    public void agregarHabilidad(Personaje personaje) {
        ArrayList<Habilidades> listaHabilidades = personaje.getListaHabilidades();
        listaHabilidades.add(new Puñalada());
        listaHabilidades.add(new Flechazo());
        listaHabilidades.add(new CuracionMenor());
    }
}