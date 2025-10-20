//Crea un programa en Java que:
//Pida al usuario por teclado 10 números enteros y los guarde en un array.
//Recorra el array para encontrar:
//El valor máximo y la posición en la que aparece.
//El valor mínimo y la posición en la que aparece.

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array de 10 numeros leidos por teclado
        int [] a= new int [10];
        for(int i=0; i< a.length;i++) {
            System.out.println("Introduce un número: ");
            a[i] = sc.nextInt();
        }
        //Variables para saber cual es el numero maximo y cual es el minimo y cual es su posicion
        int max = a[0];
        int posmax= a[0];
        int min = a[0];
        int posmin = a[0];
        //Bucle recorriendo el array y comprobando cual es el minimo y cual el maximo y en que posicion estan
        for (int i=0;i< a.length; i++) {
            if (a[i] > max) {
                max=a[i];
                posmax = i;
            }
            else {
                min=a[i];
                posmin= i;
            }

        }
        System.out.println("El valor máximo es: " +max +" que está en la posición: "+posmax);
        System.out.println("El valor mínimo es: " +min +" que está en la posición: "+ posmin);
    }
}
