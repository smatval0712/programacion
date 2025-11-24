public class Main {
    public static void main (String[] args){
        Hospital h1=new Hospital("Hospital aliño", "H001");
        Areas a1=new Areas("Urgencias","URG","2",h1);
        Medico m1= new Medico("31456789E","Álvaro Aliño",19,"no binario",2587.23,2024,a1);
        //Añadir un medico al contador
        a1.nuevoMedico();
        //Añadir areas al ArrayList areas
        h1.añadirAreas(a1);
        //Calcular sueldo neto
        System.out.print("El sueldo neto es: ");
        System.out.printf("%5.2f", m1.sueldoNeto(21.0));





        Contrato c1=new Contrato(2024,m1,h1);


    }

}
