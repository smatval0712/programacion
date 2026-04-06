package rpg.model;

public class Raza {
    private Integer id;
    private String nombre;
    private Integer bonificador_vida;
    private Integer bonificador_fuerza;

    public Raza(Integer id, String nombre, Integer bonificador_vida, Integer bonificador_fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.bonificador_vida = bonificador_vida;
        this.bonificador_fuerza = bonificador_fuerza;
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

    public Integer getBonificador_vida() {
        return bonificador_vida;
    }

    public void setBonificador_vida(Integer bonificador_vida) {
        this.bonificador_vida = bonificador_vida;
    }

    public Integer getBonificador_fuerza() {
        return bonificador_fuerza;
    }

    public void setBonificador_fuerza(Integer bonificador_fuerza) {
        this.bonificador_fuerza = bonificador_fuerza;
    }
}
