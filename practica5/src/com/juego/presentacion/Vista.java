package com.juego.presentacion;

import com.juego.clases.*;
import com.juego.modelo.Combate;
import com.juego.modelo.Estadisticas;
import com.juego.modelo.Personaje;
import com.juego.razas.Elfo;
import com.juego.razas.Enano;
import com.juego.razas.Humano;
import com.juego.razas.Raza;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    private ArrayList<Personaje> listaPersonajes;
    private Personaje p1;
    private Personaje p2;
    private Combate combate;

    public Vista() {
        this.listaPersonajes = new ArrayList<>();
        this.p1 = new Personaje("Josemi", new Humano(), new Guerrero(), new Estadisticas());
        this.p2 = new Personaje("Santiago Abascal", new Elfo(), new Bardo(), new Estadisticas());
        this.p1.aniadirPersonajeLista(this.listaPersonajes);
        this.p2.aniadirPersonajeLista(this.listaPersonajes);
        this.combate = new Combate();
    }

    public void inicio() {
        System.out.println("=====================================");
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("=====================================");
        System.out.println("1.- Crear Personaje");
        System.out.println("2.- Jugar");
        System.out.println("3.- Salir");
        System.out.println("-------------------------------------");
        System.out.print("Selecciona una opción: ");

        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                crearPersonaje();
                break;
            case 2:
                Personaje p1 = seleccionPersonaje1();
                Personaje p2 = seleccionPersonaje2();
                System.out.println("=====================================");
                System.out.println("            COMBATE INICIADO ");
                System.out.println("=====================================");
                combate.iniciarCombate(p1, p2);
                break;
            case 3:
                System.out.println("=====================================");
                System.out.println("    Gracias por jugar. ¡Hasta pronto!");
                System.out.println("=====================================");
                break;
        }
    }

    public Raza seleccionaRaza() {
        System.out.println("-------------------------------------");
        System.out.println("          SELECCIÓN DE RAZA");
        System.out.println("-------------------------------------");
        System.out.println("1.- Elfo");
        System.out.println("2.- Humano");
        System.out.println("3.- Enano");
        System.out.print("Elige una raza: ");

        Scanner sc = new Scanner(System.in);
        int opcionElegida = sc.nextInt();

        switch (opcionElegida) {
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

    public Clase seleccionaClase() {
        System.out.println("-------------------------------------");
        System.out.println("          SELECCIÓN DE CLASE");
        System.out.println("-------------------------------------");
        System.out.println("1.- Bardo");
        System.out.println("2.- Druida");
        System.out.println("3.- Guerrero");
        System.out.println("4.- Mago");
        System.out.println("5.- Monje");
        System.out.println("6.- Paladin");
        System.out.println("7.- Picaro");
        System.out.println("8.- Sacerdote");
        System.out.print("Elige una clase: ");

        Scanner sc = new Scanner(System.in);
        int opcionElegida = sc.nextInt();

        switch (opcionElegida) {
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

    public void crearPersonaje() {
        System.out.println("=====================================");
        System.out.println("         CREAR NUEVO PERSONAJE  ");
        System.out.println("=====================================");
        System.out.print("Nombre del personaje: ");

        Scanner sc = new Scanner(System.in);
        String nombrePersonaje = sc.nextLine();

        Raza razaElegida = seleccionaRaza();
        Clase claseElegida = seleccionaClase();

        Estadisticas estadisticas = new Estadisticas();
        Personaje personajeCreado =
                new Personaje(nombrePersonaje, razaElegida, claseElegida, estadisticas);

        personajeCreado.aniadirPersonajeLista(this.listaPersonajes);

        System.out.println("-------------------------------------");
        System.out.println("   Personaje creado correctamente");
        System.out.println("-------------------------------------");

        inicio();
    }

    public Personaje seleccionPersonaje1() {
        int contador = 1;
        System.out.println("-------------------------------------");
        System.out.println("        SELECCIÓN PERSONAJE 1");
        System.out.println("-------------------------------------");

        for (Personaje personaje : listaPersonajes) {
            System.out.println(contador + ".- " + personaje.toString());
            contador++;
        }

        System.out.print("Elige personaje: ");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();

        return listaPersonajes.get(eleccion - 1);
    }

    public Personaje seleccionPersonaje2() {
        int contador = 1;
        System.out.println("-------------------------------------");
        System.out.println("        SELECCIÓN PERSONAJE 2");
        System.out.println("-------------------------------------");

        for (Personaje personaje : listaPersonajes) {
            System.out.println(contador + ".- " + personaje.toString());
            contador++;
        }

        System.out.print("Elige personaje: ");
        Scanner sc = new Scanner(System.in);
        int eleccion = sc.nextInt();

        return listaPersonajes.get(eleccion - 1);
    }
}

