public class Catalogo {
    private String nombre;
    public Catalogo(String nombre){
        this.nombre=nombre;
    }

    public String observarContenido(Paquete p){
        return p.getTipo();
    }
}
