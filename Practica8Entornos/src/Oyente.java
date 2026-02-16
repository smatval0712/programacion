import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Oyente {
    private String nombre;
    //añadido por mi
    private ArrayList<Cancion> catalogo;
    //añadido por mi
    private HashMap<String, HashSet<Cancion>>listaDeReproduccion;


    public Oyente(String nombre){
        this.nombre=nombre;
        this.catalogo=new ArrayList<>();
        this.listaDeReproduccion=new HashMap<>();
    }

    public boolean cancionesCatalogo(Cancion cancion){
        for (Cancion can:this.catalogo){
            if (can.getNombre().equals(cancion.getNombre())){
                return true;
            }
        }
        return false;
    }
    public void crearListaReproduccion(String nombre, Cancion cancion){
        HashSet<Cancion>listaCanciones=new HashSet<>();
        listaCanciones.add(cancion);
        this.listaDeReproduccion.put(nombre,listaCanciones);
    }

    public void borrarLista(String nombreLista){
        this.listaDeReproduccion.remove(nombreLista);
    }

    //añadido por mi
    public void aniadeCancionALista(String nombreLista,Cancion cancion){
        this.listaDeReproduccion.get(nombreLista).add(cancion);
    }


}
