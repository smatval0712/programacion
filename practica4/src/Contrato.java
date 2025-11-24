import com.sun.management.HotSpotDiagnosticMXBean;

public class Contrato {
    private Integer fechaCreacion;
    private Medico medico;
    private Hospital hospital;

    //constructor
    public Contrato (Integer fechaCreacion,Medico medico, Hospital hospital){
        this.fechaCreacion=fechaCreacion;
        this.medico=medico;
        this.hospital=hospital;
    }
    //get
    public Integer getFechaCreacion() {
        return fechaCreacion;
    }
    public Medico getMedico() {
        return medico;
    }
    public Hospital getHospital() {
        return hospital;
    }
    //set
    public void setFechaCreacion(Integer fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
