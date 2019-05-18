/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
    
    private Integer id;
    
    
    
    private Date fecha;
    
    
    private String eliminado;
    
    
    private Usuario rutCliente;
    
    private Collection<Detalleventa> detalleventaCollection;

    public Venta() {
    }

    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, Date fecha, String eliminado) {
        this.id = id;
        this.fecha = fecha;
        this.eliminado = eliminado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    public Usuario getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Usuario rutCliente) {
        this.rutCliente = rutCliente;
    }

    
    public Collection<Detalleventa> getDetalleventaCollection() {
        return detalleventaCollection;
    }

    public void setDetalleventaCollection(Collection<Detalleventa> detalleventaCollection) {
        this.detalleventaCollection = detalleventaCollection;
    }

    
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", eliminado=" + eliminado + ", rutCliente=" + rutCliente + ", detalleventaCollection=" + detalleventaCollection + '}';
    }

    
    
}
