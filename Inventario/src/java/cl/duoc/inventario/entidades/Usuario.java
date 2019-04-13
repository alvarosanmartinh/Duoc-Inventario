/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.entidades;

import cl.duoc.inventario.DTO.UsuarioDTO;
import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :id")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByUsernameAndClave", query = "SELECT u FROM Usuario u WHERE u.username = :username AND u.clave = :clave")
})
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = false, nullable = false)
    private String clave;
    @Column(unique = false, nullable = false)
    private int nivelUsuario;

    public Usuario withIdUsuario(Long idUsuario) {
        this.setIdUsuario(idUsuario);
        return this;
    }

    public Usuario withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    public Usuario withClave(String clave) {
        this.setClave(clave);
        return this;
    }

    public Usuario withNivelUsuario(int nivelUsuario) {
        this.setNivelUsuario(nivelUsuario);
        return this;
    }

}
