//En España cada persona está identificada con un Documento Nacional
// de Identidad (DNI) en el que figura un número y una letra, por ejemplo 56999545W.
// Realiza un programa donde le pidas al usuario SOLO el número del dni y el programa te
// devuelva la letra. Para calcular la letra solo tienes que dividir el número del DNI
// entre 23, el resto de esta división se corresponde con la posición de la letra en el
// abecedario. Utiliza un array para guardar CADA letra del abecedario.

import java.util.Scanner;

public class ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce su DNI sin letra: ");
        //Array con cada letra del abecedario como nos dice el ejercicio
        String[] abecedario = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        //Variables creadas dni para el dni que introducimos por teclado y n almacena la posicion del array para mostrar la letra
        int dni= sc.nextInt();
        int n= dni%23;
        //Muestra por pantalla la letra
        System.out.println("La letra de su DNI es: " +abecedario[n]);
    }
}