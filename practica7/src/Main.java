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

        for(Item i : j.leerJSON("practica7\\ficheros\\Items.json", Item.class)){
            System.out.println(i.getNombre());
        }
    }
}
