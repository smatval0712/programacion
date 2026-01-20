package com.juego.modelo;

import com.juego.habilidades.Habilidades;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Combate {

    public Combate() {

    }

    //funcion para que un personaje utilice un movimiento
    public boolean usarMovimiento(Personaje p1, Personaje p2, int eleccion) {
        //si elegimos una opcion distinta de 1,2 o 3 devuelve falso
        if(eleccion<1||eleccion>3){
            System.out.println("Ese no es un movimiento válido, elige otro");
            return false;
        }
        //establecemos que a la habilidad que cogemos le restamos uno ya que en el array se guardan desde 0
        Habilidades habilidad1 = p1.getListaHabilidades().get(eleccion-1);
        //si no nos quedan usos devueve falso
        if (habilidad1.getUsos()<=0){
            System.out.println("No te quedan usos para ese movimiento, elige otro");
            return false;
        }
        //mostramos el nombre la habilidad que hemos utilizado
        System.out.println("Has utilizado " + habilidad1.getNombre());
        //si el toString() de la habilidad contiene daño mostrara el mensaje
            if (habilidad1.toString().contains("daño")) {
                System.out.println("El enemigo recibe " + habilidad1.getdanio() + " de daño");
                p2.getEstadisticas().setVida(p2.getEstadisticas().getVida() - habilidad1.getdanio());

                //si no contiene daño muestra el mensaje de que recibes vida
            } else {
                System.out.println("Recibes " + habilidad1.getdanio() + " de vida");
                p1.getEstadisticas().setVida(p1.getEstadisticas().getVida() + habilidad1.getdanio());
            }

            //usamos la funcion usarHabilidad para que reste el numero de usos
            habilidad1.usarHabilidad();
            //devuelve true si se hace correctamente todo
            return true;
    }


    //funcion que inicia el combate
    public void iniciar(Personaje p1, Personaje p2){
        //contador que indica el turno en el que estamos
        int contador=1;
        //bucle que se repite mientras las vidas sean mayor que 0
        while(p1.getEstadisticas().getVida()>0&&p2.getEstadisticas().getVida()>0){
            System.out.println("Turno " +contador);
            //mostramos los datos del personaje 1
            p1.mostrarDatos();
            //elegimos el movimiento y lo guardamos en la variable eleccion de tipo int
            Scanner sc = new Scanner(System.in);
            //creamos una variable de tipo boolean para saber si el movimiento se puede realizar o no segun la funcion usarMovimiento
            boolean movimientoValido;
            //bucle que nos pide un movimiento, si seleccionamos un movimiento no valido, ya sea porque elegimos un numero que no esta en la lista
            //o porque no nos quedan usos, se vuelve a ejecutar gracias a la variable boolean movimientoValido, a la cual le damos valor true o false
            //mediante el return de la funcion usarMovimiento
            do {
                System.out.println("Elige tu próximo movimiento: ");
                int eleccion=sc.nextInt();
                //establecemos que movimientoValido tendra el valor del return de la funcion usarMovimiento
                movimientoValido=usarMovimiento(p1,p2,eleccion);
                //ejecutamos el bucle mientras el valor de la variable movimientoValido sea false gracias a la negacion con !
                } while(!movimientoValido);
            //empieza el personaje 2 mostrando los datos y se repite la misma ejecucion que con el personaje 1
            p2.mostrarDatos();
            do {
                System.out.println("Elige tu próximo movimiento: ");
                //elegimos el movimiento y lo guardamos en la variable eleccion de tipo int
                int eleccion=sc.nextInt();
                movimientoValido=usarMovimiento(p2,p1,eleccion);
            }while(!movimientoValido);
            contador++;
        }
        if (p1.estaMuerto()){
            System.out.println("El jugador 2 ha ganado");
        }
        else {
            System.out.println("El jugador 1 ha ganado");
        }
    }
}

