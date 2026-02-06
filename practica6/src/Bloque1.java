import java.util.*;

public class Bloque1 {

    private ArrayList<String> registroCombate;
    private Set<String> nombreVillanos;
    private Map<String,Integer> aventureros;
    private Map<String,Integer> hechizos;

    public Bloque1() {
        this.registroCombate=new ArrayList<>();
        rellenaArray();
        this.nombreVillanos=new HashSet<>();
        rellenaHashSet();
        this.aventureros= new HashMap<>();
        rellenaOro();
        this.hechizos=new HashMap<>();
        rellenaHechizos();

    }
    //-----------------------------------------------
    //Ejercicio 1 --> Registro de muertes
    //-----------------------------------------------
    //Función que rellena el ArrayList
    public void rellenaArray(){
        this.registroCombate.add("Orco derrotado");
        this.registroCombate.add("Poción usada");
        this.registroCombate.add("Hechizo aplicado");
        this.registroCombate.add("Golpe crítico asestado");
        this.registroCombate.add("Ultimate cargada");
    }
    public void mostrarTercerEvento(){
        System.out.println(registroCombate.get(2));
    }
    //-----------------------------------------------
    //Ejercicio 2 --> El Censo Único
    //-----------------------------------------------
    //Funcion que rellena el hashset
    public void rellenaHashSet(){
        this.nombreVillanos.add("Morgoth");
        this.nombreVillanos.add("Sauron");
        this.nombreVillanos.add("Morgoth");
        this.nombreVillanos.add("Beltharion");
        this.nombreVillanos.add("Nerethis");
        this.nombreVillanos.add("Vorun");
    }

    //Funcion que imprime el tamaño del hashset
    public void tamanioHashSet(){
        System.out.println(nombreVillanos.size());
    }
    //-----------------------------------------------
    //Ejercicio 3 --> Bolsa de Oro
    //-----------------------------------------------
    //Funcion que rellena el HashMap
    public void rellenaOro(){
        this.aventureros.put("Santiago Abascal", 50);
        this.aventureros.put("Perro Sanxe", 50000);
        this.aventureros.put("Josemi", 200);
    }

    //Función para mostrar el oro de un aventurero con su nombre
    public void mostrarAventurero(){
        this.aventureros.get("Josemi");
    }
    //-----------------------------------------------
    //Ejercicio 4 --> Limpieza del Calabozo
    //-----------------------------------------------
    //Función que elimina el evento más antiguo y añade uno nuevo
    public void eliminaAntiguoAniadeNuevo(){
        this.registroCombate.remove(0);
        this.registroCombate.add("Dragón avistado");
    }

    //-----------------------------------------------
    //Ejercicio 5 --> Mercado de Hechizos
    //-----------------------------------------------
    //Funcion que rellena el HashMap de hechizos
    public void rellenaHechizos(){
        this.hechizos.put("Chispa Ígnea", 35);
        this.hechizos.put("Pacto de Sangre", 60);
        this.hechizos.put("Luz Sanadora", 30);
        this.hechizos.put("Dardo Glacial", 55);
        this.hechizos.put("Cadena de rayos", 50);
    }
    //Funcion que muestra los hechizos de mas de 50 de mana
    public void hechizosCostosos(){
        for (String key : hechizos.keySet()){
            int mana = hechizos.get(key);

            if(mana>50){
                System.out.println("- Hechizo -> " +key +" - Maná -> " +mana);
            }
        }
    }

    //-----------------------------------------------
    //Ejercicio 6 --> Expulsión del reino
    //-----------------------------------------------
    //Funcion que comprueba si Sauron esta en mi hashset de villanos y lo elimina
    public void derrotaSauron(){
        for (String villano : this.nombreVillanos){
            if (nombreVillanos.contains(villano)){
                nombreVillanos.remove(villano);
            }
        }
    }

}
