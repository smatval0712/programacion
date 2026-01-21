package com.juego.modelo;

import com.juego.clases.*;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
private ArrayList<Personaje> listaPersonajes;
private ArrayList<Raza> listaRazas;
private ArrayList<Clase> listaClases;
private Personaje p1;
private Personaje p2;



    public Vista(){
        this.listaPersonajes= new ArrayList<>();
        this.p1= new Personaje("Josemi",new Humano(),new Guerrero(),new Estadisticas());
        this.p2=new Personaje("Santiago Abascal", new Elfo(), new Bardo(), new Estadisticas());
        this.p1.aniadirPersonajeLista(this.listaPersonajes);
        this.p2.aniadirPersonajeLista(this.listaPersonajes);

    }

    public void inicio(){
        System.out.println("¡¡Comienza el juego!!");
        System.out.println("Selecciona una opción: ");
        System.out.println("1.- Crear Personaje");
        System.out.println("2.- Jugar");
        System.out.println("3.- Salir");
        Scanner sc = new Scanner(System.in);
        int eleccion=sc.nextInt();
        switch (eleccion){
            case 1: crearPersonaje();
                    break;
            case 2:
                Personaje p1=seleccionPersonaje1();
                Personaje p2=seleccionPersonaje2();
                Combate combate=new Combate();
                combate.iniciarCombate(p1,p2);
                break;
            case 3:
                System.out.println("Hasta luego, muchas gracias por jugar");
                break;
        }
    }

    public Raza seleccionaRaza(){

        System.out.println("Selecciona una Raza");
        System.out.println("1.-Elfo");
        System.out.println("2.-Humano");
        System.out.println("3.-Enano");

        Scanner sc = new Scanner(System.in);
        int opcionElegida= sc.nextInt();

        switch(opcionElegida){
            case 1:
                return new Elfo();
            case 2:
                return new Humano();
            case 3:
                return new Enano();
            default:
                return new Elfo();
        }
    }

    public Clase seleccionaClase(){
        System.out.println("Selecciona una Clase");
        System.out.println("1.-Bardo");
        System.out.println("2.-Druida");
        System.out.println("3.-Guerrero");
        System.out.println("4.- Mago");
        System.out.println("5.- Monje");
        System.out.println("6.- Paladin");
        System.out.println("7.- Picaro");
        System.out.println("8.- Sacerdote");

        Scanner sc = new Scanner(System.in);
        int opcionElegida= sc.nextInt();

        switch(opcionElegida){
            case 1:
                return new Bardo();
            case 2:
                return new Druida();
            case 3:
                return new Guerrero();
            case 4:
                return new Mago();
            case 5:
                return new Monje();
            case 6:
                return new Paladin();
            case 7:
                return new Picaro();
            case 8:
                return new Sacerdote();
            default:
                return new Guerrero();
        }

    }

    public void crearPersonaje(){
        System.out.println("Has elegido la opción de crear un nuevo personaje, comencemos: ");
        System.out.println("Elige un nombre para tu personaje: ");
        Scanner sc = new Scanner(System.in);
        String nombrePersonaje = sc.nextLine();
        System.out.println("Elige una raza");
        Raza razaElegida=seleccionaRaza();
        System.out.println("Elige una clase");
        Clase claseElegida=seleccionaClase();
        Estadisticas estadisticas=new Estadisticas();
        Personaje personajeCreado=new Personaje(nombrePersonaje,razaElegida,claseElegida,estadisticas);
        personajeCreado.aniadirPersonajeLista(this.listaPersonajes);
        inicio();

    }

    public Personaje seleccionPersonaje1(){
        int contador=1;
        System.out.println("Elige personaje 1");
        for(Personaje personaje:listaPersonajes){
            System.out.println(contador +".- " +personaje.toString());
            contador++;
        }
        Scanner sc = new Scanner(System.in);
        int eleccion= sc.nextInt();
        return listaPersonajes.get(eleccion-1);
    }
    public Personaje seleccionPersonaje2(){
        int contador=1;
        System.out.println("Elige personaje 2");
        for(Personaje personaje:listaPersonajes){
            System.out.println(contador +".- " +personaje.toString());
            contador++;
        }
        Scanner sc = new Scanner(System.in);
        int eleccion= sc.nextInt();
        return listaPersonajes.get(eleccion-1);
    }

}
