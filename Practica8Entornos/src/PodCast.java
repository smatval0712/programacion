public class PodCast implements Paquete{
    private String nombre;
    private boolean gratuito;
    private int dineroGenerado;
    private String tipo;


    public PodCast(String nombre){
        this.nombre=nombre;
        this.gratuito=true;
        this.dineroGenerado=0;
        this.tipo="Pod Cast";
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }
    @Override
    public int getDineroGenerado() {
        return dineroGenerado;
    }

    public void setDineroGenerado(int dineroGenerado) {
        this.dineroGenerado = dineroGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isGratuito() {
        return gratuito;
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
