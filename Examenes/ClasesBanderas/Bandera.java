/*
 * Clase Bandera
 * Contiene información sobre una bandera y el país al que pertenece
 */
package datos;

/**
 *
 * @author jose
 */
public class Bandera {
    
    private String pais;
    private String imagen;

    /**
     * Consulta el país al que pertenece al bandera
     * @return El nombre del país
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país al que pertenece la bandera
     * @param pais El nombre del país 
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Consulta la imagen de la bandera
     * @return La url de la imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la imagen de la bandera
     * @param imagen La url de la imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
