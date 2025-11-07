//Modifica el programa del Ejercicio 6 para que:
//Los números NO se repitan (como en el ejercicio anterior).
//Los números estén comprendidos en un rango dinámico (el usuario introduce el valor mínimo y máximo).
//Al final, el programa muestre:
//La media aritmética de todos los números del array.
//La posición de todos los números primos que haya en el array.
//Una representación gráfica en consola de cada fila, donde cada número se represente con un número de
// * proporcional a su valor dentro del rango dado (por ejemplo, si el rango es 10-20 y aparece el 15, se mostrarán 5 *).


import java.util.Scanner;
//Creamos la funcion esPrimo para comprobar cuando la llamemos si es un numero primo o no
public class ejercicio7_3 {
    //Es de tipo booleano, osea que devuelve verdadero o falso, y recibe un numero entero para comprobar dicho numero (int numpri)
    public static boolean esPrimo(int numpri) {
        //si el numero es menor o igual a 1 devuelve falso porque no es primo
        if (numpri <= 1) {
            return false;
        }
        //este bucle va probando divisores (i) desde el 2 hasta la raiz cuadrada de dicho numero (i * i <= numpri)
        for (int i = 2; i * i <= numpri; i++) {
            //si el resto de la division entre el numero y el divisor (i) es 0 devuelve falso, el numero no es primo
            if (numpri % i == 0) {
                return false;
            }
        }
        //si no, devuelve verdadero, el numero si es primo
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Establecemos el rango maximo y minimo de numeros qe vamos a meter en nuestro array
        System.out.println("Introduce el valor mínimo del rango");
        int rangominimo = sc.nextInt();
        System.out.println("Introduce el valor máximo del rango");
        int rangomaximo = sc.nextInt();
        //Creamos el array bidimensional de 6 filas y 10 columnas
        int[][] abi = new int[6][10];
        int sumatotal = 0;
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                //establecemos que rellene las posiciones con números aleatorios entre el numero maximo y el minimo que hemos metido
                abi[i][j] = (int) (Math.random() * (rangomaximo - rangominimo + 1)) + rangominimo;
            }
        }
        //Bucle para que compare todas las posiciones del array y a las que estén repetidas le ponga 0
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                for (int k = i; k < abi.length; k++) {
                    //Establecemos en el valor de la l un if de que si k es igual a i, entonces l vale el valor de j + 1 y si no vale 0, de esta
                    // manera nos aseguramos de que al pasar a la siguiente fila, también coga el valor de la primera columna
                    for (int l = (k == i ? j + 1 : 0); l < abi[k].length; l++) {
                        if (abi[i][j] == abi[k][l]) {
                            abi[k][l] = 0;
                        }
                    }
                }
            }
        }
        //Bucle mostrando el array en forma de tabla
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < abi.length; i++) {
            int sumafila = 0;
            for (int j = 0; j < abi[i].length; j++) {
                //dclaramos una variable para saber el numero de asteriscos que tenemos que mostrar segun el numero que sea
                int numeroasterisco=0;
                //Este if muestra espacios en blanco si el contenido de la posicion del array es 0
                if (abi[i][j] == 0) {
                    System.out.printf("%22s|", " ");
                }
                //Y si no, pues muestra su contenido en forma de asteriscos
                else {
                    //calculamos el numero de asteriscos que tenemos que mostrar
                    numeroasterisco= (abi[i][j]-rangominimo)+1;
                    //mostramos tantos asteriscos como numeros haya en numeroasteriscos
                    String asterisco= "*" .repeat(numeroasterisco);
                    System.out.printf("%1s", " ");
                    System.out.printf("%-21s|", asterisco);
                }
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
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
        //variables declaradas para calcular las diferentes cosas
        int maxfila = 0;
        int max = abi[0][0];
        int maxcolumna = 0;
        int min = abi[0][0];
        int minfila = 0;
        int mincolumna = 0;
        int contadordefilas = 0;
        int contadordecolumnas = 0;
        double media = 0;
        //Bucle para sacar el maximo y el minimo (ignorando el 0) de nuestro array
        for (int i = 0; i < abi.length; i++) {
            //ponemos un contador de filas para calcular la media aritmetica despues
            contadordefilas++;
            for (int j = 0; j < abi[i].length; j++) {
                //con este if vamos comparando los valores de cada columna invirtiendo los parametros [j] por [i],
                // ya que sino intentará acceder a indices (filas) que no existen
                if (abi[i][j] > max) {
                    max = abi[i][j];
                    maxfila = i;
                    maxcolumna = j;
                } else if (abi[i][j]!=0) {
                    if (abi[i][j] < min) {
                        min = abi[i][j];
                        minfila = i;
                        mincolumna = j;
                    }
                }
            }
        }
        //Bucle leyendo el array por columnas y sumando los valores para obtener la suma total de cada columna
        for (int i = 0; i < abi[0].length; i++) {
            //Ponemos un contador de columnas para calcular la media aritmetica
            contadordecolumnas++;
            int sumacolumna = 0;
            for (int j = 0; j < abi.length; j++) {
                //aaqui calculamos el total de cada columna
                sumacolumna += abi[j][i];
            }
            //mostramos el total de cada columna
            System.out.printf("%12s", "Σ=");
            System.out.printf("%-9d |", sumacolumna);
        }
        //calculamosos la media aritmetica
        media = (double) sumatotal / (double) (contadordefilas * contadordecolumnas);
        //mostramos la suma total
        System.out.printf("%5s", " Tot= ");
        System.out.printf("%-1d  |", sumatotal);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        //mostramos los numeros maximos y minimos con su posicion
        System.out.println("- El número máximo es " + max + " que está en la fila " + maxfila + " y en la columna " + maxcolumna);
        System.out.println("- El número mínimo es " + min + " que está en la fila " + minfila + " y en la columna " + mincolumna);
        //mostramos la media aritmetica
        System.out.print("- La media aritmética es ");
        System.out.printf("%5.2f", media);
        System.out.println();
        //Este bucle va comprobando que numeros son primos llamando a nuestra funcion esPrimo para ello, y muestra los primos y su posición
        for (int i = 0; i < abi.length; i++) {
            for (int j = 0; j < abi[i].length; j++) {
                if (esPrimo(abi[i][j])) {
                    System.out.println("- El número " + abi[i][j] + " es primo y está en la fila " + i + " y en la columna " + j);
                }
            }
        }
    }
}
