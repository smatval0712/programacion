package rpg.dao;

import rpg.model.Raza;

import java.sql.*;
import java.util.ArrayList;

public class RazaDAO {
    private ArrayList<Raza> razas;
    private ConexionDB conexionDB;

    public RazaDAO(){
        this.conexionDB=new ConexionDB();
        this.razas=new ArrayList<>();
        cargaRazas();
    }

    public ArrayList<Raza> getRazas() {
        return razas;
    }

    public void setRazas(ArrayList<Raza> razas) {
        this.razas = razas;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public void cargaRazas(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM razas");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                Integer bonificador_vida = resultset.getInt("bonificador_vida");
                Integer bonificador_fuerza = resultset.getInt("bonificador_fuerza");

                this.razas.add(new Raza(id, nombre, bonificador_vida, bonificador_fuerza));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}