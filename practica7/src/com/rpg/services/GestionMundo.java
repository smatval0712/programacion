package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.handler.RecursoNoEncontradoException;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.LoggerCustom;
import com.rpg.utils.TxtHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionMundo {
    private List<Ciudad> listaCiudades;
    private List<Personaje> personajes;
    private List<Item> listaItem;
    private HashMap<String, Item> mapItems;
    private LoggerCustom loggerCustom;
    private TxtHelper txt;
    private JsonHelper jhelper;


    public GestionMundo() throws FormatoInvalidoException {
        this.personajes = new ArrayList<>();
        this.listaCiudades = new ArrayList<>();
        this.listaItem = new ArrayList<>();
        this.mapItems = new HashMap<>();
        this.loggerCustom = new LoggerCustom();
        this.txt = new TxtHelper();
        this.jhelper = new JsonHelper();
        cargarTodo();
    }

    //CargarTodo
    public void cargarTodo() throws FormatoInvalidoException {
        this.listaCiudades = txt.leerTxt();

        this.personajes = jhelper.leerJSON("practica7/ficheros/personajes.json", Personaje.class);

        this.listaItem = jhelper.leerJSON("practica7/ficheros/Items.json", Item.class);

        for (Item item : listaItem) {
            this.mapItems.put(item.getId(), item);
        }
        equipamientoInteligente(this.listaCiudades, this.personajes, this.listaItem);
    }

    //Crear personaje
    public void crearPersonaje(String nombre, String raza, Integer nivel, List<String> idItems, String ciudad) throws RPGDataException {
        for (String id : idItems) {

            if (nivel < 0) {
                loggerCustom.escribirLog("ERROR: El nivel introducido no es válido");
                throw new DatoInvalidoException("El nivel introducido no es válido");
            }

            if (!this.mapItems.containsKey(id)) {
                loggerCustom.escribirLog("ERROR: El item " + id + " no existe");
                throw new RecursoNoEncontradoException("El item " + id + " no existe");
            }
        }
        Personaje personaje = new Personaje(nombre, raza, nivel, idItems, ciudad);
        this.personajes.add(personaje);
        guardarCambios();
    }

    //Guardar cammbios llama a escribirJson
    public void guardarCambios() throws RPGDataException {
        jhelper.escribirJson("practica7/ficheros/personajes.json", this.personajes);
    }

    public void equipamientoInteligente(List<Ciudad> listaCiudades, List<Personaje> personajes, List<Item> listaItem) throws FormatoInvalidoException {
        for (Personaje personaje : personajes) {
            if (personaje.getRaza().equals("Enano")) {
                for (Ciudad c : listaCiudades) {
                    if (c.getNombre().equals(personaje.getCiudad()) && c.getClima().equals("Desertico")) {
                        loggerCustom.escribirLog("ERROR: Esta raza no puede estar en una ciudad con este clima");
                        throw new FormatoInvalidoException("ERROR: Esta raza no puede estar en una ciudad con este clima");
                    }
                }
            }
            List<String> idEquipo = personaje.getEquipo();
            boolean itemHielo = false;
            boolean ciudadVolcanica = false;
            for (String id : idEquipo) {
                for (Item item : listaItem) {
                    if (item.getId().equals(id) && item.getTipo().equals("HIELO")) {
                        itemHielo = true;
                    }
                }
                for (Ciudad ciudad : listaCiudades) {
                    if (ciudad.getNombre().equals(personaje.getCiudad()) && ciudad.getClima().equals("Volcanico")) {
                        ciudadVolcanica = true;
                    }
                }
            }
            if (itemHielo&&ciudadVolcanica){
                loggerCustom.escribirLog("ERROR: El personaje tiene un item que no puede estar en una ciudad con este clima");
                throw new FormatoInvalidoException("ERROR: El personaje tiene un item que no puede estar en una ciudad con este clima");
            }
        }
    }
}
