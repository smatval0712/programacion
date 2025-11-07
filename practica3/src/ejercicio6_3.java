//Modifica el programa anterior de tal forma que no se repita ningún número en
//el array además de que tiene que estar comprendido en un rango entre 20-40.


public class ejercicio6_3 {
    public static void main(String[] args) {
        //Creamos el array bidimensional de 6 filas y 10 columnas
        int[][] abi = new int[6][10];
        int sumatotal=0;

        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[0].length; j++) {
                abi[i][j]= (int) (Math.random()*21)+20;
            }
        }
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                for (int k = i; k < abi.length; k++) {
                    for (int l = (k == i ? j + 1 : 0); l < abi[k].length; l++) {
                        if(abi[i][j] == abi[k][l]){
                            abi [k][l]=0;
                        }
                    }
               }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < abi.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < abi[i].length; j++) {
                //Muestra las posiciones del array
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
        //Bucle para sacar
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                //con este if vamos comparando los valores de cada columna invirtiendo los parametros [j] por [i],
                // ya que sino intentará acceder a indices (filas) que no existen
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
        //Bucle leyendo el array por columnas y sumando los valores para obtener la suma total de cada columna
        for (int i = 0; i < abi[0].length; i++) {
            int sumacolumna=0;
            for (int j = 0; j < abi.length; j++) {
                sumacolumna+=abi[j][i];
            }
            System.out.printf("%4s", "Σ=");
            System.out.printf("%-5d |", sumacolumna);
        }
        System.out.printf("%5s", "Tot= ");
        System.out.printf("%-1d |", sumatotal);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("- El número máximo es " +max +" que está en la fila " +maxfila +" y en la columna " +maxcolumna);
        System.out.println("- El número mínimo es " +min +" que está en la fila " +minfila +" y en la columna " +mincolumna);

    }
}