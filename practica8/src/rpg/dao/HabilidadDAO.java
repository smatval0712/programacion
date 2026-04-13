package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Habilidad;
import rpg.model.Item;
import rpg.model.Personaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadDAO {
    private ArrayList<Habilidad> habilidades;
    private ConexionDB conexionDB;

    public HabilidadDAO(){
        this.habilidades=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        cargaHabilidades();
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public void cargaHabilidades(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM Habilidades");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer dano_base = resultset.getInt("dano_base");
                Integer usos_maximos = resultset.getInt("usos_maximos");
                Integer id_clase = resultset.getInt("id_clase");

                this.habilidades.add(new Habilidad(id, nombre,dano_base,usos_maximos, id_clase));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Habilidad buscaHabilidadPorId(Integer id_habilidad){
        for (Habilidad habilidad: habilidades){
            if (habilidad.getId().equals(id_habilidad)){
                return habilidad;
            }
        }
        return null;
    }

    public void cargaHabilidadesEnPersonajes(Personaje personaje){
        try {
            ResultSet resultset = conexionDB.executeQuery("SELECT * FROM personajes_habilidades WHERE id_personaje = " + personaje.getId());

            while (resultset.next()) {
                Integer id_habilidad = resultset.getInt("id_habilidad");
                boolean equipada = resultset.getBoolean("equipada_combate");
                Habilidad habilidad=buscaHabilidadPorId(id_habilidad);
                personaje.getHabilidades().put(habilidad,equipada);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void aniadirHabilidadesPersonaje(Personaje personaje){
        for(Habilidad habilidad : habilidades){
            if(habilidad.getId_clase().equals(personaje.getClase().getId())){
                personaje.getHabilidades().put(habilidad,false);
            }
        }
    }
}
