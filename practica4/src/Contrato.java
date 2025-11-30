import com.sun.management.HotSpotDiagnosticMXBean;

import java.time.LocalDate;

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

    // 1.- Comprobación de año, devuelve true si la fecha de creación del contrato coincide con el año dado
    public boolean esDeAnio(int anio){
        return anio==this.medico.getFechaInicio()?true:false;
    }
    //2.- Cálculo de vigencia, devuelve el número de días transcurridos desde la creación del contrato
    public Integer diasDesdeCreacion(){
        LocalDate fechaActual=LocalDate.now();
        int anioActual=fechaActual.getYear();
        return anioActual-this.fechaCreacion;
    }

}