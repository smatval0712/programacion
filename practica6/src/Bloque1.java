import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Bloque1 {

    ArrayList<String> resgistroCombate;
    Set<String> nombreVillanos;
    public Bloque1() {
        this.resgistroCombate=new ArrayList<>();
        this.resgistroCombate.add("Orco derrotado");
        this.resgistroCombate.add("Poción usada");
        this.resgistroCombate.add("Hechizo aplicado");
        this.resgistroCombate.add("Golpe crítico asestado");
        this.resgistroCombate.add("Ultimate cargada");
        this.nombreVillanos=new HashSet<>();

    }

    //Ejercicio 1 --> Registro de muertes

    //Función que rellena el
    public void mostrarTercerEvento(){
        System.out.println(resgistroCombate.get(2));
    }


}
