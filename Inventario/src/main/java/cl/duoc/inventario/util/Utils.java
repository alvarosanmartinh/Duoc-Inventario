package cl.duoc.inventario.util;

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
@ApplicationScoped
public class Utils implements Serializable {

    private List<Producto> productos;
    private List<Usuario> usuarios;
    private List<Contacto> contactos;

    @PostConstruct
    public void init() {
        productos = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .forEach(i -> productos.add(crearProducto(i)));
        usuarios = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .forEach(i -> usuarios.add(crearUsuario(i)));
        contactos = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .forEach(i -> contactos.add(crearContacto(i)));
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
    
    private static Producto crearProducto(int i) {
        return new Producto(i).nombre("producto " + i).precio(Double.valueOf(i));
    }
    
    private static Usuario crearUsuario(int i) {
        Faker faker = new Faker();
        String nombre = faker.name().fullName();
        String clave = new RandomString(11).nextString();
        String userName = nombre.toLowerCase().substring(nombre.lastIndexOf(" ")+1)+"9"+i;
        return new Usuario(i).nombre(nombre).clave(clave).userName(userName);
    }
    
    private static Contacto crearContacto(int i) {
        Faker faker = new Faker();
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String email = nombre.substring(0,1).toLowerCase()+apellido.toLowerCase().trim()+"@gmail.com";
        String mensaje = faker.shakespeare().hamletQuote();
        String asunto = "Cita a hamlet";
        return new Contacto(i).nombre(nombre).apellido(apellido).email(email).mensaje(mensaje).asunto(asunto);
    }

    @Produces
    public List<Producto> getProductos() {
        return productos;
    }

    @Produces
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    @Produces
    public List<Contacto> getContactos() {
        return contactos;
    }
}
