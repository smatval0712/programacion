package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.model.Raza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CiudadDAO {
    private ArrayList<Ciudad> ciudades;
    private ConexionDB conexionDB;

    public CiudadDAO(){
        this.ciudades=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        cargaCiudades();
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public void cargaCiudades(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM ciudades");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer nivel_minimo_acceso = resultset.getInt("nivel_minimo_acceso");

                this.ciudades.add(new Ciudad(id, nombre, nivel_minimo_acceso));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Ciudad buscaCiudadPorId(Integer id){
        for (Ciudad ciudad : ciudades){
            if (ciudad.getId().equals(id)){
                return ciudad;
            }
        }
        return null;
    }
}
