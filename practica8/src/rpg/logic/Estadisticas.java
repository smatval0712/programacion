package rpg.logic;

import rpg.model.Personaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Estadisticas {

    // Top 3 jugadores mas ricos
    public void top3Ricos(ArrayList<Personaje> personajes) {
        ArrayList<Personaje> copia = new ArrayList<>(personajes);

        Collections.sort(copia, new Comparator<Personaje>() {
            public int compare(Personaje p1, Personaje p2) {
                return p2.getOro().compareTo(p1.getOro());
            }
        });

        System.out.println("\n==============================");
        System.out.println("       TOP 3 MÁS RICOS");
        System.out.println("==============================");
        for (int i = 0; i < Math.min(3, copia.size()); i++) {
            Personaje p = copia.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " -> " + p.getOro() + " de oro");
        }
    }

    // Censo de clases
    public void censoPorClase(ArrayList<Personaje> personajes) {
        HashMap<String, Integer> censo = new HashMap<>();

        for (int i = 0; i < personajes.size(); i++) {
            String clase = personajes.get(i).getClase().getNombre();
            if (censo.containsKey(clase)) {
                censo.put(clase, censo.get(clase) + 1);
            } else {
                censo.put(clase, 1);
            }
        }

        System.out.println("\n==============================");
        System.out.println("       CENSO DE CLASES");
        System.out.println("==============================");
        for (String clase : censo.keySet()) {
            System.out.println(clase + ": " + censo.get(clase) + " personaje/s");
        }
    }
}