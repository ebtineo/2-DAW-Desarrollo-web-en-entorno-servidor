/*
 * Clase Partida
 * Representa el estado de la partida
 */
package modelo;

/**
 *
 * @author jose
 */
public class Partida {
    private Casilla[][] tablero;
    private int filaSantaClaus;
    private int columnaSantaClaus;
    private int intentos;
    
    
    public Partida() {
        this(6,8);
    }
    
    public Partida(int filas, int columnas) {
        tablero = new Casilla[filas][columnas];
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[0].length; columna++) {
                tablero[fila][columna] = new Casilla(fila, columna);
            }
        }
        intentos = 0;
        // Santa siempre sale de la izquierda
        columnaSantaClaus = 0;
        filaSantaClaus = (int)(Math.random() * tablero.length);
    }
    
    /**
     * Descubre una casilla del tablero y actualiza la posición de Santa Claus
     * @return true si la Santa Claus está en la casilla
     */
    public boolean descubrir(int fila, int columna) {
        intentos++;
        if (fila == filaSantaClaus && columna == columnaSantaClaus) {
            return true;
        } else {
            tablero[fila][columna].setDescubierta(true);
            // Marcamos que Santa Claus ha dejado un regalo en la casilla que ocupaba
            tablero[filaSantaClaus][columnaSantaClaus].setRegalo(true);
            // Y lo hacemos avanzar
            columnaSantaClaus++;
            if (filaSantaClaus == 0 || filaSantaClaus == tablero.length-1) {
                int aleatorio = (int)(Math.random() * 2);
                if (filaSantaClaus == 0) {
                    filaSantaClaus += aleatorio;
                } else {
                    filaSantaClaus -= aleatorio;
                }
            } else {
                int aleatorio = (int)(Math.random() * 3) - 1;
                filaSantaClaus += aleatorio;
            }
            return false;
        }
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public int getFilaSantaClaus() {
        return filaSantaClaus;
    }

    public int getColumnaSantaClaus() {
        return columnaSantaClaus;
    }

    public int getIntentos() {
        return intentos;
    }
    
    public int getMaximoIntentos() {
        return tablero[0].length;
    }
}
