/*
 * Clase Validacion
 * Permite validar usuarios mediante login y password
 */
package ejercicio10.modelo;

import ejercicio9.modelo.Diccionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Validacion {
    public Usuario validar(String login, String password) {
        Usuario u = null;
        Diccionario d = new Diccionario();
        Connection con = d.conectar();
        try {
            PreparedStatement consulta = con.prepareStatement(
                    "select * from usuarios where binary login = ?");
            consulta.setString(1, login);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    u = new Usuario(rs.getString("nombreCompleto"));
                }
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error al consultar usuarios: " + ex.getMessage());
        }
        
        return u;
    }
    
}
