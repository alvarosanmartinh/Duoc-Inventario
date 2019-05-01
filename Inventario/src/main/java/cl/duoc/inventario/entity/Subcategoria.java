/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ghost-pc
 */
@Entity
@Table(name = "subcategoria", catalog = "inventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategoria.findAll", query = "SELECT s FROM Subcategoria s"),
    @NamedQuery(name = "Subcategoria.findByIdSubCategoria", query = "SELECT s FROM Subcategoria s WHERE s.idSubCategoria = :idSubCategoria"),
    @NamedQuery(name = "Subcategoria.findByNombre", query = "SELECT s FROM Subcategoria s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Subcategoria.findByDescripcion", query = "SELECT s FROM Subcategoria s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Subcategoria.findByEliminado", query = "SELECT s FROM Subcategoria s WHERE s.eliminado = :eliminado")})
public class Subcategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdSubCategoria")
    private Integer idSubCategoria;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Eliminado")
    private String eliminado;
    @JoinColumn(name = "IdSubCategoria", referencedColumnName = "SubCategoria", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "Categoria", referencedColumnName = "IdCategoria")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoria")
    private Collection<Productos> productosCollection;

    public Subcategoria() {
    }

    public Subcategoria(Integer idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public Subcategoria(Integer idSubCategoria, String nombre, String descripcion, String eliminado) {
        this.idSubCategoria = idSubCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public Integer getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(Integer idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
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

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubCategoria != null ? idSubCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategoria)) {
            return false;
        }
        Subcategoria other = (Subcategoria) object;
        if ((this.idSubCategoria == null && other.idSubCategoria != null) || (this.idSubCategoria != null && !this.idSubCategoria.equals(other.idSubCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.inventario.entity.Subcategoria[ idSubCategoria=" + idSubCategoria + " ]";
    }
    
}
