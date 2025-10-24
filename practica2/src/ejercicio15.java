//Crea un programa que:
//Cree una lista de enteros (ArrayList<Integer>).
//Pida al usuario 10 números enteros y los añada a la lista.
//Elimine los valores duplicados manteniendo solo el primero que apareció.
//Ordene la lista de menor a mayor y la muestre por pantalla.

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio15 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        //Creamos el array con arraylist
        ArrayList<Integer> lista = new ArrayList<>();
        //bucle para pedir numeros y añadirlos al array
        for (int i =0;i <=9; i++){
            System.out.println("Introduce un número ");
            int n= s.nextInt();
            lista.add(n);
        }

        //El primer bucle con i recorre cada elemento de la lista
        //El segundo bucle con j compara el elemento i con todos los elementos que vienen después de él.
        //Si encuentra que lista.get(i) es igual a lista.get(j), elimina el elemento en la posición j y decrementa j
        //para no saltarse el siguiente elemento debido al desplazamiento de índices tras la eliminación.
        for (int i = 0; i < lista.size(); i++) {
            for (int j = i+1; j < lista.size(); j++) {
                if (lista.get(i).equals(lista.get(j)) && i != j){
                    lista.remove(j);
                    j--;
                }
            }
        }
        //Muestra el array lista
        System.out.println(lista);

    }


}
