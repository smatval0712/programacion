package com.rpg.services;

import com.rpg.model.Ciudad;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GestionMundo {
    private List<Ciudad> listaCiudades;
    private List<Personaje> personajes;
    private List<Item> listaItem;

    public GestionMundo(){
        this.personajes = new ArrayList<>();
        this.listaCiudades=new ArrayList<>();
        this.listaItem=new ArrayList<>();
    }

    public void cargarTodo(){
        TxtHelper txt = new TxtHelper();
        this.listaCiudades= txt.leerTxt();

        JsonHelper jhelper =new JsonHelper();
        this.personajes = jhelper.leerJSON("practica7\\ficheros\\personajes.json", Personaje.class);
        this.listaItem=jhelper.leerJSON("practica7\\ficheros\\Items.json", Item.class);
    }

    public Personaje (String nombre, String raza, List<String> idItems){

    }
}
