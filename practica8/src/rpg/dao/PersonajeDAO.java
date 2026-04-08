package rpg.dao;

import rpg.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;
    private ConexionDB conexionDB;
    private RazaDAO razaDAO;
    private ClaseDAO claseDAO;
    private CiudadDAO ciudadDAO;

    public PersonajeDAO(){
        this.personajes=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        this.razaDAO=new RazaDAO();
        this.claseDAO=new ClaseDAO();
        this.ciudadDAO=new CiudadDAO();
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

    public Raza buscarRaza(Integer id_raza){
        Raza razaBuscada = null;
        for (Raza raza: razaDAO.getRazas()){
            if (raza.getId().equals(id_raza)){
                razaBuscada=raza;
            }
        }
        return razaBuscada;
    }

    public Clase buscarClase(Integer id_clase){
        Clase claseBuscada = null;
        for (Clase clase: claseDAO.getClases()){
            if (clase.getId().equals(id_clase)){
                claseBuscada=clase;
            }
        }
        return claseBuscada;
    }

    public Ciudad buscarCiudad(Integer id_ciudad_actual){
        Ciudad ciudadBuscada = null;
        for (Ciudad ciudad: ciudadDAO.getCiudades()){
            if (ciudad.getId().equals(id_ciudad_actual)){
                ciudadBuscada=ciudad;
            }
        }
        return ciudadBuscada;
    }






}
