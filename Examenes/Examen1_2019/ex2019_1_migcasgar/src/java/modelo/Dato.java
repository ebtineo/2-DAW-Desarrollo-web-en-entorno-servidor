package modelo;

/**
 *
 * @author WorKeLid
 */
public class Dato {
    String etiqueta;
    Integer valor;
    
    public Dato(String etiqueta, Integer valor) {
        this.etiqueta = etiqueta;
        this.valor = valor;
    }
    
    public String getEtiqueta() {
        return this.etiqueta;
    }
    public Integer getValor() {
        return this.valor;
    }
}
