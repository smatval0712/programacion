package rpg.dao;

import java.sql.*;

public class ConexionDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/XRPG";
    private static final String USER = "xrpg_user";
    private static final String PASSWORD = "xrpg_password";

    private Connection connection;

    // Constructor → abre la conexión UNA VEZ
    public ConexionDB() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD");
            e.printStackTrace();
        }
    }

//     Metodo para SELECT
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar query");
            e.printStackTrace();
            return null;
        }
    }

    // Metodo para INSERT, UPDATE, DELETE
    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error al ejecutar update");
            e.printStackTrace();
            return 0;
        }
    }

    // Cerrar conexión manualmente
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}