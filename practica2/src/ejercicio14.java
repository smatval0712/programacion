//Crea un programa que:
//Cree una lista de Strings (ArrayList<String>).
//Pida al usuario nombres por teclado hasta que introduzca la palabra "fin".
//Luego pida un nombre a buscar y diga si está en la lista o no,
// mostrando también en qué posición se encuentra si existe.


import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creamos el array variable String
        ArrayList<String> lista = new ArrayList<>();
        //Con un bucle while pedimos nombres por teclado y lo añadimos al array, a no ser que pongamos la palabra fin que significara el final del bucle
        while (true) {
            System.out.println("Introduce nombres, cuando quieras parar introduce fin: ");
            String p = sc.nextLine();
            if (p.equals("fin")) {
                break;
            } else {
                lista.add(p);
            }
        }
        //Pedimos un nombre por teclado para buscarlo en el array y lo almacenamos en la variable busqueda
        System.out.println("Introduce un nombre a buscar: ");
        String busqueda = sc.nextLine();
        //Con un if con el valor array (lista).contains que es un atributo booleano que compara y devuelve verdadero falso
        //si lo que queremos buscar está en el array
        if(lista.contains(busqueda)){
            //creamos una variable que se llama pos que guardara la posicion del array mediante el atributo .indexOf que devuelve
            // la posicion en la que se encuentra o -1 si no esta en el array
            int pos = lista.indexOf(busqueda);
            //Imprimimos el nombre y la posicion o no esta en la lista si no se encuentra.
            System.out.println("El nombre buscado está en la lista, en la posición "+pos);
        }
        else {
            System.out.println("El nombre buscado no está en la lista");
        }
    }
}