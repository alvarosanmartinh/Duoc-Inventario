/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.model;

import cl.duoc.inventario.entities.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alvaro
 */

public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDetVenta;
    private int cantidad;
    private int total;
    private Venta venta;
    private Producto codigoProducto;

    public Detalleventa() {
    }

    public Detalleventa(Integer idDetVenta) {
        this.idDetVenta = idDetVenta;
    }

    public Detalleventa(Integer idDetVenta, int cantidad, int total) {
        this.idDetVenta = idDetVenta;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getIdDetVenta() {
        return idDetVenta;
    }

    public void setIdDetVenta(Integer idDetVenta) {
        this.idDetVenta = idDetVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Producto codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetVenta != null ? idDetVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.idDetVenta == null && other.idDetVenta != null) || (this.idDetVenta != null && !this.idDetVenta.equals(other.idDetVenta))) {
            return false;
        }
        return true;
    }

    
}
