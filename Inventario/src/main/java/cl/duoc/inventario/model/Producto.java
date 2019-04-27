package cl.duoc.inventario.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Alvaro San Martín
 */
public class Producto implements Serializable, Comparable<Producto>{
    
    private Integer id;
    private String nombre;
    private Double precio;

    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto() {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public Producto precio(Double precio) {
        this.precio = precio;
        return this;
    }
    
    
    public Producto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Producto id(Integer id) {
        this.id = id;
        return this;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    public boolean hasNombre() {
        return nombre != null && !"".equals(nombre.trim());
    }
    
    public boolean hasPrecio() {
        return precio != null;
    }

    @Override
    public int compareTo(Producto o) {
        return this.id.compareTo(o.getId());
    }
}