import java.util.*;

public class Bloque2 {
    //ejercicio7//
    private ArrayList<String> guerreros;
    private ArrayList<String> magos;
    private Map<String, ArrayList<String>> gremios;
    //ejercicio8//
    private Set<String> objetosArania;
    private Set<String> objetosTrasgo;
    private Map<String, Set<String>> loot;

    public Bloque2(){
        //ejercicio7//
        this.guerreros= new ArrayList<>();
        this.magos= new ArrayList<>();
        rellenaArraysGremios();
        this.gremios= new HashMap<>();
        rellenaGremios();
        //ejercicio8//
        this.objetosArania=new HashSet<>();
        rellenaObjetosArania();
        this.objetosTrasgo=new HashSet<>();
        rellenaObjetosTrasgo();
        this.loot=new HashMap<>();
        rellenaLoot();


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
    //Funcion que rellena el ArrayList de objetosArania
    public void rellenaObjetosArania() {
        this.objetosArania.add("Saco de veneno");
        this.objetosArania.add("Colmillo venenoso");
        this.objetosArania.add("Seda resistente");
        this.objetosArania.add("Ojo de araña");
    }

    //Funcion que rellena el ArrayList de objetosTrasgo
    public void rellenaObjetosTrasgo() {
        this.objetosTrasgo.add("Daga mellada");
        this.objetosTrasgo.add("Espada oxidada");
        this.objetosTrasgo.add("Seda resistente");
        this.objetosTrasgo.add("Bolsa de monedas robadas");
    }

    //Funcion que rellena el HasMap de loot
    public void rellenaLoot(){
        this.loot.put("Araña Gigante",objetosArania);
        this.loot.put("Trasgo", objetosTrasgo);
    }

    //Funcion para recorrer el HashMap
    public void recorreLoot(){
        for (String key: loot.keySet()){
            System.out.println(key +loot.get(key));
        }
    }
    //HACER PRUEBA PARA EL 8 CUANDO RELLENE EL DOCUMENTO


}
