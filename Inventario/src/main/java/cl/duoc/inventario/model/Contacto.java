/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alvaro
 */
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String email;
    private String nombre;
    private String telefono;
    private String motivo;
    private String requerimiento;
    private List<Usuario> usuarioList;

    public Contacto() {
    }

    public Contacto(String email) {
        this.email = email;
    }

    public Contacto(String email, String nombre, String telefono, String motivo, String requerimiento) {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.motivo = motivo;
        this.requerimiento = requerimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(String requerimiento) {
        this.requerimiento = requerimiento;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }
    
}
