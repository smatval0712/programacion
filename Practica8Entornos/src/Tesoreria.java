import java.util.ArrayList;

public class Tesoreria {
    ArrayList<Paquete> listaPaquetes;

    public Tesoreria(ArrayList<Paquete> listaPaquetes){
        this.listaPaquetes=listaPaquetes;
    }

    public int calcularTotalAPagar(){
        int cantidadTotal=0;
        for (Paquete p:this.listaPaquetes){
            cantidadTotal+=p.getDineroGenerado();
        }
        return cantidadTotal;
    }
}
