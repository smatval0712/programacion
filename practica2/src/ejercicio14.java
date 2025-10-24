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
            String nombre = sc.nextLine();
            if (nombre.equals("fin")) {
                break;
            } else {
                lista.add(nombre);
            }
        }
        System.out.println("Lista terminada");
        System.out.println("Introduce un nombre para comprobar si está en la lista y en qué posición: ");
        String busqueda= sc.nextLine();
        int encontrado=0;
        int posicion=0;
        for (int i=0; i< lista.size();i++) {
            if (busqueda.equals(lista.get(i))) {
                encontrado++;
                posicion= i;
                break;
            }
        }
        if (encontrado>0){
            System.out.println("El nombre sí está en la lista, en la posición: " +posicion);
        }
        else {
            System.out.println("El nombre no está en la lista");
        }
    }
}