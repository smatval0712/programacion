public class Usuario {
    //parametros
    private String nombre;
    private String apellidos;
    private String direccion;
    private String codigopostal;
    private String email;
    private String contraseña;
    //constructor
    public Usuario (String nom, String ape, String dir,String codpos, String em, String pass) {
        nombre = nom;
        apellidos = ape;
        direccion = dir;
        codigopostal = codpos;
        email = em;
        contraseña = pass;
    }
    //get para todos los atributos
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getCodigopostal(){
        return codigopostal;
    }
    public String getEmail(){
        return email;
    }
    public String getContraseña(){
        return contraseña;
    }

//set para todos los atributos


    public String setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        return this.nombre;
    }
    public String setApellidos(String nuevoApellidos) {
        this.apellidos = nuevoApellidos;
        return this.apellidos;
    }
    public String setDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
        return this.direccion;
    }
    public String setEmail(String nuevoEmail) {
        if (email.contains("@")) {
            this.email = nuevoEmail;
        }
        else {
            System.out.println("Error:Email inválido. No contiene @");
        }
        return nuevoEmail;
    }
    public String setCodigopostal(String nuevoCodigopostal) {
        this.codigopostal = codigopostal;
    }
    public void setContraseña(String nuevaContraseña) {
        this.contraseña = contraseña;
    }
}