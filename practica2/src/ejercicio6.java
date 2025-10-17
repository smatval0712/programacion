import java.util.Scanner;

//Programa Java que guarda en un array 10 números enteros que se leen por teclado.
//A continuación se recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros.
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array de 10 enteros leídos por teclado
        int [] a= new int[10];
        for (int i = 0; i < a.length; i++) {
            System.out.println("Introduce un número: ");
            a[i]= sc.nextInt();
        }
        //variables creadas para cada tipo de numero (positivo, negativo y cero)
        int pos=0;
        int neg=0;
        int cero=0;
        //bucle recorriendo el array y comprobando si son negativos, positivos o cero.
        for (int i = 0; i< a.length; i++) {
            if (a[i] >0){
                pos=pos+1;
            }
            else if (a[i] <0){
                neg=neg+1;
            }
            else {
                cero=cero+1;
            }
        }
        //Muestra por pantalla cuántos de cada tipo hay
        System.out.println("Hay "+pos +" números positivos, "+neg +" negativos y " +cero +" ceros");
    }
}
