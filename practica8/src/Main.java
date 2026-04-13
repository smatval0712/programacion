import rpg.dao.PersonajeDAO;
import rpg.dao.RazaDAO;
import rpg.model.Personaje;
import rpg.model.Raza;

import java.sql.*;

public class Main {
    static void main(String[] args) {
        PersonajeDAO personajeDAO= new PersonajeDAO();
        for (Personaje personaje: personajeDAO.getPersonajes()){
            System.out.println(personaje.getClase().getNombre() +"->" + personaje.getCiudad().getNombre() + "->"+personaje.getRaza().getNombre());
        }

    }
}
