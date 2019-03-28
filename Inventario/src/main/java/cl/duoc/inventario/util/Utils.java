package cl.duoc.inventario.util;

import cl.duoc.inventario.model.Producto;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by rmpestano on 07/02/17.
 */
@ApplicationScoped
public class Utils implements Serializable {

    private List<Producto> productos;

    @PostConstruct
    public void init() {
        productos = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .forEach(i -> productos.add(crear(i)));
    }

     public static void addDetailMessage(String message){
       addDetailMessage(message, null);
    }

    public static void addDetailMessage(String message, FacesMessage.Severity severity){

        FacesMessage facesMessage = Messages.create("").detail(message).get();
        if(severity != null && severity != FacesMessage.SEVERITY_INFO) {
            facesMessage.setSeverity(severity);
        } else{
            Messages.add(null,facesMessage);
        }
    }
    
    private static Producto crear(int i) {
        return new Producto(i).nombre("producto " + i).precio(Double.valueOf(i));
    }

    @Produces
    public List<Producto> getProductos() {
        return productos;
    }

}
