package com.rpg.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    public JsonHelper(){
    }

    public <T>List<T> leerJSON (String path, Class<T> clazz) {
        try (Reader reader = new FileReader(path)) {
            Type typeOfT = TypeToken.getParameterized(List.class, clazz).getType();
            Gson gson = new Gson();
            List<T> lista = gson.fromJson(reader, typeOfT);
            return lista;
        } catch (Exception e) {
            System.out.println("Error al leer JSON: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
