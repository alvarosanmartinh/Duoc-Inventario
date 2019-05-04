package cl.duoc.inventario.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alvaro San Martín
 */
public class Usuario implements Serializable, Comparable<Usuario>{
    
    private Integer id;
    private String userName;
    
    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String nombre, String userName, String clave) {
        this.id = id;
        this.userName = userName;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public Usuario clave(String clave) {
        this.clave = clave;
        return this;
    }
    
    public Usuario userName(String userName) {
        this.userName = userName;
        return this;
    }
    
    public Usuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Usuario id(Integer id) {
        this.id = id;
        return this;
    }
        
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    public boolean hasNombre() {
        return nombre != null && !"".equals(nombre.trim());
    }
    
    public boolean hasUserName() {
        return userName != null && !"".equals(userName.trim());
    }
    
    public boolean hasClave() {
        return clave != null && !"".equals(clave.trim());
    }

    @Override
    public int compareTo(Usuario o) {
        return this.id.compareTo(o.getId());
    }
}
