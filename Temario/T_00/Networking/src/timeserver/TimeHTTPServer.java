
package timeserver;

import java.io.*;
import java.net.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author jose
 */
public class TimeHTTPServer {
    private static final int PUERTO = 8000;

    public static void main(String[] args) {
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PUERTO);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        while (true) {
            try {
                Socket conexion = socketServidor.accept();
                new ConexionCliente(conexion).start();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static class ConexionCliente extends Thread {
        private Socket conexion;

        public ConexionCliente(Socket c) {
            conexion = c;
        }

        @Override
        public void run() {
            try {
                //Leemos las cabeceras de la petición para buscar las preferencias de lenguaje
                String lenguaje = "";
                String region = "";
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String linea;
                while (!(linea = entrada.readLine()).equals("")) {
                    if (linea.startsWith("Accept-Language:")) {
                        linea = linea.substring(linea.indexOf(":")+2);
                        lenguaje = linea.substring(0, 2);
			if (linea.length() > 2 && linea.charAt(2) == '-') {
                            region = linea.substring(3);
                        }
                    }
                }
                // Creamos un PrintWriter sin la opción autoflush, para enviar todas las líneas en el mismo paquete
                PrintWriter salida = new PrintWriter(conexion.getOutputStream(),false);
                // Creamos un formato de fecha y hora apropiado al lenguaje del cliente
                DateFormat formatoFecha = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM,new Locale(lenguaje,region));

                // enviamos el contenido al cliente
                salida.println("HTTP/1.1 200 OK");
                salida.println("Content-Type: text/html; charset=UTF-8");
                salida.println("");
                salida.println("<HTML>");
                salida.println("<HEAD>");
                salida.println("<META HTTP-EQUIV='REFRESH' CONTENT='1'>");
                //salida.println("<TITTLE>Fecha y Hora</TITTLE>");
                salida.println("</HEAD>");
                salida.println("<BODY style='background-color: #BFBFBF;'>");
                salida.println("<h1>");
                salida.println("<div style='text-align: center; color: #A52A2A; font-family: arial, helvetica, sans-serif; '>");
                salida.println("<br><br>");
                salida.println(formatoFecha.format(new Date()));
                salida.println("</div>");
                salida.println("</h1>");
                salida.println("</BODY>");
                salida.println("</HTML>");
                salida.close();
                conexion.close();

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
