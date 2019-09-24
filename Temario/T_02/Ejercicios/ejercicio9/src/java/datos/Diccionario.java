/*
 * Clase Diccionario
 */
package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jose
 */
public class Diccionario {
    private Map<String,String> diccionario = new HashMap();
    
    public Diccionario() throws FileNotFoundException, IOException, ClassNotFoundException {
        //diccionario.put("gato", "cat");
        //diccionario.put("perro", "dog");
        File fichero = new File("diccionario.dat");
        // Creamos le fichero
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        //oos.writeObject(diccionario);
        //oos.close();
        // Cargamos el diccionario
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
        diccionario = (Map)ois.readObject();
        ois.close();
    }
    
    public String buscar(String palabra) {
        return diccionario.get(palabra.toLowerCase());
    }
}
