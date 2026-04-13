package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Clase;
import rpg.model.Raza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClaseDAO {
    private ArrayList<Clase> clases;
    private ConexionDB conexionDB;

    public ClaseDAO(){
        this.clases=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        cargaCiudades();


    }

    public ArrayList<Clase> getClases() {
        return clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public void cargaCiudades(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM clases_rpg");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                this.clases.add(new Clase(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Clase buscaClasePorId(Integer id){
        for (Clase clase : clases){
            if (clase.getId().equals(id)){
                return clase;
            }
        }
        return null;
    }
}