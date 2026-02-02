import com.juego.habilidades.Habilidades;
import com.juego.modelo.Personaje;

import java.util.Scanner;

public class Combate {

    public Combate() {}

    // Función para que un personaje use un movimiento
    public boolean usarMovimiento(Personaje atacante, Personaje defensor, int eleccion) {

        if (eleccion < 1 || eleccion > atacante.getListaHabilidades().size()) {
            System.out.println("Movimiento no válido. Elige otra opción.");
            return false;
        }

        Habilidades habilidad = atacante.getListaHabilidades().get(eleccion - 1);

        if (habilidad.getUsos() <= 0) {
            System.out.println("No te quedan usos para ese movimiento. Elige otro.");
            return false;
        }

        System.out.println("\nHas utilizado: " + habilidad.getNombre());

        // ACTIVAR FURIA
        if (habilidad.getNombre().equals("Furia")) {
            atacante.activarFuria();
            System.out.println("¡ENTRAS EN FURIA DURANTE 2 TURNOS!");
            habilidad.usarHabilidad();
            return true;
        }

        // ATAQUE
        if (habilidad.toString().contains("daño")) {

            int daño = habilidad.getdanio();

            if (atacante.isEnFuria()) {
                daño *= 2;
                System.out.println("¡FURIA ACTIVA! Daño x2");
            }

            System.out.println("El enemigo recibe " + daño + " de daño");
            defensor.getEstadisticas().setVida(
                    defensor.getEstadisticas().getVida() - daño
            );
        }
        // CURACIÓN
        else {
            System.out.println("Recuperas " + habilidad.getdanio() + " de vida");
            atacante.getEstadisticas().setVida(
                    atacante.getEstadisticas().getVida() + habilidad.getdanio()
            );
        }

        habilidad.usarHabilidad();
        return true;
    }

    // Función que inicia el combate
    public void iniciarCombate(Personaje p1, Personaje p2) {

        Scanner sc = new Scanner(System.in);
        int turno = 1;

        while (p1.getEstadisticas().getVida() > 0 &&
                p2.getEstadisticas().getVida() > 0) {

            System.out.println("\n==============================");
            System.out.println("           TURNO " + turno);
            System.out.println("==============================");

            System.out.println("\n  VIDAS ACTUALES");
            System.out.println("------------------------------");
            p1.mostrarVidas(1);
            p2.mostrarVidas(2);

            // TURNO JUGADOR 1
            System.out.println("\nTURNO DEL JUGADOR 1");
            System.out.println("------------------------------");
            p1.mostrarDatos();

            boolean movimientoValido;
            int eleccion1;

            do {
                System.out.print("Elige tu próximo movimiento: ");
                eleccion1 = sc.nextInt();
                movimientoValido = usarMovimiento(p1, p2, eleccion1);
            } while (!movimientoValido);

            p1.reducirFuria();
            if (p2.estaMuerto()) break;

            // TURNO JUGADOR 2
            System.out.println("\nTURNO DEL JUGADOR 2");
            System.out.println("------------------------------");
            p2.mostrarDatos();

            int eleccion2;
            do {
                System.out.print("Elige tu próximo movimiento: ");
                eleccion2 = sc.nextInt();
                movimientoValido = usarMovimiento(p2, p1, eleccion2);
            } while (!movimientoValido);

            p2.reducirFuria();
            if (p1.estaMuerto()) break;

            turno++;
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


