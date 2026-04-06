package rpg.model;

public class Habilidad {
    private Integer id;
    private String nombre;
    private Integer danio_base;
    private Integer usos_maximos;
    private Integer id_clase;

    public Habilidad(Integer id, String nombre, Integer danio_base, Integer usos_maximos, Integer id_clase) {
        this.id = id;
        this.nombre = nombre;
        this.danio_base = danio_base;
        this.usos_maximos = usos_maximos;
        this.id_clase = id_clase;
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

    public Integer getDanio_base() {
        return danio_base;
    }

    public void setDanio_base(Integer danio_base) {
        this.danio_base = danio_base;
    }

    public Integer getUsos_maximos() {
        return usos_maximos;
    }

    public void setUsos_maximos(Integer usos_maximos) {
        this.usos_maximos = usos_maximos;
    }

    public Integer getId_clase() {
        return id_clase;
    }

    public void setId_clase(Integer id_clase) {
        this.id_clase = id_clase;
    }
}
