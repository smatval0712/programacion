import com.rpg.handler.FormatoInvalidoException;
import com.rpg.handler.RPGDataException;
import com.rpg.model.Item;
import com.rpg.model.Personaje;
import com.rpg.utils.JsonHelper;
import com.rpg.utils.TxtHelper;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static void main(String[] args){
        JsonHelper j= new JsonHelper();

        for(Personaje p : j.leerJSON("practica7\\ficheros\\personajes.json", Personaje.class)){
            System.out.println(p.getNombre());
        }
    }
}
