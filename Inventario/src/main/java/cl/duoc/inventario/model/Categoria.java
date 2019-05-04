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
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private String eliminado;
    private List<Subcategoria> subcategoriaList;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String nombre, String descripcion, String eliminado) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public List<Subcategoria> getSubcategoriaList() {
        return subcategoriaList;
    }

    public void setSubcategoriaList(List<Subcategoria> subcategoriaList) {
        this.subcategoriaList = subcategoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    
}
