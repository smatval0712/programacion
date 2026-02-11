import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bloque3 {
    //Ejercicio11
    private Map<String,Double> preciosItems;
    private Map<String, ArrayList<String>>ciudadesItems;
    public Bloque3(){
        //Ejercicio11
        this.preciosItems=new HashMap<>(Map.of(
                "Espada de hierro",50.2,
                "Espada oxidada",25.8,
                "Armadura de cuero",15.0,
                "Poción de vida", 25.0,
                "Poción de maná", 30.0,
                "Anillo mágico", 120.0,
                "Arco de cazador", 60.0
                ));
        this.ciudadesItems=new HashMap<>();
        rellenaCiudadesItems();
    }

    //-----------------------------------------------------------
    //Ejercicio 11 --> El sistema de Comercio y Precios Dinámicos
    //-----------------------------------------------------------
    //Funcion que rellena el HashMap de ciudadesItems
    public void rellenaCiudadesItems(){
        this.ciudadesItems.put("Fortaleza Roja", new ArrayList<>(List.of(
                "Espada de hierro",
                "Armadura de cuero",
                "Anillo mágico"
        )));
        this.ciudadesItems.put("Arcania", new ArrayList<>(List.of(
                "Arco de cazador",
                "Armadura de cuero",
                "Poción de vida"
        )));
        this.ciudadesItems.put("Torreblanca", new ArrayList<>(List.of(
                "Arco de cazador",
                "Espada oxidada",
                "Poción de maná",
                "Anillo mágico",
                "Armadura de cuero",
                "Poción de vida"
        )));
        }
    //Funcion que comprueba si la ciudad tiene mas de 5 items y le aplica un impuesto
    public void impuestoLujo(String ciudad){
        if (!ciudadesItems.containsKey(ciudad)){
            System.out.println("La ciudad no existe");
            return;
        }
        ArrayList<String> items= ciudadesItems.get(ciudad);
        if (items.size()>=5){
            for (String item:preciosItems.keySet()){
                preciosItems.put(item,preciosItems.get(item)*0.1+preciosItems.get(item));
            }
        }
    }

    public void recorrePreciosItems(){
        for (String item:preciosItems.keySet()){
            System.out.println(item +" "+preciosItems.get(item));
        }
    }

    //-----------------------------------------------------------
    //Ejercicio 12 --> Gestión de Árboles de Habilidades
    //-----------------------------------------------------------




}
