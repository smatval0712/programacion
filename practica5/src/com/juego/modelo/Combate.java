package com.juego.modelo;

import com.juego.habilidades.Habilidades;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Combate {
    Personaje p1;
    Personaje p2;


    public Combate(Personaje p1, Personaje p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void iniciar(Personaje p1, Personaje p2){
        int contador=1;
        while(this.p1.getEstadisticas().getVida()>0&&this.p2.getEstadisticas().getVida()>0){
            System.out.println("Turno " +contador);
            p1.mostrarDatos();
            System.out.println("Elige tu próximo movimiento: ");
            Scanner sc = new Scanner(System.in);
            int eleccion=sc.nextInt();
            if (eleccion==1){
               Habilidades habilidad1=p1.getListaHabilidades().get(0);
               habilida1.get
            }
        }
    }
}
