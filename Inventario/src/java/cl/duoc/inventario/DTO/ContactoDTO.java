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
public class ContactoDTO implements Serializable {

    private Long idContacto;
    private String nombre;
    private String apellido;
    private String email;
    private String asunto;
    private String mensaje;
    
    public ContactoDTO withIdContacto(Long idContacto){
        this.setIdContacto(idContacto);
        return this;
    }
    
    public ContactoDTO withNombre(String nombre){
        this.setNombre(nombre);
        return this;
    }
    
    public ContactoDTO withApellido(String apellido){
        this.setApellido(apellido);
        return this;
    }
    
    public ContactoDTO withEmail(String email){
        this.setEmail(email);
        return this;
    }
    
    public ContactoDTO withAsunto(String asunto){
        this.setAsunto(asunto);
        return this;
    }
    
    public ContactoDTO withMensaje(String mensaje){
        this.setMensaje(mensaje);
        return this;
    }
}
