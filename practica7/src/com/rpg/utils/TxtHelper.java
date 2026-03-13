package com.rpg.utils;

import com.rpg.handler.FormatoInvalidoException;
import com.rpg.model.Ciudad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtHelper {
    private LoggerCustom loggerCustom;
    public TxtHelper() {
        this.loggerCustom=new LoggerCustom();
    }

    //Leer archivos txt
    public List<Ciudad> leerTxt() throws FormatoInvalidoException {
        try{
            List<String> ciudades = Files.readAllLines(Paths.get("practica7/ficheros/ciudades.txt"));
            List<Ciudad> listaCiudades = new ArrayList<>();
            for(String linea:ciudades){
                String[] s = linea.split(";");
                Ciudad c=new Ciudad(
                        s[0],
                        Integer.parseInt(s[1]),
                        s[2],
                        Integer.parseInt(s[3])
                );
                listaCiudades.add(c);
            }
            return listaCiudades;

        } catch (Exception e){
            loggerCustom.escribirLog("ERROR: al leer el fichero, "+e.getMessage());
            throw new FormatoInvalidoException("ERROR: al leer el fichero, "+e.getMessage());
        }
    }
}
