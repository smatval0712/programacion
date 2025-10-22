//Crea un programa que:
//Cree una lista de enteros (ArrayList<Integer>).
//Pida números por teclado hasta que el usuario introduzca
// un número negativo (ese no se añade).
//Muestre por pantalla todos los números de la lista y
// la suma total de los mismos.

import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Establecemos un array de tamaño variable llamado lista
        ArrayList<Integer> lista = new ArrayList<>();
        //Bucle while con una variable dentro creada llamada n que será cada número que metemos por teclado
        while (true){
            System.out.println("Introduce números, si introduces uno negativo se termina el programa: ");
            int n=sc.nextInt();
            //si con la condición de que si el número que metemos por teclado (variable n) es mayor a 0 lo añada al array llamado lista
            if (n>0){
                lista.add(n);
            }
            //en el caso de que no sea cierto lo que tenemos en el si, indicamos break que hará que finalize el bucle
            else{
                break;
            }
        //Creamos un bucle foreach en el que establecemos que buscamos valores int y lo guardamos en la variable del bucle n, y lo buscamos en el array lista
        }
        for (int n : lista){
            //Mostramos por pantalla cada número que encontramos en la lista
            System.out.println("Número " +n);
        }
        //Creamos la variable suma para ir guardando la suma de todos los números del array
        int suma=0;
        //Creamos un bucle foreach de la misma forma que antes
        for (int n : lista){
            //le indicamos en el bucle que le vaya sumando a la variable suma cada número del array y vaya guardando el resultado en la misma variable
            //suma +=n es lo mismo que suma=suma+n
            suma+=n;
        }
        //Mostramos la suma de todos los números por pantalla
        System.out.println("La suma total de los números introducidos es: "+suma);
    }
}


