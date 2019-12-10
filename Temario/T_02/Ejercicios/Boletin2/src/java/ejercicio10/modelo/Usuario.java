/*
 * Clase Usuario
 */
package ejercicio10.modelo;

/**
 *
 * @author jose
 */
public class Usuario {
    private String nombreCompleto;

    public Usuario(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return nombreCompleto;
    }
    
}
