package rpg.dao;

import rpg.model.Item;
import rpg.model.Personaje;
import rpg.model.Raza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsDAO {
    private ArrayList<Item> items;
    private ConexionDB conexionDB;

    public ItemsDAO(){
        this.conexionDB=new ConexionDB();
        this.items=new ArrayList<>();
        cargaItems();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ConexionDB getConexionDB() {
        return conexionDB;
    }

    public void setConexionDB(ConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public void cargaItems(){
        ResultSet resultset = conexionDB.executeQuery("SELECT * FROM Items");

        try {
            while (resultset.next()) {
                Integer id = resultset.getInt("id");
                String nombre = resultset.getString("nombre");
                String tipo = resultset.getString("tipo");
                Integer precio_oro = resultset.getInt("precio_oro");
                Integer bonificador_ataque = resultset.getInt("bonificador_ataque");
                Integer bonificador_defensa = resultset.getInt("bonificador_defensa");

                this.items.add(new Item(id, nombre,tipo,precio_oro, bonificador_ataque,bonificador_defensa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Item getItemById(int idPasado){
        for (Item item : items){
            if (item.getId().equals(idPasado)){
                return item;
            }
        }
        return null;
    }

    // En ItemsDAO
    public void cargaItemsEnPersonaje(Personaje personaje){
        try {
            ResultSet resultset = conexionDB.executeQuery(
                    "SELECT * FROM inventarios WHERE id_personaje = " + personaje.getId());

            while (resultset.next()) {
                Integer id_item = resultset.getInt("id_item");
                Integer cantidad = resultset.getInt("cantidad");
                Item item = getItemById(id_item);
                personaje.getInventario().put(item, cantidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}