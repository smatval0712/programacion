import java.util.*;

public class Bloque3 {
    //Ejercicio11
    private Map<String, Double> preciosItems;
    private Map<String, ArrayList<String>> ciudadesItems;
    //Ejercicio12
    private Map<String, Map<String, Boolean>> habilidades;
    //Ejercicio13
    private Map<String, List<HashSet<String>>> historial;
    //Ejercicio14
    private Map<String, List<String>> mensajes;
    HashSet<String> jugadoresSilenciados;
    //Ejercicio15
    private HashMap<String, ArrayList<Map<String, Double>>> subastas;
    private HashMap<String, Double> saldoJugadores;

    public Bloque3() {
        //Ejercicio11
        this.preciosItems = new HashMap<>(Map.of(
                "Espada de hierro", 50.2,
                "Espada oxidada", 25.8,
                "Armadura de cuero", 15.0,
                "Poción de vida", 25.0,
                "Poción de maná", 30.0,
                "Anillo mágico", 120.0,
                "Arco de cazador", 60.0
        ));
        this.ciudadesItems = new HashMap<>();
        rellenaCiudadesItems();
        //Ejercicio12
        this.habilidades = new HashMap<>();
        rellenaHabilidades();
        //Ejercicio13
        this.historial = new HashMap<>();
        rellenaRaids();
        //Ejercicio14
        this.mensajes = new HashMap<>();
        rellenaMensajes();
        this.jugadoresSilenciados = new HashSet<>();
        //Ejercicio15
        this.subastas = new HashMap<>();
        this.saldoJugadores = new HashMap<>();
        rellenarDatos();
    }

    //-----------------------------------------------------------
    //Ejercicio 11 --> El sistema de Comercio y Precios Dinámicos
    //-----------------------------------------------------------
    //Funcion que rellena el HashMap de ciudadesItems
    public void rellenaCiudadesItems() {
        this.ciudadesItems.put("Fortaleza Roja", new ArrayList<>(List.of(
                "Espada de hierro",
                "Armadura de cuero",
                "Anillo mágico"
        )));
        this.ciudadesItems.put("Arcania", new ArrayList<>(List.of(
                "Arco de cazador",
                "Armadura de cuero",
                "Poción de vida"
        )));
        this.ciudadesItems.put("Torreblanca", new ArrayList<>(List.of(
                "Arco de cazador",
                "Espada oxidada",
                "Poción de maná",
                "Anillo mágico",
                "Armadura de cuero",
                "Poción de vida"
        )));
    }

    //Funcion que comprueba si la ciudad tiene mas de 5 items y le aplica un impuesto
    public void impuestoLujo(String ciudad) {
        if (!ciudadesItems.containsKey(ciudad)) {
            System.out.println("La ciudad no existe");
            return;
        }
        ArrayList<String> items = ciudadesItems.get(ciudad);
        if (items.size() >= 5) {
            for (String item : preciosItems.keySet()) {
                preciosItems.put(item, preciosItems.get(item) * 0.1 + preciosItems.get(item));
            }
        }
    }

    //Funcion de pruebas que recorre el array de preciosItems
    public void recorrePreciosItems() {
        for (String item : preciosItems.keySet()) {
            System.out.println(item + " " + preciosItems.get(item));
        }
    }

    //-----------------------------------------------------------
    //Ejercicio 12 --> Gestión de Árboles de Habilidades
    //-----------------------------------------------------------
    //Funcion que rellena el hashmap de habilidades
    public void rellenaHabilidades() {
        this.habilidades.put("Paladín", new HashMap<>(Map.of(
                "Enfoque", true,
                "Golpe Divino", false,
                "Canto de luz", false
        )));
        this.habilidades.put("Pícaro", new HashMap<>(Map.of(
                "Enfoque", false,
                "Golpe Divino", false,
                "Canto de luz", false
        )));
    }

    //Funcion de pruebas que recorre el array de habilidades
    public void recorreHabilidades() {
        for (String personaje : habilidades.keySet()) {
            System.out.println(personaje + " ");
            for (Map.Entry<String, Boolean> hab : habilidades.get(personaje).entrySet()) {
                System.out.println(hab.getKey() + " " + hab.getValue());
            }
        }
    }

    //Funcion para comprobar si tiene desbloqueada enfoque
    public void desbloqueaGolpeDivino(String personaje) {
        Map<String, Boolean> habi = habilidades.get(personaje);
        if (habi.get("Enfoque") == true) {
            System.out.println(personaje + " desbloquea Golpe Divino");
            habi.put("Golpe Divino", true);
        } else {
            System.out.println("Error, " + personaje + " no puede desbloquear Golpe Divino porque no ha desbloqueado Enfoque");
        }
    }

    //-----------------------------------------------------------
    //Ejercicio 13 --> El historial de incursiones (Raid Tracker)
    //----------------------------------------------------------
    //Funcion que rellena el hashmap de raids
    public void rellenaRaids() {

        // ===== MAZMORRA 1 =====
        List<HashSet<String>> raidsCastillo = new ArrayList<>();

        raidsCastillo.add(new HashSet<>(List.of("Thalion", "Eldria", "Brom")));
        raidsCastillo.add(new HashSet<>(List.of("Brom", "Kael", "Thalion")));
        raidsCastillo.add(new HashSet<>(List.of("Eldria", "Brom", "Lyra")));
        historial.put("Cueva del Dragón", raidsCastillo);


        // ===== MAZMORRA 2 =====
        List<HashSet<String>> raidsTorre = new ArrayList<>();

        raidsTorre.add(new HashSet<>(List.of("Thalion", "Kael", "Lyra")));
        raidsTorre.add(new HashSet<>(List.of("Brom", "Thalion", "Draven")));
        historial.put("Torre Oscura", raidsTorre);


        // ===== MAZMORRA 3 =====
        List<HashSet<String>> raidsCripta = new ArrayList<>();

        raidsCripta.add(new HashSet<>(List.of("Eldria", "Draven", "Brom")));
        historial.put("Cripta Maldita", raidsCripta);
    }

