/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ghost_home
 */
@Entity
@Table(name = "producto", catalog = "inventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producto.findByFechaCreacion", query = "SELECT p FROM Producto p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto.findByModelo", query = "SELECT p FROM Producto p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Producto.findByMedida", query = "SELECT p FROM Producto p WHERE p.medida = :medida")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByValor", query = "SELECT p FROM Producto p WHERE p.valor = :valor")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.categoria = :categoria")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private int codigo;
    @Basic(optional = false)
    @Column(name = "fechaCreacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "medida", nullable = false, length = 20)
    private String medida;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false)
    private int valor;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 90)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "categoria", nullable = false)
    private int categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Detalleventa> detalleventaCollection;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, int codigo, Date fechaCreacion, String marca, String modelo, String tipo, String medida, String descripcion, int cantidad, int valor, String nombre, int categoria) {
        this.id = id;
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.medida = medida;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<Detalleventa> getDetalleventaCollection() {
        return detalleventaCollection;
    }

    public void setDetalleventaCollection(Collection<Detalleventa> detalleventaCollection) {
        this.detalleventaCollection = detalleventaCollection;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.inventario.entities.Producto[ id=" + id + " ]";
    }
    
}
