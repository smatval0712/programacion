//Programa Java que llene un array con 10 números
// enteros que se leen por teclado.
// A continuación calcula y muestra la media de los
// valores positivos y la de los valores negativos del array.

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array de 10 numeros leidos por teclado
        int [] a= new int [10];
        for(int i=0; i< a.length;i++) {
            System.out.println("Introduce un número; ");
            a[i] = sc.nextInt();
        }
        //variables creadas positivos y negativos y cantidad de numeros positivos y cantidad de numeros negativos
        int totalpos=0;
        int pos=0;
        int neg=0;
        int totalneg=0;
        //bucle sumando numeros positivos y negativos por separados y calculando cuantos positivos y cuantos negativos hay
        for (int i =0; i<a.length;i++) {
            if(a[i]>=0){
                pos=pos+a[i];
                totalpos=totalpos+1;
            }
            else{
                neg=neg+a[i];
                totalneg=totalneg+1;
            }
        }
        //variables que calculan la media de los positivos y negativos y muestra en pantalla
        double mediapos= (double) pos / (double) totalpos;
        double medianeg= (double) neg / (double) totalneg;
        System.out.println("La media de los números positivos es; " +mediapos);
        System.out.println("La media de los números negativos es; " +medianeg);

    }
}
