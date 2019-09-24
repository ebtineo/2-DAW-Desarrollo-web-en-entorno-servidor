
package url;

import java.net.*;
import java.io.*;
/**
 *
 * @author jose
 */
public class EnviarParametros {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/Web/cabeceras.jsp");
        } catch (Exception e) {}
        URLConnection conexion;
        try {
            conexion = url.openConnection();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        //conexion.setRequestProperty("atributo", "valor");
        conexion.setDoOutput(true);
        conexion.setRequestProperty("METHOD", "POST");
        try {
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(conexion.getOutputStream()));
            //salida.newLine();
            //salida.newLine();
            String parametros = "val=televisor" /*"parametro=valor"*/;
            //salida.write("Content-Length : " + parametros.length() + "\n");
            salida.write(parametros);
            salida.close();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = null;
            while ((linea = entrada.readLine())!=null) {
                System.out.println(linea);
            }
            entrada.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
