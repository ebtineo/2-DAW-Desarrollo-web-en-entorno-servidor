
package minichat;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author jose
 */
public class MiniChatServer {

    private List<ConexionCliente> conexiones;

    public static void main(String[] args) {
        new MiniChatServer();
    }

    public MiniChatServer() {
        // Socket de servidor para atender peticiones de clientes
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2000);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("MiniChatServer: Atendiendo peticiones de conexión en el puerto 2000");

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

    public synchronized void notificarATodos(String mensaje) {
        for (ConexionCliente conexion : conexiones) {
            try {
                conexion.getSalida().println(mensaje);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

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
                while ((mensaje=entrada.readLine()) != null) {
                    if (mensaje.compareToIgnoreCase("salir") == 0) {
                        entrada.close();
                        salida.close();
                        socket.close();
                        conexiones.remove(this);
                        System.out.println(socket.getInetAddress() + " saliendo.");
                        return;
                    }
                    else {
                        notificarATodos(mensaje);
                    }
                }
                conexiones.remove(this);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }

        public PrintWriter getSalida() {
            return salida;
        }

    }
}
