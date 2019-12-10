/*
 * Clase Diccionario
 * Modelo de Negocio
 */
package ejercicio9.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jose
 */
public class Diccionario {
    public String buscar(String termino) {
        String def;
        Connection conn = conectar();
        PreparedStatement busqueda;
        try {
            busqueda = conn.prepareStatement(
                    "select definicion from diccionario where termino=?");
            busqueda.setString(1, termino);
            ResultSet rs = busqueda.executeQuery();
            if (rs.next()) {
                def = rs.getString("definicion");
            } else {
                def = "E: El término no existe en el diccionario";
            }
            conn.close();
            return def;
        } catch (SQLException ex) {
            System.err.println("Error al crear la consulta");
            return null;
        }
        
    }
    
    public boolean insertar(String termino, String definicion) {
        boolean insertado = false;
        Connection conn = conectar();
        PreparedStatement insert;
        try {
             insert = conn.prepareStatement(
                    "insert into diccionario values (?, ?)");
            insert.setString(1, termino);
            insert.setString(2, definicion);
            insert.execute();
            insertado = true;
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Error al crear al insertar:" + ex.getMessage());
        }     
        return insertado;
    }
    
    public Connection conectar() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.err.println("Error al cargar el driver:" + e.getMessage());
        }
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/diccionario", "root", "root");
        } catch (SQLException ex) {
            System.err.println("Error en la conexión a la BD:" + ex.getMessage());
            return null;
        }
    }
    
}
