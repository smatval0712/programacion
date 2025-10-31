//Escribe un programa que solicite 20 números enteros.
// Estos números debemos de introducirlo en un array de 4 filas por 5 columnas.
// El programa mostrará las sumas parciales de filas y en las columnas el mayor número de la columna.
// La suma total debe aparecer en la esquina inferior derecha.

import java.util.Scanner;

public class ejercicio2_3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] abi=new int [4][5];
        System.out.println("Introduce números: ");
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi [i].length; j++) {
                abi[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < abi.length; i++) {
            int sumafila=0;
            for (int j = 0; j < abi [i].length; j++) {
                System.out.printf("%5d", abi[i][j]);
                System.out.printf("%5s", "|");
                sumafila+=abi[i][j];
            }
            System.out.printf("%5s", "Σ=");
            System.out.printf("%-5d |", sumafila);
            System.out.println();
        }
    }
}
