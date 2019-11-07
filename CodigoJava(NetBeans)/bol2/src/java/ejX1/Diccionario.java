package ejX1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WorKeLid
 */
public class Diccionario {
    
    public String buscar(String str) {
        String res = "-1";
        Connection con = conectar();
        PreparedStatement busqueda;
        try {
            busqueda = con.prepareStatement("select definicion from diccionario where termino=?");
            busqueda.setString(1, str);
            ResultSet rs = busqueda.executeQuery();
            if (rs.next()) {
                res = rs.getString("definicion");
            } else {
                res = "E: No encontrado";
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
    
    public void insertar(String term, String def) {
        Connection con = conectar();
        PreparedStatement insert;
        try {
            insert = con.prepareStatement("insert into diccionario values (?, ?)");
            insert.setString(1, term);
            insert.setString(2, def);
            
            insert.execute();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection conectar() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            return DriverManager.getConnection("jbdc:mysql://localhost:3306/diccionario", "root", "1108862");
        } catch (SQLException e) {
            return null;
        }
    } 
}
