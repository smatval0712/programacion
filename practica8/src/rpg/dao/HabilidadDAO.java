package rpg.dao;

import rpg.model.Ciudad;
import rpg.model.Habilidad;
import rpg.model.Item;

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
}
