package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.model.Personaje;

import java.util.ArrayList;
import java.util.Iterator;

public class Ritual {
    private PersonajeDAO personajeDAO;


    public Ritual(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }

    public PersonajeDAO getPersonajeDAO() {
        return personajeDAO;
    }

    public void setPersonajeDAO(PersonajeDAO personajeDAO) {
        this.personajeDAO = personajeDAO;
    }


    public void ejecutarCambiosRitual(int idPersonaje, Integer nuevoIdClase){
        Personaje personaje = null;
        for (Personaje p : personajeDAO.getPersonajes()){
            if(p.getId().equals(idPersonaje)){
                personaje=p;
            }
        }
        if (personaje.getInventario().size()>5){
            personaje.setClase(personajeDAO.getClaseDAO().buscaClasePorId(nuevoIdClase));
            personaje.setOro(personaje.getOro()-50);
            personajeDAO.actualizarOroYClaseBD(personaje);
        }
    }
    public void procesarRitual(ArrayList<Personaje> personajes, int idClaseEvolucionada){
        Iterator<Personaje> iterator = personajes.iterator();

        while (iterator.hasNext()) {
            Personaje p = iterator.next();
            Integer contadorEquipadas=0;
            for (boolean b: p.getHabilidades().values()){
                if (b){
                    contadorEquipadas++;
                }
            }
            if (contadorEquipadas>=3){
                ejecutarCambiosRitual(p.getId(),idClaseEvolucionada);
                if (p.getVida_actual()<p.getRaza().getBonificador_vida()*0.10){
                    personajeDAO.desterrarPersonaje(p);
                    iterator.remove();
                }
            }
        }

    }
}
