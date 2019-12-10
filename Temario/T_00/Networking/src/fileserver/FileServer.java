/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fileserver;

import java.net.*;
import java.io.*;

/**
 *
 * @author jose
 */
public class FileServer {
    public static void main(String[] args) {
                ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(2222);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("FileServer: Atendiendo peticiones de conexión en el puerto 2222");

        // Socket para conectarse al cliente
        Socket clientSocket = null;
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                ConexionCliente conexion = new ConexionCliente(clientSocket);
                conexion.start();
                System.out.println("Aceptando conexión desde " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public static class ConexionCliente extends Thread {
        private Socket socket;

        public ConexionCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            BufferedReader entrada;
            OutputStream salida;
            try {
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = socket.getOutputStream();
                File fichero = new File(entrada.readLine());
                System.out.println("Transfiriendo :" + fichero.getAbsolutePath());
                FileInputStream entradaFichero = new FileInputStream(fichero);
                int dato;
                while ((dato = entradaFichero.read())!=-1)
                    salida.write(dato);
                entradaFichero.close();
                salida.close();
                entrada.close();
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                try {
                    socket.close();
                } catch (IOException ex) {}
            }
        }

    }
}
