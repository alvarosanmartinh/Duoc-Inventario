package cl.duoc.inventario.util;

import cl.duoc.inventario.DAO.UsuarioFacade;
import cl.duoc.inventario.model.Contacto;
import cl.duoc.inventario.model.Producto;
import cl.duoc.inventario.model.Usuario;
import com.github.javafaker.Faker;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

/**
 *
 * @author Alvaro San Martín
 */
public class Utils implements Serializable {

    public static void addDetailMessage(String message){
       addDetailMessage(message, null);
    }
    
    public static void main(String[] args){
        UsuarioFacade u = new UsuarioFacade();
        int count = u.findAll().size();
        System.out.println("usuarios: "+count);
               
    }

    public static void addDetailMessage(String message, FacesMessage.Severity severity){

        FacesMessage facesMessage = Messages.create("").detail(message).get();
        if(severity != null && severity != FacesMessage.SEVERITY_INFO) {
            facesMessage.setSeverity(severity);
        } else{
            Messages.add(null,facesMessage);
        }
    }
    
}
