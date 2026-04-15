package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.model.Item;
import rpg.model.Personaje;

public class GestionMundo {
    private PersonajeDAO personajeDAO;

    public GestionMundo(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }

    public PersonajeDAO getPersonajeDAO() {
        return personajeDAO;
    }

    public void setPersonajeDAO(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }

    public void comprarItems(Personaje p, Item i){
        if(p.getOro()>=i.getPrecio_oro()){
            if (p.getInventario().containsKey(i)){
                p.getInventario().put(i,p.getInventario().get(i)+1);
            }
            else {
                p.getInventario().put(i,1);
            }
            p.setOro(p.getOro()-i.getPrecio_oro());
            personajeDAO.restarOroPersonaje(p.getOro(),p);
            personajeDAO.actualizarInventarioPersonaje(i,p);
        } else {
            System.out.println("Fondos insuficientes");
        }
    }
}
