
package minichat;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author jose
 */
public class MiniChatServer {

    public final static int PUERTO = 2000;
    
    private List<ConexionCliente> conexiones;

    public static void main(String[] args) {
        new MiniChatServer();
    }

    public MiniChatServer() {
        // Socket de servidor para atender peticiones de clientes
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PUERTO);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("MiniChatServer: Atendiendo peticiones de conexión en el puerto " + PUERTO);

        conexiones = new LinkedList();
        // Socket para conectarse al cliente
        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                ConexionCliente conexion = new ConexionCliente(clientSocket);
                conexiones.add(conexion);
                conexion.start();
                System.out.println("Aceptando conexión desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    /**
     * Envía un mensaje a todos los clientes
     * @param mensaje El mensaje a enviar
     */
    public synchronized void notificarATodos(String mensaje) {
        // Recorremos todos los subprocesos de clientes
        for (ConexionCliente conexion : conexiones) {
            try {
                // Y enviamos el mensaje
                conexion.getSalida().println(mensaje);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Subproceso de cliente
     */
    public class ConexionCliente extends Thread {

        private Socket socket;
        private PrintWriter salida;
        private BufferedReader entrada;

        public ConexionCliente (Socket clientSocket) throws IOException {
            socket = clientSocket;
            salida = new PrintWriter(socket.getOutputStream(),true);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            String mensaje;
            try {
                // Mientras la secuencia de recepción permanezca abierta..
                while ((mensaje=entrada.readLine()) != null) {
                    // Si el mensaje recibido es "salir"
                    if (mensaje.compareToIgnoreCase("salir") == 0) {
                        // Cerramos la conexión del cliente
                        entrada.close();
                        salida.close();
                        socket.close();
                        // Y la quitamos de la lista
                        conexiones.remove(this);
                        System.out.println(socket.getInetAddress() + " saliendo.");
                        return;
                    }
                    else {
                        // Enviamos el mensaje a todos los clientes
                        notificarATodos(mensaje);
                    }
                }
                // Quitamos el cliente de la lista
                conexiones.remove(this);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        // Devuelve la secuencia de salida para éste cliente
        public PrintWriter getSalida() {
            return salida;
        }

    }
}
