/*
 * Clase Mensaje. Representa un mensaje enviado por un usuari externo a un empleado
 * Entidad JPA
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jose
 */
@Entity
public class Mensaje implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Empleado Empleado;
    private String texto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaYHora;
    private String ipUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Mensaje[ id=" + id + " ]: usuario " + usuario.getApellidos() + ", " + usuario.getNombre();
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Mensaje)) {
            return -1;
        }
        Mensaje otro = (Mensaje)o;
        return fechaYHora.compareTo(otro.fechaYHora);
    }
    
}
