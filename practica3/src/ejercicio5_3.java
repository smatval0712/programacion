//Crear un programa que cuando se le introduzca números enteros rellene un
// array de 6 filas por 10 columnas con números enteros positivos comprendidos
// entre 0 y 1000 (ambos incluidos). A continuación, el programa deberá:
//      -dar la posición del número máximo y mínimo
//      -la suma total de todas las filas y columnas
//      -la suma de todas las columnas
//      -la suma de todas las filas.


public class ejercicio5_3 {
    public static void main(String[] args) {
        //Creamos el array bidimensional de 6 filas y 10 columnas
        int[][] abi = new int[6][10];
        int sumatotal=0;
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < abi.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < abi[i].length; j++) {
                //genera un numero aleatorio entre 0 y 1000 a cada posicion del array
                abi[i][j] =(int) (Math.random()*1001);
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
            System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        }
        int maxfila =0;
        int max=abi [0][0];
        int maxcolumna=0;
        int min= abi [0][0];
        int minfila=0;
        int mincolumna=0;
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
                else if (abi[i][j]< min) {
                    min = abi[i][j];
                    minfila = i;
                    mincolumna = j;

                }
            }
        }

        System.out.println("- El número máximo es " +max +" que está en la fila " +maxfila +" y en la columna " +maxcolumna);
        System.out.println("- El número mínimo es " +min +" que está en la fila " +minfila +" y en la columna " +mincolumna);
        System.out.printf("%2s", "- El Total es ");
        System.out.printf("%-3d ", sumatotal);
    }
}