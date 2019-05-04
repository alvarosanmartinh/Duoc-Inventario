/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.model;

import cl.duoc.inventario.entities.*;
import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "producto", catalog = "inventario", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producto.findByAnho", query = "SELECT p FROM Producto p WHERE p.anho = :anho")
    , @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto.findByModelo", query = "SELECT p FROM Producto p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Producto.findByTipo", query = "SELECT p FROM Producto p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Producto.findByMedida", query = "SELECT p FROM Producto p WHERE p.medida = :medida")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByValor", query = "SELECT p FROM Producto p WHERE p.valor = :valor")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado")
    , @NamedQuery(name = "Producto.findByStockAdmin", query = "SELECT p FROM Producto p WHERE p.stockAdmin = :stockAdmin")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "Anho")
    private int anho;
    @Basic(optional = false)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "Medida")
    private String medida;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "Valor")
    private int valor;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "StockAdmin")
    private int stockAdmin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private Subcategoria subcategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProducto", fetch = FetchType.LAZY)
    private List<Detalleventa> detalleventaList;
    @JoinColumn(name = "SubCategoria", referencedColumnName = "IdSubCategoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subcategoria subCategoria;
    @JoinColumn(name = "Proveedor", referencedColumnName = "IdProveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor proveedor;

    public Producto() {
    }

    public Producto(Integer codigo) {
        this.codigo = codigo;
    }

    public Producto(Integer codigo, int anho, String marca, String modelo, String tipo, String medida, String descripcion, int cantidad, int valor, String nombre, String estado, int stockAdmin) {
        this.codigo = codigo;
        this.anho = anho;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.medida = medida;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.nombre = nombre;
        this.estado = estado;
        this.stockAdmin = stockAdmin;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStockAdmin() {
        return stockAdmin;
    }

    public void setStockAdmin(int stockAdmin) {
        this.stockAdmin = stockAdmin;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    @XmlTransient
    public List<Detalleventa> getDetalleventaList() {
        return detalleventaList;
    }

    public void setDetalleventaList(List<Detalleventa> detalleventaList) {
        this.detalleventaList = detalleventaList;
    }

    public Subcategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Subcategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.duoc.inventario.entities.Producto[ codigo=" + codigo + " ]";
    }
    
}
