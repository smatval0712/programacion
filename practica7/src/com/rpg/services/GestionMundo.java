package com.rpg.services;

import com.rpg.handler.DatoInvalidoException;
import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestionMundo {
    private List<Ciudad> listaCiudades;
    private List<Personaje> personajes;
    private List<Item> listaItem;
    private HashMap<String, Item> mapItems;

    public GestionMundo(){
        this.personajes = new ArrayList<>();
        this.listaCiudades=new ArrayList<>();
        this.listaItem=new ArrayList<>();
        this.mapItems=new HashMap<>();
    }

    public void cargarTodo(){
        TxtHelper txt = new TxtHelper();
        this.listaCiudades= txt.leerTxt();

        JsonHelper jhelper =new JsonHelper();
        this.personajes = jhelper.leerJSON("practica7\\ficheros\\personajes.json", Personaje.class);

        this.listaItem=jhelper.leerJSON("practica7\\ficheros\\Items.json", Item.class);

        for(Item item : listaItem){
            this.mapItems.put(item.getId(), item);
        }
    }

    public void crearPersonaje(String nombre, String raza, Integer nivel, List<String> idItems) throws DatoInvalidoException {
        for (String id : idItems) {
            if (!this.mapItems.containsKey(id)) {
                throw new DatoInvalidoException("El item no existe");
            }
        }
        Personaje personaje=new Personaje(nombre,raza,nivel,idItems);
        this.personajes.add(personaje);
    }

    public void guardarCambios

}
