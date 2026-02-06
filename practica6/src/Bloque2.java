import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bloque2 {
    private ArrayList<String> guerreros;
    private ArrayList<String> magos;
    private Map<String, ArrayList<String>> gremios;

    public Bloque2(){
        this.guerreros= new ArrayList<>();
        this.magos= new ArrayList<>();
        rellenaArraysGremios();
        this.gremios= new HashMap<>();
        rellenaGremios();

    }
    //-----------------------------------------------
    //Ejercicio 7 --> El Repositorio de Gremios
    //-----------------------------------------------
    //Función que rellena los ArrayList guerreros y magos
    public void rellenaArraysGremios(){
        this.guerreros.add("Tarok");
        this.guerreros.add("Bjorn");
        this.guerreros.add("Ragnar");
        this.magos.add("Arkanis de las Runas");
        this.magos.add("Nytheris Robaalmas");
        this.magos.add("Cryon Corazón de Hielo");
    }

    //Funcion que rellena el HashMap con los 2 gremios
    public void rellenaGremios(){
        this.gremios.put("Guerreros", guerreros);
        this.gremios.put("Magos", magos);
    }

    //Funcion que muestra los miembros de un gremio concreto
    public void muestraMiembros(String gremio){
        if (gremios.containsKey(gremio)){
            for (String miembro:gremios.get(gremio)){
                System.out.println(miembro);
            }
        }
    }

    //-----------------------------------------------
    //Ejercicio 8 --> El sistema de Loot (Botín)
    //-----------------------------------------------
}
