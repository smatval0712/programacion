package com.juego.razas;
import com.juego.modelo.Estadisticas;

//implementamos la clase raza en cada raza que creamos para que siga
public class Humano implements Raza{
private String nombre;
    public Humano(){
        this.nombre="Humano";
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    //ponemos el override para indicar que vamos a poner el contenido real de la plantilla que teniamos en la interfaz raza
    @Override
    //rellenamos la funcion con los valores de las estadisticas de humano
    public void rellenarEstadisticas(Estadisticas estadisticas){
        estadisticas.setFuerza(5);
        estadisticas.setInteligencia(5);
        estadisticas.setDestreza(5);
        estadisticas.setVida(100);
    }
}
