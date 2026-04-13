package rpg.model;

import java.util.HashMap;
import java.util.Map;

public class Personaje {
    private Integer id;
    private String nombre;
    private Integer nivel;
    private Integer oro;
    private Integer vida_actual;
    private Raza raza;
    private Clase clase;
    private Ciudad ciudad;
    private Map<Item,Integer> inventario;
    private Map<Habilidad, Boolean> habilidades;

    public Personaje(Integer id, String nombre, Integer nivel, Integer oro, Integer vida_actual, Raza raza, Clase clase, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.oro = oro;
        this.vida_actual = vida_actual;
        this.raza = raza;
        this.clase = clase;
        this.ciudad = ciudad;
        this.inventario = new HashMap<>();
        this.habilidades = new HashMap<>();
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

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getOro() {
        return oro;
    }

    public void setOro(Integer oro) {
        this.oro = oro;
    }

    public Integer getVida_actual() {
        return vida_actual;
    }

    public void setVida_actual(Integer vida_actual) {
        this.vida_actual = vida_actual;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Map<Item, Integer> getInventario() {
        return inventario;
    }

    public void setInventario(Map<Item, Integer> inventario) {
        this.inventario = inventario;
    }

    public Map<Habilidad, Boolean> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Map<Habilidad, Boolean> habilidades) {
        this.habilidades = habilidades;
    }

}




