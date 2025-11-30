//Escribe un programa java que invierta el orden de los valores de un array.
// Por invertir el orden de los valores de un array, me refiero que el último pasa a ser el primero,
// el penúltimo el segundo y así sucesivamente. PRUEBA CON UN ARRAY DE TAMAÑO 6.


public class ejercicio11 {
    public static void main(String[] args) {
      int [] a= {1,2,3,4,5,6};

      for (int i =a.length-1;i>=0;i--){
          System.out.print(a[i]);
      }
    }
}
