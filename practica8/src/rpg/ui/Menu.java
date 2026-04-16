package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.exception.FondosInsuficientesException;
import rpg.exception.LimiteHabilidadesException;
import rpg.exception.NivelInsuficienteException;
import rpg.logic.Estadisticas;
import rpg.logic.GestionMundo;
import rpg.logic.MotorCombate;
import rpg.model.*;
import rpg.utils.Log;

import java.util.Scanner;

public class Menu {
    private PersonajeDAO personajeDAO;
    private GestionMundo gestionMundo;

    public Menu() {
        this.personajeDAO = new PersonajeDAO();
        this.gestionMundo = new GestionMundo(this.personajeDAO);
    }

    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n================================");
            System.out.println("  JOSEMI BIENVENIDO A MI JUEGO");
            System.out.println("================================");
            System.out.println("1. Crear personaje");
            System.out.println("2. Viajar de ciudad");
            System.out.println("3. Comprar items");
            System.out.println("4. Equipar habilidades");
            System.out.println("5. Cobrar impuestos");
            System.out.println("6. Combate");
            System.out.println("7. Estadísticas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearPersonaje();
                    break;
                case 2:
                    viajarDeCiudad();
                    break;
                case 3:
                    Personaje p = elegirPersonaje();
                    comprarItems(p);
                    break;
                case 4:
                    equiparHabilidades();
                    break;
                case 5:
                    cobrarImpuestos();
                    break;
                case 6:
                    combate();
                    break;
                case 7:
                    estadisticas();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    //FUNCION PARA CREAR PERSONAJE
    public void crearPersonaje() {
        System.out.println("Introduce un nombre para tu personaje: ");
        String nombre = sc.next();

        // Elección de raza con validación
        Raza razaElegida = null;
        while (razaElegida == null) {
            System.out.println("Elije una raza introduciendo su id: ");
            for (Raza raza : personajeDAO.getRazaDAO().getRazas()) {
                System.out.println(raza.getId() + " -> " + raza.getNombre());
            }
            Integer Id_Raza_Elegida = sc.nextInt();
            for (Raza raza : personajeDAO.getRazaDAO().getRazas()) {
                if (raza.getId().equals(Id_Raza_Elegida)) {
                    razaElegida = raza;
                    break;
                }
            }
            if (razaElegida == null) {
                System.out.println("Raza no encontrada, por favor elige una id válida.");
            }
        }

        // Elección de clase con validación
        Clase claseElegida = null;
        while (claseElegida == null) {
            System.out.println("Elije una clase introduciendo su id: ");
            for (Clase clase : personajeDAO.getClaseDAO().getClases()) {
                System.out.println(clase.getId() + " -> " + clase.getNombre());
            }
            Integer Id_Clase_Elegida = sc.nextInt();
            for (Clase clase : personajeDAO.getClaseDAO().getClases()) {
                if (clase.getId().equals(Id_Clase_Elegida)) {
                    claseElegida = clase;
                    break;
                }
            }
            if (claseElegida == null) {
                System.out.println("Clase no encontrada, por favor elige una id válida.");
            }
        }

        // Elección de ciudad con validación
        Ciudad ciudadElegida = null;
        while (ciudadElegida == null) {
            System.out.println("Elije una ciudad introduciendo su id: ");
            for (Ciudad ciudad : personajeDAO.getCiudadDAO().getCiudades()) {
                System.out.println(ciudad.getId() + " -> " + ciudad.getNombre());
            }
            Integer Id_Ciudad_Elegida = sc.nextInt();
            for (Ciudad ciudad : personajeDAO.getCiudadDAO().getCiudades()) {
                if (ciudad.getId().equals(Id_Ciudad_Elegida)) {
                    ciudadElegida = ciudad;
                    break;
                }
            }
            if (ciudadElegida == null) {
                System.out.println("Ciudad no encontrada, por favor elige una id válida.");
            }
        }

        Integer vidaMaxima = 100 + razaElegida.getBonificador_vida();
        Integer nivel = 1;
        Integer oro = 100;
        Integer idGenerado = personajeDAO.insertarPesonajeEnBD(nombre, nivel, oro, vidaMaxima, razaElegida, claseElegida, ciudadElegida);
        Personaje personajeCreado = new Personaje(idGenerado, nombre, nivel, oro, vidaMaxima, razaElegida, claseElegida, ciudadElegida);
        personajeDAO.getHabilidadDAO().aniadirHabilidadesPersonaje(personajeCreado);
        personajeDAO.getHabilidadDAO().aniadirHabilidadBD(personajeCreado);
        personajeDAO.getPersonajes().add(personajeCreado);
        Log.info("Nuevo personaje creado: " + nombre + " | Raza: " + razaElegida.getNombre() + " | Clase: " + claseElegida.getNombre() + " | Ciudad: " + ciudadElegida.getNombre());
        System.out.println("Personaje " + nombre + " creado correctamente.");
    }

    //Funcion para cambiar la ciudad de un personaje
    public void viajarDeCiudad() {
        Personaje personajeElegido = elegirPersonaje();
        System.out.println("Selecciona la ciudad a la que quieres asignar el personaje: ");
        Ciudad ciudadElegida = elegirCiudad();

        try {
            if (personajeElegido.getNivel() < ciudadElegida.getNivel_minimo_acceso()) {
                throw new NivelInsuficienteException("Nivel insuficiente: " + personajeElegido.getNombre() +
                        " tiene nivel " + personajeElegido.getNivel() +
                        " y la ciudad requiere nivel " + ciudadElegida.getNivel_minimo_acceso());
            }
            personajeDAO.cambiarCiudadPersonaje(personajeElegido, ciudadElegida);
            System.out.println("Se ha cambiado la ciudad del Personaje.");
        } catch (NivelInsuficienteException e) {
            Log.error("Intento de viaje fallido: NivelInsuficienteException - " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    public Ciudad elegirCiudad() {
        Ciudad ciudadElegida = null;
        while (ciudadElegida == null) {
            for (Ciudad c : personajeDAO.getCiudadDAO().getCiudades()) {
                System.out.println(c.getId() + " -> " + c.getNombre());
            }
            Integer IdCiudadElegida = sc.nextInt();

            for (Ciudad c : personajeDAO.getCiudadDAO().getCiudades()) {
                if (c.getId().equals(IdCiudadElegida)) {
                    ciudadElegida = c;
                    break;
                }
            }
            if (ciudadElegida == null) {
                System.out.println("Esa ciudad no está en la lista, elige una id válida.");
            }
        }
        return ciudadElegida;
    }

    //Funcion para elegir personaje
    public Personaje elegirPersonaje() {
        Personaje personajeElegido = null;
        while (personajeElegido == null) {
            System.out.println("Selecciona el personaje:  ");
            for (Personaje p : personajeDAO.getPersonajes()) {
                System.out.println(p.getId() + " -> " + p.getNombre());
            }
            Integer IdPersonajeElegido = sc.nextInt();

            for (Personaje p : personajeDAO.getPersonajes()) {
                if (p.getId().equals(IdPersonajeElegido)) {
                    personajeElegido = p;
                    break;
                }
            }
            if (personajeElegido == null) {
                System.out.println("Ese personaje no está en la lista, elige una id válida.");
            }
        }
        return personajeElegido;
    }

    //Funcion que muestra los items y devuelve el seleccionado por id
    public Item elegirItem() {
        Item itemElegido = null;
        while (itemElegido == null) {
            System.out.println("Selecciona el item: ");
            for (Item i : personajeDAO.getItemsDAO().getItems()) {
                System.out.println(i.getId() + " -> " + i.getNombre() + " -> Precio: " + i.getPrecio_oro() + " de oro");
            }
            Integer idItemElegido = sc.nextInt();

            for (Item i : personajeDAO.getItemsDAO().getItems()) {
                if (i.getId().equals(idItemElegido)) {
                    itemElegido = i;
                    break;
                }
            }
            if (itemElegido == null) {
                System.out.println("Ese Item no está en la lista, elige una id válida.");
            }
        }
        return itemElegido;
    }

    //Funcion del menú comprarItems
    public void comprarItems(Personaje p) {
        System.out.println(p.getNombre() + " tiene " + p.getOro() + " monedas de oro");
        Item itemElegido = elegirItem();
        try {
            gestionMundo.comprarItems(p, itemElegido);
            System.out.println("Compra realizada correctamente.");
        } catch (FondosInsuficientesException e) {
            Log.error("Intento de compra fallido: FondosInsuficientesException - " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    //FUNCION PARA COBRAR IMPUESTOS DESDE EL MENU
    public void cobrarImpuestos() {
        System.out.println("Elige la ciudad cuyos residentes pagarán impuestos");
        Ciudad ciudadElegida = elegirCiudad();
        gestionMundo.cobrarImpuestos(personajeDAO.getPersonajes(), ciudadElegida);
    }

    //FUNCION PARA ELEGIR QUE HABILIDADES QUEREMOS EQUIPARNOS EN EL COMBATE
    public void equiparHabilidades() {
        Personaje personajeElegido = elegirPersonaje();

        System.out.println(" Habilidades de: " + personajeElegido.getNombre().toUpperCase());
        System.out.println("------------------------------");
        System.out.println("Introduce el id de la habilidad que quieras equipar mostrado a la izquierda de la misma");

        for (Habilidad h : personajeElegido.getHabilidades().keySet()) {
            String estado;
            if (personajeElegido.getHabilidades().get(h)) {
                estado = "EQUIPADA";
            } else {
                estado = "NO EQUIPADA";
            }
            System.out.println(h.getId() + ". " + h.getNombre() + " " + estado);
        }

        Habilidad habilidadElegida = null;
        while (habilidadElegida == null) {
            System.out.print("Elige la habilidad que quieres equipar/desequipar: ");
            int eleccion = sc.nextInt();

            for (Habilidad hab : personajeElegido.getHabilidades().keySet()) {
                if (hab.getId().equals(eleccion)) {
                    habilidadElegida = hab;
                    break;
                }
            }
            if (habilidadElegida == null) {
                System.out.println("Habilidad no válida, elige una id correcta.");
            }
        }

        boolean estaEquipada = personajeElegido.getHabilidades().get(habilidadElegida);

        if (!estaEquipada) {
            int equipadas = 0;
            for (boolean b : personajeElegido.getHabilidades().values()) {
                if (b) {
                    equipadas++;
                }
            }
            try {
                if (equipadas >= 3) {
                    throw new LimiteHabilidadesException("Límite de habilidades alcanzado: " + personajeElegido.getNombre() + " ya tiene 3 habilidades equipadas.");
                }
                personajeDAO.equiparHabilidad(personajeElegido, habilidadElegida, true);
                System.out.println(habilidadElegida.getNombre() + " ha sido equipada correctamente.");
            } catch (LimiteHabilidadesException e) {
                Log.error("Intento de equipar fallido: LimiteHabilidadesException - " + e.getMessage());
                System.out.println(e.getMessage());
                System.out.println("¿Quieres desequipar alguna? 1. Si  2. No");
                int respuesta = sc.nextInt();
                if (respuesta == 1) {
                    desequiparHabilidad(personajeElegido);
                }
            }
        }
    }

    //FUNCION PARA DESEQUIPAR UNA HABILIDAD
    public void desequiparHabilidad(Personaje personajeElegido) {
        Habilidad habilidadADesequipar = null;
        while (habilidadADesequipar == null) {
            System.out.println("Elige la habilidad que quieres desequipar: ");
            for (Habilidad h : personajeElegido.getHabilidades().keySet()) {
                if (personajeElegido.getHabilidades().get(h)) {
                    System.out.println(h.getId() + ". " + h.getNombre());
                }
            }
            int eleccionDesequipar = sc.nextInt();

            for (Habilidad h : personajeElegido.getHabilidades().keySet()) {
                if (h.getId().equals(eleccionDesequipar) && personajeElegido.getHabilidades().get(h)) {
                    habilidadADesequipar = h;
                    break;
                }
            }
            if (habilidadADesequipar == null) {
                System.out.println("Habilidad no válida, elige una id correcta.");
            }
        }
        personajeDAO.equiparHabilidad(personajeElegido, habilidadADesequipar, false);
        System.out.println(habilidadADesequipar.getNombre() + " ha sido desequipada correctamente.");
    }

    //Funcion para iniciar el menu del combate
    public void combate() {
        System.out.println("Elige el primer personaje: ");
        Personaje p1 = elegirPersonaje();
        System.out.println("Elige el segundo personaje: ");
        Personaje p2 = elegirPersonaje();

        MotorCombate motorCombate = new MotorCombate(personajeDAO);
        motorCombate.iniciarCombate(p1, p2);
    }

    public void estadisticas() {
        Estadisticas estadisticas = new Estadisticas();

        System.out.println("\n==============================");
        System.out.println("     CENTRO DE ESTADÍSTICAS");
        System.out.println("==============================");
        System.out.println("1. Top 3 jugadores más ricos");
        System.out.println("2. Censo de clases");
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                estadisticas.top3Ricos(personajeDAO.getPersonajes());
                break;
            case 2:
                estadisticas.censoPorClase(personajeDAO.getPersonajes());
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
