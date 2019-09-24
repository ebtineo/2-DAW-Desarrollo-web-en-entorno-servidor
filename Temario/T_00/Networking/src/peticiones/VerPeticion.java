
package peticiones;

import java.net.*;
import java.io.*;


/**
 *
 * @author jose
 */
public class VerPeticion {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(8000);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("");
        while (true) {
            Socket cliente = null;
            try {
                cliente = servidor.accept();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            Subproceso s = new Subproceso(cliente);
            s.start();
        }
    }

    private static class Subproceso extends Thread {
        private Socket conexion;

        public Subproceso(Socket conexion) {
            this.conexion = conexion;
        }

        @Override
        public void run() {
            try {
                int longitudDatos = 0;
                BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                PrintWriter salida = new PrintWriter(conexion.getOutputStream(),true);
                String linea;
                while (!(linea=entrada.readLine()).equals("")) {
                        salida.println(linea);
                        System.out.println(linea);
                        if (linea.indexOf("Content-Length")!=-1) {
                            try {
                                longitudDatos = Integer.parseInt(linea.substring(linea.indexOf(":")+2));
                            }
                            catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        }
                }
                int c=' ';
                for(int i=0;i<longitudDatos;i++) {
                    c=entrada.read();
                    salida.write(c);
                    System.out.print((char)c);
                }
                salida.flush();
                System.out.println();

                System.out.println("El cliente ha cerrado la conexion");
                salida.close();
                conexion.close();
                System.out.println(longitudDatos + " bytes de datos");
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
