/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.conversores;

import cl.duoc.inventario.DTO.ContactoDTO;
import cl.duoc.inventario.entidades.Contacto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public abstract class ConversorContacto {
    
    public static ContactoDTO convertirEntidad(Contacto contacto){
        ContactoDTO result = new ContactoDTO();
        return result.withIdContacto(contacto.getIdContacto()).withAsunto(contacto.getAsunto()).withEmail(contacto.getEmail()).withMensaje(contacto.getMensaje()).withNombre(contacto.getNombre()).withApellido(contacto.getApellido());
    }
    
    public static List<ContactoDTO> convertirEntidad(List<Contacto> contactos){
        List<ContactoDTO> result = new ArrayList<>();
        for(Contacto contacto : contactos){
            result.add(convertirEntidad(contacto));
        }
        return result;
    }
    
    public static Contacto convertirDTO(ContactoDTO contacto){
        Contacto result = new Contacto();
        return result.withIdContacto(contacto.getIdContacto()).withAsunto(contacto.getAsunto()).withEmail(contacto.getEmail()).withMensaje(contacto.getMensaje()).withNombre(contacto.getNombre()).withApellido(contacto.getApellido());
    }
    
    public static List<Contacto> convertirDTO(List<ContactoDTO> contactos){
        List<Contacto> result = new ArrayList<>();
        for(ContactoDTO contacto : contactos){
            result.add(convertirDTO(contacto));
        }
        return result;
    }
    
}
