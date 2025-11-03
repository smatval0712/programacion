//Modifica el programa anterior de tal forma que
// las sumas parciales y la suma total aparezcan en la
// pantalla con un pequeño retraso, dando la impresión de que
// el ordenador se queda “pensando” antes de mostrar los números.

public class ejercicio4_3 {
    //ponemos throws InterruptedException para poder "dormir" el programa por un tiempo
    public static void main(String[] args) throws InterruptedException {
        //Creamos el array bidimensional de 4 filas y 5 columnas
        int[][] abi = new int[4][5];
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
            //Aqui establecemos que se quede "dormido" por 3000 ms o 3 seg para que parezca
            //que se quede como pensando antes de mostrar la suma de la fila
            Thread.sleep(3000);
            System.out.printf("%-5d |", sumafila);
            System.out.println();
            //esto es cada linea de separación entre filas de nuestra tabla
            System.out.println("-------------------------------------------------------------------");
        }
        //con este bucle doble recorremos el contenido del array por columnas comparando el contenido de estas para sacar el valor maximo
        //en el primer bucle ponemos que i sea< abi[0].length para que se ejecute tantas veces como numero de columnas (celdas)
        // que tenga la primera fila
        for (int i = 0; i < abi[0].length; i++) {
            //definimos la variable maxcolumna y establecemos que en principio tendra el valor de la primera posicion de la columna actual (j), que sera la primera posicion (0)
            int maxcolumna = abi[0][i];
            //ahora vamos comparando empezando por el número 1 para que compare el siguiente elemento de la columna, la iteración se repite hasta que acabe los números de la columna
            //con este bucle empezamos a comparar empezando por la siguiente posición (1) para que no se compare con si mismo
            for (int j = 1; j < abi.length; j++) {
                //con este if vamos comparando los valores de cada columna invirtiendo los parametros [j] por [i],
                // ya que sino intentará acceder a indices (filas) que no existen
                //y establecemos que si la posicion en la que estamos es mayor al valor actual de maxcolumna, lo almacene en ella como nuevo valor maximo
                if (abi[j][i] > maxcolumna) {
                    maxcolumna = abi[j][i];
                }
            }
            //imprimimos por pantalla el valor maximo de cada columna de forma centrada (maxcolumna)
            System.out.printf("%3s", " Max ");
            System.out.printf("%-3d |", maxcolumna);
        }
        //aqui imprimimos el valor de sumatotal que sera la suma total de todas las filas (sumafila)
        System.out.printf("%2s", " Tot ");
        //Aqui lo volvemos a "dormir" antes de mostrar la suma total
        Thread.sleep(3000);
        System.out.printf("%-3d |", sumatotal);
        //esta es la linea final de nuestra tabla
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
    }
}
