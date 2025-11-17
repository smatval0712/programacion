public class Main {
    public static void main(String[]args){
        Usuario user1= new Usuario("Sergio","Mateos Valenzuela",  "Av lola flores 1", 11405,"sergiomateos33@gmail.com", "123456");
        Usuario user2= new Usuario("Marco","Paloma Sacerdote",  "La Plata 23", 11407,"palomita@gmail.com", "123456");
        Usuario user3= new Usuario("Álvaro","Aliño Pepelu",  "La Plata 28", 11407,"alvaritopepelu@gmail.com", "123456");

        Usuario [] usuarios= {user1, user2, user3};
        //set a nombre
        System.out.println(user2.getNombre());
        user2.setNombre("Alberto");
        System.out.println(user2.getNombre());
        //set a email
        System.out.println(user2.getEmail());
        user2.setEmail("Alberto@chulo");
        System.out.println(user2.getEmail());
        //llamada a checkusuario
        System.out.println(user2.checkUsuario("Alberto@chulo","123456"));


    }
}
