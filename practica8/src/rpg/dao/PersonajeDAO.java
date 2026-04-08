package rpg.dao;

import rpg.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;
    private ConexionDB conexionDB;

    public PersonajeDAO(){
        this.personajes=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        cargaPersonaje();

    }

    public void cargaPersonaje(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM personajes");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer nivel = resultset.getInt("nivel");
                Integer oro = resultset.getInt("oro");
                Integer vida_actual = resultset.getInt("vida_actual");
                Integer id_raza = resultset.getInt("id_raza");
                Integer id_clase = resultset.getInt("id_clase");
                Integer id_ciudad_actual = resultset.getInt("id_ciudad_actual");
                Raza raza=buscarRaza(id_raza);
                Clase clase = buscarClase(id_clase);
                Ciudad ciudad = buscarCiudad(id_ciudad_actual);

                this.personajes.add(new Personaje(id,nombre,nivel,oro,vida_actual,raza,clase,ciudad));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Raza buscarRaza(Integer id) {
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM razas WHERE id = " + id);

        try {
            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                Integer bonificador_vida = resultset.getInt("bonificador_vida");
                Integer bonificador_fuerza = resultset.getInt("bonificador_fuerza");

                return new Raza(id, nombre, bonificador_vida, bonificador_fuerza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Clase buscarClase(Integer id_clase){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM clases_rpg WHERE id = " + id_clase);

        try {
            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                return new Clase(id_clase, nombre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Ciudad buscarCiudad(Integer id_ciudad_actual){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM ciudades WHERE id = " + id_ciudad_actual);

        try {
            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                Integer nivel_minimo_acceso = resultset.getInt("nivel_minimo_acceso");

                return new Ciudad(id_ciudad_actual, nombre, nivel_minimo_acceso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }






}
