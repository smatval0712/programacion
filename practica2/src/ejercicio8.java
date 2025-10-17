//Programa Java para leer la altura de N personas
// y calcular la altura media. Calcular cuántas personas
// tienen una altura superior a la media y cuántas tienen una
// altura inferior a la media.
//El valor de N se pide por teclado y debe ser entero positivo.


import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        //Crea un array que el tamaño sea pedido por teclado
        Scanner sc = new Scanner(System.in);
        //Creamos la variable n que pedira un numero por teclado
        System.out.println("Indica a cuántas personas se le tomará medidas:");
        int n = sc.nextInt();
        //Creamos el array y le indicamos que el tamaño será la variable n que contiene un numero que hemos metido por teclado anteriormente
        int[] a = new int[n];
        //Creamos la variable t para saber la altura total de las personas
        int t = 0;
        //Bucle pidiendo las medidas de las personas y sumándolas
        for (int i = 0; i < a.length; i++) {
            System.out.println("Introduce la altura en cm: ");
            a[i] = sc.nextInt();
            t = t + a[i];
        }
        //Calculamos la variable media que será el total de las alturas en cm dividido entre el numero de personas
        double media = (double) t / (double) a.length;
        System.out.println("La altura media es: " + media);
        //Creamos dos variables para saber cuántas personas están por encima y cuantas por debajo de la media
        int sup=0;
        int inf=0;
        //bucle comprobando cuantas estan por encima y cuantas estan por debajo
        for (int i=0; i<a.length;i++) {
            if (a[i]>media) {
                sup=sup+1;
            }
            else {
                inf=inf+1;
            }
        }
        System.out.println("Hay "+sup +" personas por encima de la media");
        System.out.println("Hay "+inf +" personas por debajo de la media");
    }
}
