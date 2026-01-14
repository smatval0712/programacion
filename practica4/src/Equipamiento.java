public class Equipamiento {
    private String nombre;
    private String codigo;
    private Integer fechaAdquisicion;


    public Equipamiento(String nombre, String codigo, Integer fechaAdquisicion) {
        this.nombre=nombre;
        this.codigo=codigo;
        this.fechaAdquisicion=fechaAdquisicion;
    }

    public String getNombre(){return nombre;}
    public String getCodigo(){return codigo;}
    public Integer getFechaAdquisicion(){return fechaAdquisicion;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFechaAdquisicion(Integer fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    //esAntiguo
    public boolean esAntiguo(){
        int anioActual=2025;
        if (anioActual - getFechaAdquisicion() >= 10) {
            return true;
        }
        return false;
    }
}