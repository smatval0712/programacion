package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.model.Habilidad;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MotorCombate {
    private PersonajeDAO personajeDAO;

    public MotorCombate(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }

    // Calcula el ataque total del personaje (fuerza raza + bonificador items)
    public int calcularAtaque(Personaje p) {
        int ataque = p.getRaza().getBonificador_fuerza();
        for (Item i : p.getInventario().keySet()) {
            ataque += i.getBonificador_ataque();
        }
        return ataque;
    }

    // Calcula la defensa total del personaje (suma bonificador items)
    public int calcularDefensa(Personaje p) {
        int defensa = 0;
        for (Item i : p.getInventario().keySet()) {
            defensa += i.getBonificador_defensa();
        }
        return defensa;
    }

    // Funcion para usar un movimiento
    public boolean usarMovimiento(Personaje atacante, Personaje defensor, int eleccion,
                                  List<Habilidad> habilidadesDisponibles, int defensa,
                                  int ataqueBasico, Map<Habilidad, Integer> usosTemporales) {
        if (eleccion == 1) {
            int danio = Math.max(0, ataqueBasico - (defensa / 2));
            System.out.println("\nHas utilizado: Ataque básico");
            System.out.println(atacante.getNombre() + " hace " + danio + " de daño.");
            defensor.setVida_actual(defensor.getVida_actual() - danio);
            return true;
        }

        int indiceHabilidad = eleccion - 2;
        if (indiceHabilidad < 0 || indiceHabilidad >= habilidadesDisponibles.size()) {
            System.out.println("Movimiento no válido. Elige otra opción.");
            return false;
        }

        Habilidad habilidadElegida = habilidadesDisponibles.get(indiceHabilidad);

        if (usosTemporales.get(habilidadElegida) <= 0) {
            System.out.println("No te quedan usos para ese movimiento. Elige otro.");
            return false;
        }

        int danio = Math.max(0, habilidadElegida.getDanio_base() - (defensa / 2));
        System.out.println("\nHas utilizado: " + habilidadElegida.getNombre());
        System.out.println(atacante.getNombre() + " hace " + danio + " de daño.");
        defensor.setVida_actual(defensor.getVida_actual() - danio);
        usosTemporales.put(habilidadElegida, usosTemporales.get(habilidadElegida) - 1);
        return true;
    }

    // Funcion para mostrar las opciones de combate
    private void mostrarOpciones(Personaje p, int ataqueBasico,
                                 List<Habilidad> habilidades, Map<Habilidad, Integer> usos) {
        System.out.println("  Ataque: " + ataqueBasico + " | Defensa: " + calcularDefensa(p));
        System.out.println("------------------------------");
        System.out.println("1. Ataque básico (daño: " + ataqueBasico + ")");
        int opcion = 2;
        for (Habilidad h : habilidades) {
            System.out.println(opcion + ". " + h.getNombre() +
                    " (daño: " + h.getDanio_base() +
                    ", usos restantes: " + usos.get(h) + ")");
            opcion++;
        }
    }

    // Funcion que inicia el combate
    public void iniciarCombate(Personaje p1, Personaje p2) {
        Log.info("Inicio de combate: " + p1.getNombre() + " VS " + p2.getNombre());

        System.out.println("\n==============================");
        System.out.println("       COMIENZA EL COMBATE");
        System.out.println("==============================");
        System.out.println("  " + p1.getNombre() + " VS " + p2.getNombre());

        int ataqueP1 = calcularAtaque(p1);
        int defensaP1 = calcularDefensa(p1);
        int ataqueP2 = calcularAtaque(p2);
        int defensaP2 = calcularDefensa(p2);

        // Usos temporales en memoria
        Map<Habilidad, Integer> usosP1 = new HashMap<>();
        Map<Habilidad, Integer> usosP2 = new HashMap<>();
        List<Habilidad> habilidadesP1 = new ArrayList<>();
        List<Habilidad> habilidadesP2 = new ArrayList<>();

        for (Habilidad h : p1.getHabilidades().keySet()) {
            if (p1.getHabilidades().get(h)) {
                usosP1.put(h, h.getUsos_maximos());
                habilidadesP1.add(h);
            }
        }
        for (Habilidad h : p2.getHabilidades().keySet()) {
            if (p2.getHabilidades().get(h)) {
                usosP2.put(h, h.getUsos_maximos());
                habilidadesP2.add(h);
            }
        }

        Scanner sc = new Scanner(System.in);
        int contador = 1;

        while (p1.getVida_actual() > 0 && p2.getVida_actual() > 0) {

            System.out.println("\n==============================");
            System.out.println("           TURNO " + contador);
            System.out.println("==============================");

            System.out.println("\n  VIDAS ACTUALES");
            System.out.println("------------------------------");
            System.out.println("  " + p1.getNombre() + ": " + Math.max(0, p1.getVida_actual()) + " HP");
            System.out.println("  " + p2.getNombre() + ": " + Math.max(0, p2.getVida_actual()) + " HP");

            // Turno P1
            System.out.println("\nTURNO DE " + p1.getNombre().toUpperCase());
            System.out.println("------------------------------");
            mostrarOpciones(p1, ataqueP1, habilidadesP1, usosP1);

            boolean movimientoValido;
            do {
                System.out.print("Elige tu próximo movimiento: ");
                int eleccion = sc.nextInt();
                movimientoValido = usarMovimiento(p1, p2, eleccion, habilidadesP1, defensaP2, ataqueP1, usosP1);
            } while (!movimientoValido);

            if (p2.getVida_actual() <= 0) break;

            // Turno P2
            System.out.println("\nTURNO DE " + p2.getNombre().toUpperCase());
            System.out.println("------------------------------");
            mostrarOpciones(p2, ataqueP2, habilidadesP2, usosP2);

            do {
                System.out.print("Elige tu próximo movimiento: ");
                int eleccion = sc.nextInt();
                movimientoValido = usarMovimiento(p2, p1, eleccion, habilidadesP2, defensaP1, ataqueP2, usosP2);
            } while (!movimientoValido);

            contador++;
        }

        System.out.println("\n==============================");
        System.out.println("         FIN DEL COMBATE");
        System.out.println("==============================");

        Personaje ganador = p1.getVida_actual() > 0 ? p1 : p2;
        Personaje perdedor = p1.getVida_actual() > 0 ? p2 : p1;

        System.out.println("  ¡" + ganador.getNombre() + " ha ganado el combate!");

        int oroRobado = (int) (perdedor.getOro() * 0.2);
        ganador.setOro(ganador.getOro() + oroRobado);
        perdedor.setOro(perdedor.getOro() - oroRobado);

        personajeDAO.restarOroPersonaje(ganador.getOro(), ganador);
        personajeDAO.restarOroPersonaje(perdedor.getOro(), perdedor);

        System.out.println("  " + ganador.getNombre() + " ha robado " + oroRobado + " de oro a " + perdedor.getNombre());
        Log.info("Fin de combate: " + ganador.getNombre() + " ha ganado y ha robado " + oroRobado + " de oro a " + perdedor.getNombre());
    }
}
