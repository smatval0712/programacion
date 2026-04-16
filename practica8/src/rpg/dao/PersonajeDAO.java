package rpg.dao;

import rpg.model.*;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonajeDAO {
    private ArrayList<Personaje> personajes;
    private ItemsDAO itemsDAO;
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
        this.itemsDAO=new ItemsDAO();
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

    public HabilidadDAO getHabilidadDAO() {
        return habilidadDAO;
    }

    public void setHabilidadDAO(HabilidadDAO habilidadDAO) {
        this.habilidadDAO = habilidadDAO;
    }

    public ItemsDAO getItemsDAO() {
        return itemsDAO;
    }

    public void setItemsDAO(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    public void cargaPersonaje(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM personajes ORDER BY id ASC");

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
               itemsDAO.cargaItemsEnPersonaje(p);
               habilidadDAO.cargaHabilidadesEnPersonajes(p);
               this.personajes.add(p);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //Funcion para insertar el personaje en la bd, devolviendo su id para solucionar el problema del id al crear el personaje

    public Integer insertarPesonajeEnBD(String nombre, Integer nivel, Integer oro, Integer vidaMaxima, Raza razaElegida, Clase claseElegida, Ciudad ciudadElegida){
        ResultSet resultset = conexionDB.executeQuery(
                "INSERT INTO personajes (nombre, nivel, oro, vida_actual, id_raza, id_clase, id_ciudad_actual) " +
                        "VALUES ('" + nombre + "', " + nivel + ", " + oro + ", " + vidaMaxima + ", " +
                        razaElegida.getId() + ", " + claseElegida.getId() + ", " + ciudadElegida.getId() + ") RETURNING id");
        Integer idGenerado = null;
        try {
            if (resultset.next()) {
                idGenerado = resultset.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  idGenerado;
    }



    //Funcion para cambiar la ciudad del personaje, en la bd y local
    public void cambiarCiudadPersonaje(Personaje p, Ciudad c){
        conexionDB.executeUpdate(
                "UPDATE personajes SET id_ciudad_actual = " + c.getId() + " WHERE id = " + p.getId());
        p.setCiudad(c);
    }
    //Funcion para restar oro a un personaje (utilizada en comprasItems)
    public void restarOroPersonaje(Integer Oro, Personaje p){
        conexionDB.executeUpdate(
                "UPDATE personajes SET oro = " +Oro + " WHERE id = " +p.getId());
    }

    //Funcion para actualizar inventario personajes
    public void actualizarInventarioPersonaje(Item i, Personaje p){
        conexionDB.executeUpdate(
                "INSERT INTO inventarios (id_personaje, id_item, cantidad) VALUES (" +p.getId() +", " +i.getId() +", 1)" +
                        "ON CONFLICT (id_personaje, id_item) DO UPDATE SET cantidad = inventarios.cantidad + 1 "
        );
    }

    //FUNCION PARA DESTERRAR UN PERSONAJE, LO PONE A NULL EN LA BASE DE DATOS Y EN EL PERSONAJE DE FORMA LOCAL
    public void desterrarPersonaje(Personaje p) {
        conexionDB.executeUpdate(
                "UPDATE personajes SET id_ciudad_actual = NULL WHERE id = " + p.getId()
        );
        p.setCiudad(null);
    }

    public void equiparHabilidad(Personaje p, Habilidad h, boolean equipada) {
        conexionDB.executeUpdate(
                "UPDATE personajes_habilidades SET equipada_combate = " + equipada +
                        " WHERE id_personaje = " + p.getId() +
                        " AND id_habilidad = " + h.getId()
        );
        p.getHabilidades().put(h, equipada);
    }
}
