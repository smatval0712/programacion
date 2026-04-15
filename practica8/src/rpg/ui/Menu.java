package rpg.ui;

import rpg.dao.PersonajeDAO;
import rpg.logic.GestionMundo;
import rpg.model.*;

import java.util.Scanner;

public class Menu {
    private PersonajeDAO personajeDAO;
    private GestionMundo gestionMundo;

    public Menu(){
        this.personajeDAO = new PersonajeDAO();
        this.gestionMundo=new GestionMundo(this.personajeDAO);
    }

    Scanner sc =new Scanner(System.in);
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
        personajeDAO.getPersonajes().add(new Personaje(idGenerado, nombre, nivel, oro, vidaMaxima, razaElegida, claseElegida, ciudadElegida));
    }

    //Funcion para cambiar la ciudad de un personaje, llama a la funcion que la cambia tambien en la base de datos
    public void viajarDeCiudad(){
        Personaje personajeElegido = elegirPersonaje();
        Ciudad ciudadElegida = null;

        //Eleccion de ciudad
        while (ciudadElegida==null){
            System.out.println("Selecciona la ciudad a la que quieres asignar el personaje: ");
            for (Ciudad c: personajeDAO.getCiudadDAO().getCiudades()){
                System.out.println(c.getId()+ " -> " +c.getNombre());
            }
            Integer IdCiudadElegida= sc.nextInt();

            for (Ciudad c : personajeDAO.getCiudadDAO().getCiudades()){
                if (c.getId().equals(IdCiudadElegida)){
                    ciudadElegida=c;
                    break;
                }
            }
            if (ciudadElegida==null){
                System.out.println("Esa ciudad no está en la lista, elige una id válida.");
            }
        }

        if (personajeElegido.getNivel()>=ciudadElegida.getNivel_minimo_acceso()){
            personajeDAO.cambiarCiudadPersonaje(personajeElegido,ciudadElegida);
            System.out.println("Se ha cambiado la ciudad del Personaje");
        }
        else{
            System.out.println("El nivel del personaje es menor al requerido para entrar en esa ciudad");
        }
    }

    //Funcion para elegir personaje
    public Personaje elegirPersonaje(){
        Personaje personajeElegido = null;
        //Eleccion de personaje
        while (personajeElegido==null){
            System.out.println("Selecciona el personaje:  ");
            for (Personaje p: personajeDAO.getPersonajes()){
                System.out.println(p.getId()+ " -> " +p.getNombre());
            }
            Integer IdPersonajeElegido= sc.nextInt();

            for (Personaje p: personajeDAO.getPersonajes()){
                if (p.getId().equals(IdPersonajeElegido)){
                    personajeElegido=p;
                    break;
                }
            }
            if (personajeElegido == null){
                System.out.println("Ese personaje no está en la lista, elige una id válida.");
            }
        }
        return personajeElegido;
    }

    //Funcion que muestra los items y devuelve el seleccionado por id
    public Item elegirItem(){
        Item itemElegido=null;
        while (itemElegido==null){
            System.out.println("Selecciona el item: ");
            for (Item i : personajeDAO.getItemsDAO().getItems()){
                System.out.println(i.getId()+ " -> " +i.getNombre());
            }
            Integer idItemElegido= sc.nextInt();

            for (Item i : personajeDAO.getItemsDAO().getItems()){
                if (i.getId().equals(idItemElegido)){
                    itemElegido=i;
                    break;
                }
            }
            if (itemElegido == null){
                System.out.println("Ese Item no está en la lista, elige una id válida.");
            }
        }
        return itemElegido;

    }

   //Funcion del menú comprarItems
    public void comprarItems(Personaje p){
        Item itemElegido=elegirItem();
        gestionMundo.comprarItems(p,itemElegido);
    }

    //Funcion del menu
    public void menu(){

    }
}
