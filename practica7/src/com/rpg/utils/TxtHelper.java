package com.rpg.utils;

import com.rpg.model.Ciudad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    public TxtHelper() {
    }

    public void leerTxt(){
        try{
            List<String> ciudades = Files.readAllLines(Paths.get("practica7\\ficheros\\ciudades.txt"));
            List<Ciudad> listaCiudades = new ArrayList<>();
            for(String linea:ciudades){
                System.out.println(linea);
                String[] s = linea.split(";");
                Ciudad c=new Ciudad(
                        s[0],
                        Integer.parseInt(s[1]),
                        s[2],
                        Integer.parseInt(s[3])
                );
                listaCiudades.add(c);
            }
            for (Ciudad c : listaCiudades){
                System.out.println(c.getNombre());
            }
        } catch (IOException e){
            System.out.println("No se ha podido abrir el fichero");
        }
    }

}
