//Define un array de números tipo double de 3 filas por
// 7 columnas con nombre doub y asigna los valores según la siguiente tabla.
// Muestra el contenido de todos los elementos del array dispuestos en forma de
// tabla como se muestra en la figura.


public class ejercicio1_3 {
    public static void main (String[] args) {
        //Creamos un array bidimensional de 3 filas y 7 columnas, lo creamos del estilo Double con d mayuscula para poder poner en las celdas vacias null
        Double [][] doub = {
                {0.0,30.0,2.0,null,null,5.0},
                {75.0,null,null,null,0.0,null},
                {null,null,-2.0,9.0,null,11.0}
        };
        //Imprimimos mediante un bucle for doble las columnas, utilizamos un bucle doble porque el primero recorre las filas y el segundo recorre las columnas
        //Establecemos que cuando llegue a la ultima columna de la primera fila termine el bucle mediante un break, sino nos imprimiria lo mismo
        //tantas veces como filas que haya
        System.out.print("Array num |");
        for (int i = 0; i < doub.length; i++) {
            for (int j = 0; j < doub[i].length; j++) {
                //Imprimimos columna en un espacio de 10 caracteres (%10s) seguido de un separador vertical (|).
                System.out.printf("%10s|", "Columna " + j);
            }
            break;
        }
        //Con otro bucle doble recorremos el array bidimensional
        System.out.println();
        for (int i=0; i< doub.length;i++) {
            //Imprime la etiqueta de la fila, por ejemplo, "Fila 0 |". El formato %-5d alinea el número de fila a la izquierda en un espacio de 5 caracteres.
            System.out.printf("Fila %-5d|", i );
            for (int j = 0; j < doub[i].length; j++) {
                //mediante este if indicamos que si lo que hay dentro de la posicion del array es distinto a null,
                //imprimimos el valor que hay en la posición en formato %10.0f lo imprime como un número de
                //punto flotante (f) con cero decimales (.0) en un espacio de 10 caracteres (%10)
                if (doub[i][j] != null) {
                    System.out.printf("%10.0f|", doub[i][j]);
                }
                //Y si es igual a null, imprime un espacio en blanco en un campo de 10 caracteres, manteniendo la estructura de la tabla.
                else {
                    System.out.printf("%10s|", " ");
                }
            }
            //Metemos un salto de línea para terminar la fila y pasar a la siguiente
            System.out.println();
        }
    }
}