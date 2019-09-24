/*
 * Bean Dato.
 * Representa un dato de temperatura.
 */
package beans;

import java.util.Date;

/**
 *
 * @author jose
 */
public class Dato implements java.io.Serializable {
    private double temperatura;
    private double humedad;
    private Date fechaYHora;
    private String comentario;

    /**
     * @return the temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * @return the humedad
     */
    public double getHumedad() {
        return humedad;
    }

    /**
     * @param humedad the humedad to set
     */
    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    /**
     * @return the fechaYHora
     */
    public Date getFechaYHora() {
        return fechaYHora;
    }

    /**
     * @param fechaYHora the fechaYHora to set
     */
    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
}
