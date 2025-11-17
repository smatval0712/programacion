public class Usuario {
    //parametros
    private String nombre;
    private String apellidos;
    private String direccion;
    private Integer codigopostal;
    private String email;
    private String contraseña;

    //constructor
    public Usuario (String nom, String ape, String dir,Integer codpos, String em, String pass) {
        this.nombre = nom;
        this.apellidos = ape;
        this.direccion = dir;
        this.codigopostal = codpos;
        this.email = em;
        this.contraseña = pass;
    }
    //get para todos los atributos
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public Integer getCodigopostal(){
        return this.codigopostal;
    }
    public String getEmail(){
        return this.email;
    }
    public String getContraseña(){
        return this.contraseña;
    }

    //set para todos los atributos
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    public void setApellidos(String nuevoApellidos) {
        this.apellidos = nuevoApellidos;
    }
    public void setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }
    public void setEmail(String nuevoEmail) {
        if (nuevoEmail.contains("@")) {
            this.email = nuevoEmail;
        }
        else {
            System.out.println("Error:Email inválido. No contiene @");
        }
    }
    public void setCodigopostal(String nuevoCodigopostal) {
        this.codigopostal = codigopostal;
    }
    public void setContraseña(String nuevaContraseña) {
        this.contraseña = contraseña;
    }

    //Metodo de autenticación
    public boolean checkUsuario(String email, String pass){
        return this.email.equals(email) && this.contraseña.equals(pass);
    }
    //Metodo ToString
    public String toString(){
        return "El nombre es" +this.nombre + ", el apellido es " +this.apellidos + ", y el email es " +this.email;
    }
}