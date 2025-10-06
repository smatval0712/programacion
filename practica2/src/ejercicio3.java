public class ejercicio3 {
    public static void main (String[] args){
        //Crea un array de 5 numeros enteros
        int[] n = {12,55,32,78,5};
        int menor = n[0];
        //Muestra por consola el más pequeño de ellos
        for (int i=0; i<n.length; i++){
            if (n[i]< menor){
                menor=n[i];
            }
        }
        System.out.println("El número menor es "+menor);
    }
}