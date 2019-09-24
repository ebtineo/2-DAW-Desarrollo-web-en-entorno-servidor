/*
 * Clase Empleado. Representa a los empleados de la empresa.
 * Entidad JPA.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jose
 */
@Entity
public class Empleado implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10)
    private String dni;
    private String nombre;
    private String apellidos;
    @ManyToOne
    private Departamento departamento;
    @Column(unique = true)
    private String login;
    private String password;
    private String tipo;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleado[ id=" + id + " ]: " + apellidos + ", " + nombre;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Empleado)) {
            return -1;
        }
        Empleado otro = (Empleado)o;
        String apellidosNombre = apellidos.toLowerCase() + nombre.toLowerCase();
        String apellidosNombreOtro = otro.apellidos.toLowerCase() + otro.nombre.toLowerCase();
        return apellidosNombre.compareTo(apellidosNombreOtro);
    }
    
}
