public class Paciente {
    private String dni;
    private String nombre;
    private String sexo;

    public Paciente(String dni, String nombre, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getSexo() {
        return sexo;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
