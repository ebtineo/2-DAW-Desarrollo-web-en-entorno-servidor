/*
 * Clase Casilla
 * Representa una casilla del tablero de juego.
 */
package modelo;

/**
 *
 * @author jose
 */
public class Casilla {
    private int fila;
    private int columna;
    private boolean descubierta;
    private boolean regalo;
    
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        descubierta = false;
        regalo = false;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public boolean isRegalo() {
        return regalo;
    }

    public void setRegalo(boolean regalo) {
        this.regalo = regalo;
    }
    
    public String getImagen() {
        if (regalo /*&& descubierta*/) {
            return "img/regalo.png";
        } else {
            return "img/cielo.jpg";
        }
    }
}
