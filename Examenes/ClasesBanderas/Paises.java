/*
 * Class Paises
 * Permite consultar los paises y sus banderas
 */
package datos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author jose
 */
public class Paises {
    
    private List<Bandera> banderas;
    
    /**
     * Construye un objeto de tipo Paises a partir de las imágenes de las banderas
     * @param directorioBanderas El directorio donde se encuentran las imágenes de las banderas 
     */
    public Paises(String directorioBanderas) {
        File directorio = new File(directorioBanderas);
        File[] ficheros = directorio.listFiles();
        banderas = new ArrayList();
        for (File fichero:ficheros) {
            String codigoPais = fichero.getName().substring(0, 2);
            Locale localPais = new Locale("",codigoPais);
            String pais = localPais.getDisplayCountry();
            Bandera bandera = new Bandera();
            bandera.setPais(pais);
            String ruta = directorio.getName();
            bandera.setImagen(ruta + "/" + fichero.getName());
            banderas.add(bandera);
        }
    }
    
    /**
     * Consulta todas las banderas
     * @return Una lista con todas las banderas
     */
    public List<Bandera> getBanderas() {
        return banderas;
    }
    
    /**
     * Consulta los paises
     * @return Una lista con los nombres de todos los paises
     */
    public List<String> getPaises() {
        List<String> paises = new ArrayList();
        for (Bandera bandera:banderas) {
            paises.add(bandera.getPais());
        }
        return paises;
    }
}