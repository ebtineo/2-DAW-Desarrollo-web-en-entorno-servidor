
package fileserver_v1;

import fileserver.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author jose
 */
public class FileServerV1 {
    // Puerto del servidor
    public final static int PUERTO = 2223;

    public static void main(String[] args) {
                ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PUERTO);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("FileServer: Atendiendo peticiones de conexión en el puerto " + PUERTO);

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
            // entrada de texto de la conexión
            BufferedReader entrada;
            // salida binaria de la conexión
            OutputStream salida;
            // salida de texto de la conexión
            PrintWriter salidaTexto;
            try {
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                salida = socket.getOutputStream();
                salidaTexto = new PrintWriter(salida,true);
                File fichero = new File(entrada.readLine());
                System.out.println("Transfiriendo :" + fichero.getAbsolutePath());
                FileInputStream entradaFichero = new FileInputStream(fichero);
                // Primero enviamos una linea de texto con la longitud del fichero en bytes
                salidaTexto.println(fichero.length());
                byte[] dato = new byte[4096];
                int numBytes;
                // Y enviamos su contenido byte a byte
                while ((numBytes = entradaFichero.read(dato))>0)
                    salida.write(dato,0,numBytes);
                entradaFichero.close();
                salida.close();
                entrada.close();
                //socket.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                try {
                    socket.close();
                } catch (IOException ex) {}
            }
        }

    }
}