    public void jugadorMasValioso() {
        Map<String, Integer> contador = new HashMap<>();
        //Recorremos los valores List<HashSet<String>> del map historial
        for (List<HashSet<String>> listaRaids : historial.values()) {
            //Recorremos los valores HashSet<String> de los listaRaid anteriores
            for (HashSet<String> raid : listaRaids) {
                //Recorremos los jugadores de los hashset raid anteriores
                for (String jugadores : raid) {
                    //Añade los jugadores al map de contador y va contando las apariciones, si no esta el jugador se añade como 0 y si existe le suma 1
                    contador.put(jugadores, contador.getOrDefault(jugadores, 0) + 1);
                }
            }

        }
        String mvp = null;
        int maxParticipaciones = 0;
        //Recorremos cada entrada del map contador y comparamos cada valor con el maximo, si es mayor, maximo es igual a el y mvp es el valor de la clave
        for (Map.Entry<String, Integer> mas : contador.entrySet()) {
            if (mas.getValue() > maxParticipaciones) {
                maxParticipaciones = mas.getValue();
                mvp = mas.getKey();
            }
        }
        System.out.println("El MPV es: " + mvp + " con " + maxParticipaciones + " raids ");
    }

    //-----------------------------------------------------------
    //Ejercicio 14 --> El Sistema de Mensajeria Global
    //----------------------------------------------------------
    //Funcin que rellena el hashmap de mensajes
    public void rellenaMensajes() {
        List<String> mensajesBrom = new ArrayList<>();
        mensajesBrom.add("Hola");
        mensajesBrom.add("Ataca");
        mensajesBrom.add("Defiende");
        mensajesBrom.add("Adios");
        mensajesBrom.add("Adios");
        mensajesBrom.add("Adios");
        this.mensajes.put("Brom", mensajesBrom);

        List<String> mensajesLyra = new ArrayList<>();
        mensajesLyra.add("Hola");
        mensajesLyra.add("Ataca");
        mensajesLyra.add("Defiende");
        mensajesLyra.add("Adios");
        this.mensajes.put("Lyra", mensajesLyra);
    }

    //funcion reto que analiza los 3 ultimos mensajes de los jugadores y si hay repetidos los añade a un hashmap y borra el historial de mensajes del jugador
    public void filtroSpam() {
        for (String jugador : mensajes.keySet()) {
            List<String> mensajesJugador = mensajes.get(jugador);
            if (mensajesJugador.size() >= 3) {
                //Guardamos la longitud del array
                int longitud = mensajesJugador.size();
                //sacamos los 3 ultimos mensajes
                String mensaje1 = mensajesJugador.get(longitud - 1);
                String mensaje2 = mensajesJugador.get(longitud - 2);
                String mensaje3 = mensajesJugador.get(longitud - 3);
                //Comprobamos los 3 ultimos y si hay alguno repetido, añadimos el personaje al hashset de jugadoresSilenciados y eliminamos el registro de mensajes
                if (mensaje1.equals(mensaje2) || mensaje1.equals(mensaje3) || mensaje2.equals(mensaje3)) {
                    jugadoresSilenciados.add(jugador);
                    mensajesJugador.clear();

                    System.out.println("El jugador " + jugador + " ha silo silenciado por spam");
                }

            }

        }
    }

    //----------------------------------------------------------
    //Ejercicio 15 --> Simulador de economia de subastas
    //----------------------------------------------------------
    //Funcion que rellena los datos
    public void rellenarDatos() {

        // Saldos
        saldoJugadores.put("Arthas", 100.0);
        saldoJugadores.put("Brom", 50.0);
        saldoJugadores.put("Lyra", 200.0);

        // Pujas para Excalibur
        ArrayList<Map<String, Double>> pujas =
                new ArrayList<>();

        Map<String, Double> p1 = new HashMap<>();
        p1.put("Arthas", 80.0);

        Map<String, Double> p2 = new HashMap<>();
        p2.put("Brom", 60.0);

        Map<String, Double> p3 = new HashMap<>();
        p3.put("Lyra", 120.0);

        pujas.add(p1);
        pujas.add(p2);
        pujas.add(p3);

        subastas.put("Excalibur", pujas);
    }


    //Funcion que preocesa la venta
    public void procesarVenta(String item) {

        ArrayList<Map<String, Double>> lista =
                subastas.get(item);

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay pujas");
            return;
        }

        // ordenar de mayor a menor
        lista.sort((a, b) -> {
            double va = a.values().iterator().next();
            double vb = b.values().iterator().next();
            return Double.compare(vb, va);
        });

        while (!lista.isEmpty()) {

            Map<String, Double> mejor = lista.get(0);

            String jugador =
                    mejor.keySet().iterator().next();

            double cantidad =
                    mejor.get(jugador);

            double saldo =
                    saldoJugadores.getOrDefault(jugador, 0.0);

            if (saldo >= cantidad) {

                saldoJugadores.put(
                        jugador,
                        saldo - cantidad
                );

                System.out.println(
                        jugador + " compra " + item +
                                " por " + cantidad + " de oro"
                );

                subastas.remove(item);
                return;
            } else {
                System.out.println(
                        jugador + " no tiene oro suficiente"
                );

                lista.remove(0);
            }
        }

        System.out.println(
                "Nadie pudo comprar el item"
        );
    }
}

