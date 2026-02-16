public class Cancion implements Paquete {
    private String nombre;
    private boolean gratuito;
    private int dineroGenerado;
    private String tipo;


    public Cancion(String nombre){
        this.nombre=nombre;
        this.gratuito=false;
        this.dineroGenerado=0;
        this.tipo="Canción";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getDineroGenerado() {
        return dineroGenerado;
    }

    public void setDineroGenerado(int dineroGenerado) {
        this.dineroGenerado = dineroGenerado;
    }

    @Override
    public void generaDineroAlSonar(int ganacia){
        if(!gratuito){
            setDineroGenerado(dineroGenerado+ganacia);
        }
    }
    @Override
    public boolean esMonetizable(){
        if (!this.gratuito){
            return false;
        }
        return true;
    }
}
