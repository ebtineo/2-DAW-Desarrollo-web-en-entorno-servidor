/*
 * Clase Jugador
 * Contiene los datos de un jugador y los métodos para acceder a ellos
 */
package datos;

/**
 *
 * @author jose
 */
public class Jugador {
    private String nombre;
    private double puntos;
    private int partidas;
    
    public Jugador() {
        this("", 0.0, 0);
    }
    
    public Jugador(String nombre, double puntos, int partidas) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.partidas = partidas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public int getPartidas() {
        return partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }
    
    public double getMedia() {
        return Math.round(10 * puntos / partidas) / 10.0;
    }
    
    @Override
    public String toString() {
        return nombre + "\t" + puntos + "\t" + partidas + "\t" + getMedia();
    }
}
