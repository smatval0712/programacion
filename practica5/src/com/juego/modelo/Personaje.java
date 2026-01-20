package com.juego.modelo;
import com.juego.clases.Clase;
import com.juego.habilidades.Habilidades;
import com.juego.razas.Raza;

import java.util.ArrayList;

//creamos la clase personaje igualmente que habilidades antes para saber con qué personajes estamos jugando la partida
public class Personaje {
    //atributos
    private String nombre;
    private Estadisticas estadisticas;
    private Raza raza;
    private Clase clase;
    private ArrayList <Habilidades> listaHabilidades;

    //constructor
    public Personaje(String nombre, Raza raza, Clase clase, Estadisticas estadisticas){
        this.nombre=nombre;
        //Esta linea crea un nuevo objeto de la clase Estadisticas y lo guarda en Personaje, es como cuando hacemos en el main Estadisticas e = new Estadisticas();
        this.estadisticas = new Estadisticas();
        //Añadimos el tipo de raza al personaje
        this.raza= raza;
        //Añadimos la clase
        this.clase=clase;
        this.listaHabilidades= new ArrayList<>();
        //llamamos a la funcion de la raza de rellenar estadisticas
        raza.rellenarEstadisticas(this.estadisticas);
        //llamamos a la funcion de bonificadorEstadisticas de la clase para que se apliquen las bonificaciones
        clase.bonificadorEstadisticas(this.estadisticas);
        clase.agregarHabilidad(this);
    }

    //get
    public String getNombre() {
        return nombre;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public Raza getRaza() {
        return raza;
    }

    public Clase getClase() {
        return clase;
    }

    public ArrayList<Habilidades> getListaHabilidades() {
        return listaHabilidades;
    }

    //set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setListaHabilidades(ArrayList<Habilidades> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }



    //Funcion mostrar datos del personaje para ver como van los personajes en el combate
    public void mostrarDatos(){
        System.out.println(getNombre());
        System.out.println("Vida restante " +getEstadisticas().getVida());
        int contador=1;
        for (Habilidades habilidades:getListaHabilidades()){
            System.out.print(contador +".- " +habilidades.getNombre()+" --> ");
            if (habilidades.getNombre().contains("Poción")){
                System.out.print("cura: " +habilidades.getdanio()+", ");
            }
            else{
                System.out.print("daño: " +habilidades.getdanio()+", ");
            }
            System.out.print("Usos restantes: " +habilidades.getUsos());
            System.out.println();
            contador++;
        }
    }

    //funcion para comprobar si el personaje esta muerto
    public boolean estaMuerto(){
        return getEstadisticas().getVida()<=0;
    }
}
