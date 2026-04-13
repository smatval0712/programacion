package rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    private Integer id;
    private String nombre;
    private List<Habilidad> listaHabilidades;
    public Clase(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaHabilidades = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
