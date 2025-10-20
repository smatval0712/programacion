//Crea un array de números donde le indicamos
//por teclado el tamaño del array,
//rellenaremos el array con números aleatorios entre 0 y 9, al final muestra por pantalla el valor de cada posición y la suma de todos los valores.

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        //Crea un array que el tamaño sea pedido por teclado
        Scanner sc = new Scanner(System.in);
        //Creamos la variable n para que pida un número por teclado
        System.out.println("Establece el número de posiciones del array:");
        int n = sc.nextInt();
        //Creamos el array a y establecemos que la n (numero que hemos metido por teclado) sea el tamaño del array
        int [] a=new int [n];
        //Bucle añadiendo números aleatorios a las posiciones del array
        for (int i=0;i< a.length;i++){
            a[i] = (int) (Math.random()*9);
        }
        //Bucle recorriendo el array mostrando las posiciones
        for (int i=0; i< a.length; i++) {
            System.out.println("Posición: "+i +" Número: " +a[i]);
            }
        //Bucle de suma de las posiciones
        int sum=0;
        for (int i=0; i < a.length; i++) {
            sum=sum+a[i];
        }
        System.out.println("El resultado de la suma de ellos es: "+sum);
    }
}
