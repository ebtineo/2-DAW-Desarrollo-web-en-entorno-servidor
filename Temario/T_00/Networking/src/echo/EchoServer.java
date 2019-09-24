
package echo;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author jose
 */

public class EchoServer {

    public static void main(String[] args) {
        // Conectamos el servicio al puerto 4000
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(4000);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        // Aceptamos conexiones
        while (true) {
            try {
                Socket conexion = socketServidor.accept();
                // Creamos un nuevo subproceso para cada conexion de cliente
                new ConexionCliente(conexion).start();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static class ConexionCliente extends Thread {
        private Socket conexion;

        public ConexionCliente(Socket s) {
            conexion = s;
        }

        @Override
        public void run() {
            try {
                // Obtenemos las secuencias de entrada y salida de la conexion
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                PrintWriter salida = new PrintWriter(conexion.getOutputStream(),true);
                // Mientras la entrada de la conexion permanezca abierta
                // Leemos mensaje y lo retransmitimos
                String linea;
                while ((linea = entrada.readLine()) != null) {
                    salida.println(linea);
                    System.out.println(linea);
                }
                // Cerramos la conexion
                conexion.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
