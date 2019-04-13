/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.DTO;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Alvaro
 */
@Data
public class UsuarioDTO implements Serializable {

    private Long idUsuario;
    private String username;
    private String clave;
    private int nivelUsuario;
    
    public UsuarioDTO withIdUsuario(Long idUsuario){
        this.setIdUsuario(idUsuario);
        return this;
    }
    
    public UsuarioDTO withUsername(String username){
        this.setUsername(username);
        return this;
    }
    
    public UsuarioDTO withClave(String clave){
        this.setClave(clave);
        return this;
    }
    
    public UsuarioDTO withNivelUsuario(int nivelUsuario){
        this.setNivelUsuario(nivelUsuario);
        return this;
    }
}
