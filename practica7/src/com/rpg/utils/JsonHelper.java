package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.rpg.handler.DatoInvalidoException;
import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RPGDataException;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    private LoggerCustom loggerCustom;
    public JsonHelper(){
        this.loggerCustom=new LoggerCustom();
    }

    //Leer json
    public <T>List<T> leerJSON (String path, Class<T> clazz) throws FormatoInvalidoException {
        try (Reader reader = new FileReader(path)) {
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            Gson gson = new Gson();
            List<T> lista = gson.fromJson(reader, typeOfT);
            return lista;
        } catch (Exception e) {
            loggerCustom.escribirLog("ERROR: Error al leer el fichero, "+e.getMessage());
            throw new FormatoInvalidoException("ERROR: Error al leer el fichero, "+e.getMessage());
        }
    }

    //Escribir en json
    public <T> void escribirJson(String path, List<T> lista) throws FormatoInvalidoException {
        try (java.io.Writer writer = new java.io.FileWriter(path)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(lista, writer);
        } catch (Exception e) {
            loggerCustom.escribirLog("ERROR: Error al escribir el fichero, "+e.getMessage());
            throw new FormatoInvalidoException("ERROR: Error al escribir el fichero, "+e.getMessage());
        }
    }
}
