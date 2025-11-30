public class Direccion {
    //atributos
    private String calle;
    private int numero;
    private int codpos;
    private String localidad;
    private String provincia;

    //constructor
    public Direccion(String calle, int numero, int codpos, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.codpos = codpos;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    //get

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodpos() {
        return codpos;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    //set

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodpos(int cp) {
        this.codpos = cp;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}