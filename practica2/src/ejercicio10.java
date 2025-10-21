//Crea un programa que muestre por pantalla la nota de un
// estudiante, de entre una lista de estudiantes con sus
// respectivas notas. El nombre del estudiante lo
// introduce el usuario por teclado (usa la clase Scanner).
// Utiliza un array para los nombres de los alumnos y otro para las
//notas. ¿Serías capaz de hacerlo con un array Bidimensional?


import java.util.Scanner;

public class ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alumnos = {"Sergio Mateos", "Álvaro Aliño", "Marco Paloma", "Cristian Luque", "Sergio Duque", "álvaro Benítez"};
        double[] notas = {10, 9.6, 6.7, 4.2, 8.2, 1.2};

        System.out.println("Introduzca un nombre para saber su nota: ");
        String nombre = sc.nextLine();
        double e=0;
        for (int i=0; i< alumnos.length;i++)
            if (nombre .equals(alumnos[i])) {
                e = notas[i];
            }
        System.out.println("La nota del alumno es: "+e);
    }
}