package com.juego.modelo;
import com.juego.habilidades.Habilidades;
import java.util.Scanner;

public class Combate {

    public Combate() {

    }

    //funcion para que un personaje utilice un movimiento
    public boolean usarMovimiento(Personaje p1, Personaje p2, int eleccion) {

        if (eleccion < 1 || eleccion > 3) {
            System.out.println("Movimiento no válido. Elige otra opción.");
            return false;
        }

        Habilidades habilidad1 = p1.getListaHabilidades().get(eleccion - 1);

        if (habilidad1.getUsos() <= 0) {
            System.out.println("No te quedan usos para ese movimiento. Elige otro.");
            return false;
        }

        System.out.println("\nHas utilizado: " + habilidad1.getNombre());

        if (habilidad1.toString().contains("daño")) {
            System.out.println("El enemigo recibe " + habilidad1.getdanio() + " de daño");
            p2.getEstadisticas().setVida(
                    p2.getEstadisticas().getVida() - habilidad1.getdanio()
            );
        } else {
            System.out.println("Recuperas " + habilidad1.getdanio() + " de vida");
            p1.getEstadisticas().setVida(
                    p1.getEstadisticas().getVida() + habilidad1.getdanio()
            );
        }

        habilidad1.usarHabilidad();
        return true;
    }

    //funcion que inicia el combate
    public void iniciarCombate(Personaje p1, Personaje p2) {

        int contador = 1;
        Scanner sc = new Scanner(System.in);

        while (p1.getEstadisticas().getVida() > 0 &&
                p2.getEstadisticas().getVida() > 0) {

            System.out.println("\n==============================");
            System.out.println("           TURNO " + contador);
            System.out.println("==============================");

            System.out.println("\n  VIDAS ACTUALES");
            System.out.println("------------------------------");
            p1.mostrarVidas(1);
            p2.mostrarVidas(2);

            System.out.println("\nTURNO DEL JUGADOR 1");
            System.out.println("------------------------------");
            p1.mostrarDatos();

            boolean movimientoValido;
            do {
                System.out.print("Elige tu próximo movimiento: ");
                int eleccion = sc.nextInt();
                movimientoValido = usarMovimiento(p1, p2, eleccion);
            } while (!movimientoValido);

            if (p2.estaMuerto()) break;

            System.out.println("\nTURNO DEL JUGADOR 2");
            System.out.println("------------------------------");
            p2.mostrarDatos();

            do {
                System.out.print("Elige tu próximo movimiento: ");
                int eleccion = sc.nextInt();
                movimientoValido = usarMovimiento(p2, p1, eleccion);
            } while (!movimientoValido);

            contador++;
        }

        System.out.println("\n==============================");
        System.out.println("          FIN DEL COMBATE");
        System.out.println("==============================");

        if (p1.estaMuerto()) {
            System.out.println(" El jugador 2 ha ganado");
        } else {
            System.out.println(" El jugador 1 ha ganado");
        }
    }
}

