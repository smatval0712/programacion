//Crear un programa que cuando se le introduzca números enteros rellene un
// array de 6 filas por 10 columnas con números enteros positivos comprendidos
// entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá:
//      -dar la posición del número máximo y mínimo
//      -la suma total de todas las filas y columnas
//      -la suma de todas las columnas
//      -la suma de todas las filas.


public class ejercicio5_3 {
    //ponemos throws InterruptedException para poder "dormir" el programa por un tiempo
    public static void main(String[] args) {
        //Creamos el array bidimensional de 4 filas y 5 columnas
        int[][] abi = new int[6][10];
        //Con este bucle pedimos numeros por teclado y lo almacenamos en el array hasta que terminen las posiciones de este
        System.out.println("Introduce números: ");
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                //genera un numero aleatorio entre 1 y 1999 a cada posicion del array
                abi[i][j] =(int) (Math.random()*1999+1);
            }
        }
        //esta es la linea de arriba de la tabla
        System.out.println("-------------------------------------------------------------------");
        //creamos una variable fuera de los bucles para poder mostrarla al final que sera la que guarde la suma total de los numeros que hemos metido en el array
        int sumatotal=0;
        //Creamos un bucle que vaya recorriendo el array y mostrando el contenido de este en forma de tabla centrado y vaya calculando el total de cada fila
        for (int i = 0; i < abi.length; i++) {
            //establecemos dentro del primer bucle pero fuera del segundo la variable sumafila a 0 ya que si la establecemos dentro del otro
            //siempre tendra el valor total de la anterior fila y se ira sumando la siguiente sobre este valor
            //en cambio si lo ponemos fuera del segundo bucle cada vez que termine una fila antes de empezar la siguiente volver a ser 0
            int sumafila = 0;
            //Con este bucle dentro de otro bucle recorremos el contenido de cada fila del array, mostrando los valores de este y la suma total de la fila
            for (int j = 0; j < abi[i].length; j++) {
                System.out.printf("%7d", abi[i][j]);
                System.out.printf("%4s", "|");
                //aqui establecemos que la variable sumatotal sea igual al valor que ya tiene mas el valor de cada posicion que recorre el bucle
                sumafila += abi[i][j];
            }
            //aqui fuera del segundo bucle pero dentro del primero establecemos que la variable suma total sea el valor que ya tiene mas el valor del total de cada fila para calcular el total del array
            sumatotal += sumafila;
            //aqui mostramos el valor de suma fila que tiene el valor total de la suma de cada fila
            System.out.printf("%5s", "Σ=");
            System.out.printf("%-5d |", sumafila);
            System.out.println();
            //esto es cada linea de separación entre filas de nuestra tabla
            System.out.println("-------------------------------------------------------------------");
        }
        //con este bucle doble recorremos el contenido del array por columnas comparando el contenido de estas para sacar el valor maximo
        int maxfila =0;
        int max=0;
        int maxcolumna=0;

        for (int i = 0; i < abi.length; i++) {

            for (int j = 0; j < abi[i].length; j++) {
                //con este if vamos comparando los valores de cada columna invirtiendo los parametros [j] por [i],
                // ya que sino intentará acceder a indices (filas) que no existen
                //y establecemos que si la posicion en la que estamos es mayor al valor actual de maxcolumna, lo almacene en ella como nuevo valor maximo
                if (abi[i][j] > max) {
                    max = abi[i][j];
                    maxfila =i;
                    maxcolumna =j;
                }
            }
        }
        System.out.print("El número máximo es " +max +" que está en la fila " +maxfila +" y en la columna " +maxcolumna);
        //aqui imprimimos el valor de sumatotal que sera la suma total de todas las filas (sumafila)
        System.out.printf("%2s", " Tot ");
        System.out.printf("%-3d |", sumatotal);
        //esta es la linea final de nuestra tabla
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
    }
}