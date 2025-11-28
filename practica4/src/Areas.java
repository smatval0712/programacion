public class Areas {

    //Atributos
    private String nombre;
    private String identificador;
    private String planta;
    private Hospital hospital;
    private Integer numMedicos;

    //constructor
    public Areas (String nombre, String identificador,String planta,Hospital hospital){
        this.nombre=nombre;
        this.identificador=identificador;
        this.planta=planta;
        this.hospital=hospital;
        this.numMedicos=0;
    }

    //get
    public String getNombre(){
        return nombre;
    }
    public String getIdentificador(){
        return identificador;
    }
    public String getPlanta(){
        return planta;
    }
    public Hospital getHospital(){
        return hospital;
    }
    public Integer getNumMedicos(){
        return numMedicos;
    }

    //set
    public void setNombre (String nombre){
        this.nombre=nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setNumMedicos(Integer numMedicos) {
        this.numMedicos = numMedicos;
    }

    //Funcion para aumentar el medico
    public void nuevoMedico(){
        numMedicos++;
    }

    //1.- comprobación y comparación
    public String compararMedicos(Areas otraArea){
        if (this.numMedicos > otraArea.getNumMedicos()){
            return this.nombre;
        }
        else {
            return otraArea.getNombre();
        }
    }

    //2.- Cálculo de capacidad
    public Integer capacidadRestante(Integer capacidadMaxima){
        return this.numMedicos<capacidadMaxima?capacidadMaxima-this.numMedicos:0;
    }
}
