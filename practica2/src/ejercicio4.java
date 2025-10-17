//Crea un array de números de 100 posiciones, que contendrá los números
// del 1 al 100. Obtén la suma de todos ellos y la media.
public class ejercicio4 {
    public static void main(String[] args) {
        //Array de 100 posiciones
        int[] y=new int [100];
        for (int i = 0; i < 100; i++) {
            int x=i+1;
            //nombre del array y número de posiciones, en este caso i la marcará ya que la longitud la hemos definido arriba al definir el array
            y[i]=x;
        }
        //Recorrer el array mostrando cada posición
        //for (int i=0; i<100; i++) {
            //System.out.println(+y[i]);
        //}
        //suma de todos ellos
        int sum=0; //se define la variable suma fuera, si se define dentro se crea y se destruye dentro del array
        for (int i=0; i< y.length;i++) {
            //variable suma= el valor de suma + la posicion del array "y" marcado por la i del for
            sum=sum+y[i];
        }
        System.out.println("El resultado de la suma es " +sum);
        //Declaramos la variable media que es el resultado de la division entre la variable suma previamente calculada
        // y la longitud del array "y"
        int media=sum/y.length;

        System.out.println("La media es "+media);
    }
}