import java.time.LocalDate;
import java.util.ArrayList;
//atributos
public class Hospital {
    private String nombre;
    private String cif;
    private ArrayList<Areas> areas;
    private Direccion direccion;

    //constructor
    public Hospital(String nombre, String cif,Direccion direccion) {
        this.nombre = nombre;
        this.cif = cif;
        //se indica aqui y no entre los parentesis del constructor porque no la recibe directamente, sino que tiene que estrar creada antes.
        this.areas = new ArrayList<>();
        this.direccion = direccion;
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
    public Direccion getDireccion(){return direccion;}

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

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    //funcion para añadir area al ArrayList cuando se añade un medico
    public void añadirAreas(Areas areaNueva){
        this.areas.add(areaNueva);
    }
    //1.- Calculo agregado, suma y deuelve el total de médicos en todas sus areas.
    public Integer getNumeroTotalMedicos(){
        int suma=0;
        for (int i = 0; i < this.areas.size(); i++) {
            suma+=this.areas.get(i).getNumMedicos();
        }
        return suma;
    }
    //2.- Calculo de proporcion, Calcula la proporcoin (0 a 1) de medicos de una area especifica respecto al total del hospital
    public Double getProporcionMedicosArea(String idArea){
        double proporcion=0.0;
        for (int i = 0; i < this.areas.size(); i++) {
            if (idArea.equals(this.areas.get(i).getIdentificador())){
                proporcion=this.areas.get(i).getNumMedicos()*(getNumeroTotalMedicos()/100);
            }
        }
        return proporcion;
    }
    //3.- Comprobacion de existencia, devuelve true si el hospital ya tiene un area con ese id
    public boolean existeArea(String idArea){
        for (int i = 0; i < this.areas.size(); i++) {
            if (idArea.equals(this.areas.get(i).getIdentificador())){
                return true;
            }
        }
        return false; //devuelve false si no se encuentra en el array
    }


}