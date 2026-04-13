package rpg.dao;

import rpg.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;
    private ConexionDB conexionDB;
    private RazaDAO razaDAO;
    private ClaseDAO claseDAO;
    private CiudadDAO ciudadDAO;
    private HabilidadDAO habilidadDAO;

    public PersonajeDAO(){
        this.personajes=new ArrayList<>();
        this.conexionDB=new ConexionDB();
        this.claseDAO=new ClaseDAO();
        this.razaDAO=new RazaDAO();
        this.ciudadDAO=new CiudadDAO();
        this.habilidadDAO= new HabilidadDAO();
        cargaPersonaje();
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public RazaDAO getRazaDAO() {
        return razaDAO;
    }

    public void setRazaDAO(RazaDAO razaDAO) {
        this.razaDAO = razaDAO;
    }

    public ClaseDAO getClaseDAO() {
        return claseDAO;
    }

    public void setClaseDAO(ClaseDAO claseDAO) {
        this.claseDAO = claseDAO;
    }

    public CiudadDAO getCiudadDAO() {
        return ciudadDAO;
    }

    public void setCiudadDAO(CiudadDAO ciudadDAO) {
        this.ciudadDAO = ciudadDAO;
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
                Raza raza=razaDAO.buscaRazaPorId(id_raza);
                Clase clase = claseDAO.buscaClasePorId(id_clase);
                Ciudad ciudad = ciudadDAO.buscaCiudadPorId(id_ciudad_actual);

               Personaje p = new Personaje(id,nombre,nivel,oro,vida_actual,raza,clase,ciudad);
               habilidadDAO.cargaHabilidadesEnPersonajes(p);
               this.personajes.add(p);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public Personaje crearPersonaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un nombre para tu personaje: ");
        String nombre = sc.next();

        System.out.println("Elije una raza introduciendo su id: ");
        for (Raza raza : razaDAO.getRazas()) {
            System.out.println(raza.getId() + " -> " + raza.getNombre());
        }
        Integer Id_Raza_Elegida = sc.nextInt();

        Raza razaElegida = null;
        for (Raza raza : razaDAO.getRazas()) {
            if (raza.getId().equals(Id_Raza_Elegida)) {
                razaElegida = raza;
                break;
            }
        }

        if (razaElegida == null) {
            System.out.println("Raza no encontrada");
        }

        System.out.println("Elije una clase introduciendo su id: ");
        for (Clase clase : claseDAO.getClases()) {
            System.out.println(clase.getId() + " -> " + clase.getNombre());
        }
        Integer Id_Clase_Elegida = sc.nextInt();
        for (Clase clase : claseDAO.getClases()) {
            if (clase.getId().equals(Id_Clase_Elegida)) {
                Clase claseElegida = clase;
            }
        }

        Integer vidaMaxima = 100 + razaElegida.getBonificador_vida();


    }









}
