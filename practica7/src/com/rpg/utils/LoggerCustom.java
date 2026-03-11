package com.rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class LoggerCustom {
    //Funcion para escribir en errores.log
    public void escribirLog(String mensaje){
        String path= "practica7\\ficheros\\errores.log";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))){
            writer.write("[" + LocalDateTime.now() + "] " + mensaje);
            writer.newLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
