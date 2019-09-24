/*
 * Clase Jugadores
 * Proporciona métodos para acceder a los datos de jugadores y para actualizarlos
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Jugadores {
    public static Connection conectarBD() {
        Connection conexion = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/juego_banderas", "juego_banderas", "juego_banderas");
        } catch (SQLException e) {
            System.err.println("Error en la conexión a la BD");
        }
        return conexion;
    }
    
    public static void desconectarBD(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error en la desconexión de la BD");
            }
        }
    }
    
    public static void insertar(Jugador j) {
        Connection conexion = conectarBD();
        try {
            PreparedStatement insertar = conexion.prepareStatement("insert into jugadores values (?,?,?)");
            insertar.setString(1, j.getNombre());
            insertar.setDouble(2, j.getPuntos());
            insertar.setInt(3, j.getPartidas());
            insertar.execute();
        } catch (SQLException e) {
            System.err.println("Error al insertar jugador en la BD: " + e.getMessage());
        } finally {
            desconectarBD(conexion);
        }
    }
    
    public static void sumarPuntos(Jugador j, double puntos) {
        Connection conexion = conectarBD();
        try {
            PreparedStatement sumar = conexion.prepareStatement("update jugadores set puntos = puntos + ?, partidas = partidas + 1 where nombre=?");
            sumar.setDouble(1, puntos);
            sumar.setString(2, j.getNombre());
            sumar.execute();
        } catch (SQLException e) {
            System.err.println("Error al actualizar puntos en la BD: " + e.getMessage());
        } finally {
            desconectarBD(conexion);
        }
    }
    
    public static List<Jugador> getJugadores() {
        List<Jugador> jugadores = new LinkedList();
        Connection conexion = conectarBD();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet resultado = consulta.executeQuery("select * from jugadores");
            while (resultado.next()) {
                Jugador j = new Jugador(resultado.getString("nombre"), resultado.getDouble("puntos"), resultado.getInt("partidas"));
                jugadores.add(j);
            }   
        } catch (SQLException e) {
            System.err.println("Error al actualizar puntos en la BD: " + e.getMessage());
        }
        desconectarBD(conexion);
        // Ordenamos los jugadores por la puntuación media de mayor a menor
        Collections.sort(jugadores, (j1,j2) -> -((Double)(j1.getMedia())).compareTo(j2.getMedia()));
        return jugadores;
    }
    
    public static Jugador buscar(String nombre) {
        Jugador j = null;
        Connection conexion = conectarBD();
        try {
            PreparedStatement buscar = conexion.prepareStatement("select * from jugadores where nombre=?");
            buscar.setString(1, nombre);
            ResultSet resultado = buscar.executeQuery();
            if (resultado.next()) {
                j = new Jugador(resultado.getString("nombre"), resultado.getDouble("puntos"), resultado.getInt("partidas"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar jugador en la BD: " + e.getMessage());
        } finally {
            desconectarBD(conexion);
        }        
        return j;
    }
}
