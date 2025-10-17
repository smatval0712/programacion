import java.util.Scanner;

public class ejercicio1 {
    public static void main (String[] args){
        //Crea un array de 10 posiciones de números pedidos por teclado
        Scanner sc = new Scanner(System.in);
        int[] arrayInt = new int[10];
        for (int i=0;i<10;i++){
            System.out.println("Introduce el siguiente valor");
            arrayInt[i] = sc.nextInt();
        }
        //Muestra por consola el indice y el valor
        //indice -> valor
        for (int i=0; i< arrayInt.length; i++){
            System.out.println(i+"->"+arrayInt[i]);
        }
    }
}
