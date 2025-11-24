public class Medico {
    private String dni;
    private String nombre;
    private Integer edad;
    private String sexo;
    private Double sueldo;
    private Integer fechaInicio;
    private Areas area;

    //Constructor
    public Medico(String dni, String nombre, Integer edad, String sexo, Double sueldo, Integer fechaInicio, Areas area) {
        this.dni=dni;
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
        this.sueldo=sueldo;
        this.fechaInicio=fechaInicio;
        this.area=area;
    }

    //get
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public Integer getEdad() {
        return edad;
    }
    public String getSexo() {
        return sexo;
    }
    public Double getSueldo() {
        return sueldo;
    }
    public Integer getFechaInicio() {
        return fechaInicio;
    }
    public Areas getArea() {
        return area;
    }

    //set
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
    public void setFechaInicio(Integer fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public void setArea(Areas area) {
        this.area = area;
    }

    //funcion para calcular sueldo neto
    public Double sueldoNeto(Double retencion){
        return this.sueldo-(this.sueldo*(retencion/100));
    }
    //funcion para calcular años de antigüedad

}


