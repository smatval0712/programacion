package com.juego.razas;
import com.juego.modelo.Estadisticas;

//implementamos la clase raza en cada raza que creamos para que siga
public class Enano implements Raza{
    private String nombre;
    public Enano (){
        this.nombre="Enano";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //ponemos el override para indicar que vamos a poner el contenido real de la plantilla que teniamos en la interfaz raza
    @Override
    //rellenamos la funcion con los valores de las estadisticas de enano
    public void rellenarEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(7);
        estadisticas.setInteligencia(4);
        estadisticas.setDestreza(4);
        estadisticas.setVida(110);
    }

}
