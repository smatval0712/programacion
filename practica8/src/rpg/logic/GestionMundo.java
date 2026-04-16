package rpg.logic;

import rpg.dao.PersonajeDAO;
import rpg.exception.FondosInsuficientesException;
import rpg.model.Ciudad;
import rpg.model.Item;
import rpg.model.Personaje;
import rpg.utils.Log;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void comprarItems(Personaje p, Item i) throws FondosInsuficientesException {
        if (p.getOro() >= i.getPrecio_oro()) {
            if (p.getInventario().containsKey(i)) {
                p.getInventario().put(i, p.getInventario().get(i) + 1);
            } else {
                p.getInventario().put(i, 1);
            }
            p.setOro(p.getOro() - i.getPrecio_oro());
            personajeDAO.restarOroPersonaje(p.getOro(), p);
            personajeDAO.actualizarInventarioPersonaje(i, p);
            Log.info("Compra exitosa: " + p.getNombre() + " ha comprado " + i.getNombre() + " por " + i.getPrecio_oro() + " de oro.");
        } else {
            Log.error("Intento de compra fallido: FondosInsuficientesException - " + p.getNombre() + " no tiene oro suficiente para comprar " + i.getNombre());
            throw new FondosInsuficientesException("Fondos insuficientes: " + p.getNombre() + " solo tiene " + p.getOro() + " de oro y el item cuesta " + i.getPrecio_oro());
        }
    }

    //FUNCION DE COBRO DE IMPUESTOS
    public void cobrarImpuestos(ArrayList<Personaje> personajes, Ciudad ciudad) {
        Iterator<Personaje> iterator = personajes.iterator();

        while (iterator.hasNext()) {
            Personaje p = iterator.next();

            //Si el personaje no es de la ciudad que le pasamos a la funcion, pasamos al siguiente
            if (p.getCiudad() == null || !p.getCiudad().getId().equals(ciudad.getId())) {
                continue;
            }

            p.setOro(p.getOro() - 20);

            if (p.getOro() < 0) {
                personajeDAO.restarOroPersonaje(0, p);
                personajeDAO.desterrarPersonaje(p);
                iterator.remove();
                Log.info("Personaje desterrado: " + p.getNombre() + " no pudo pagar impuestos y ha sido desterrado.");
                System.out.println(p.getNombre() + " ha sido desterrado por no pagar impuestos");
            } else {
                personajeDAO.restarOroPersonaje(p.getOro(), p);
                Log.info("Impuesto cobrado: " + p.getNombre() + " ha pagado 20 de oro. Le quedan " + p.getOro());
                System.out.println(p.getNombre() + " ha pagado 20 de oro. Le quedan " + p.getOro());
            }
        }
    }
}