/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.conversores;

import cl.duoc.inventario.DTO.UsuarioDTO;
import cl.duoc.inventario.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public abstract class ConversorUsuario {
    
    public static UsuarioDTO convertirEntidad(Usuario usuario){
        if(null==usuario)
            return null;
        UsuarioDTO result = new UsuarioDTO();
        return result.withIdUsuario(usuario.getIdUsuario()).withUsername(usuario.getUsername()).withClave(usuario.getClave()).withNivelUsuario(usuario.getNivelUsuario());
    }
    
    public static List<UsuarioDTO> convertirEntidad(List<Usuario> usuarios){
        if(null==usuarios)
            return null;
        List<UsuarioDTO> result = new ArrayList<>();
        for(Usuario usuario : usuarios){
            result.add(convertirEntidad(usuario));
        }
        return result;
    }
    
    public static Usuario convertirDTO(UsuarioDTO usuario){
        if(null==usuario)
            return null;
        Usuario result = new Usuario();
        return result.withIdUsuario(usuario.getIdUsuario()).withUsername(usuario.getUsername()).withClave(usuario.getClave()).withNivelUsuario(usuario.getNivelUsuario());
    }
    
    public static List<Usuario> convertirDTO(List<UsuarioDTO> usuarios){
        if(null==usuarios)
            return null;
        List<Usuario> result = new ArrayList<>();
        for(UsuarioDTO usuario : usuarios){
            result.add(convertirDTO(usuario));
        }
        return result;
    }
    
}
