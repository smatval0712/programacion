import java.util.ArrayList;
//atributos
public class Hospital {
    private String nombre;
    private String cif;
    private ArrayList<Areas> areas;

    //constructor
    public Hospital(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        //se indica aqui y no entre los parentesis del constructor porque no la recibe directamente, sino que tiene que estrar creada antes.
        this.areas = new ArrayList<>();
    }
    //get
    public String getNombre(){
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public ArrayList<Areas> getAreas() {
        return areas;
    }

    //set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setAreas(ArrayList<Areas> areas) {
        this.areas = areas;
    }
}