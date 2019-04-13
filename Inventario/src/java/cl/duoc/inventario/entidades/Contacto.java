/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Alvaro
 */
@Entity
@Table(name = "Contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT u FROM Contacto u")
    , @NamedQuery(name = "Contacto.findById", query = "SELECT u FROM Contacto u WHERE u.idContacto = :id")
})
@Data
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idContacto;
    @NotNull
    private String nombre;
    private String apellido;
    @NotNull
    private String email;
    @NotNull
    private String asunto;
    @NotNull
    private String mensaje;
    
    
    public Contacto withIdContacto(Long idContacto){
        this.setIdContacto(idContacto);
        return this;
    }
    
    public Contacto withNombre(String nombre){
        this.setNombre(nombre);
        return this;
    }
    
    public Contacto withApellido(String apellido){
        this.setApellido(apellido);
        return this;
    }
    
    public Contacto withEmail(String email){
        this.setEmail(email);
        return this;
    }
    
    public Contacto withAsunto(String asunto){
        this.setAsunto(asunto);
        return this;
    }
    
    public Contacto withMensaje(String mensaje){
        this.setMensaje(mensaje);
        return this;
    }
    
}
