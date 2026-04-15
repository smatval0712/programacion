import rpg.dao.PersonajeDAO;
import rpg.dao.RazaDAO;
import rpg.model.Personaje;
import rpg.model.Raza;
import rpg.ui.Menu;

import java.sql.*;

public class Main {
    static void main(String[] args) {
        PersonajeDAO personajeDAO = new PersonajeDAO();
        Menu menu=new Menu();
        Personaje personajeElegido=personajeDAO.getPersonajes().getFirst();
        menu.comprarItems(personajeElegido);
    }
}
