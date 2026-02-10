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
    //ejercicio9//
    private Map<String,Integer> estadisticasConan;
    private Map<String,Integer> estadisticasZorin;
    private Map<String, Map<String, Integer>> jugadores;

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
        //ejercicio9//
        this.estadisticasZorin=new HashMap<>();
        rellenaZorin();
        this.estadisticasConan=new HashMap<>();
        rellenaConan();
        this.jugadores=new HashMap<>();
        rellenaJugadores();


    }
    //-----------------------------------------------
    //Ejercicio 7 --> El Repositorio de Gremios
    //-----------------------------------------------
    //Función que rellena los ArrayList guerreros y magos
    public void rellenaArraysGremios(){
        this.guerreros.add("Tarok");
        this.guerreros.add("Judas");
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
    public void pruebaNoRepeticion(){
        this.objetosTrasgo.add("Espada Oxidada");
        for (String objeto:this.objetosTrasgo){
            System.out.println(objeto);
        }
    }

    //-----------------------------------------------
    //Ejercicio 9 --> Rastreador de Estadísticas Complejas
    //-----------------------------------------------
    //Funcion para rellenar HasMap de estadisticasZorin
    public void rellenaZorin(){
        this.estadisticasZorin.put("Fuerza",18);
        this.estadisticasZorin.put("Destreza",12);
        this.estadisticasZorin.put("Inteligencia",20);
        this.estadisticasZorin.put("Vida",100);
    }
    //Funcion para rellenar HasMap de estadisticasConan
    public void rellenaConan(){
        this.estadisticasConan.put("Fuerza",16);
        this.estadisticasConan.put("Destreza",15);
        this.estadisticasConan.put("Inteligencia",18);
        this.estadisticasConan.put("Vida",120);
    }
    //Funcion para rellenar HasMap de jugadores
    public void rellenaJugadores(){
        this.jugadores.put("Conan",estadisticasConan);
        this.jugadores.put("Zorin",estadisticasZorin);
    }
    //Funcion para sumarle +2 a la fuerza de Conan
    public void sumaVidaConan(){
        Map<String, Integer> nuevasEstadisticas = jugadores.get("Conan");
        int fuerzaActual= nuevasEstadisticas.get("Fuerza");
        nuevasEstadisticas.put("Fuerza", fuerzaActual+2);
        this.jugadores.put("Conan", nuevasEstadisticas);
        System.out.println("La nueva fuerza de Conan es: "+ nuevasEstadisticas.get("Fuerza"));
        System.out.println(this.jugadores.get("Conan"));
    }
    //-----------------------------------------------
    //Ejercicio 10 --> El buscador de traidores
    //-----------------------------------------------
    public void buscaJudas(){
        for (Map.Entry<String,ArrayList<String>> traidor:gremios.entrySet()){
            //este if devuelve un boolean si lo encuentra y lo elimina
            if (traidor.getValue().remove("Judas")){
                System.out.println("Traidor encontrado en el gremio: "+traidor.getKey());
                return;
            }
        }
        System.out.println("Judas no está en ningún gremio");
    }

}

