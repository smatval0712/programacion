package rpg.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    private static final String RUTA_LOG = "/home/checo/IdeaProjects/programacion/practica8/src/rpg/utils/info.log";
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    // Metodo privado que escribe una linea en el fichero
    private static void escribir(String nivel, String mensaje) {
        String linea = "[" + LocalDateTime.now().format(FORMATO) + "] [" + nivel + "] " + mensaje;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_LOG, true))) {
            bw.write(linea);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el log: " + e.getMessage());
        }
    }

    public static void info(String mensaje) {
        escribir("INFO", mensaje);
    }

    public static void error(String mensaje) {
        escribir("ERROR", mensaje);
    }
}