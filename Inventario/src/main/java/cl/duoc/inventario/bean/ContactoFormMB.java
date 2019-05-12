package cl.duoc.inventario.bean;

//import cl.duoc.inventario.model.Contacto;
import cl.duoc.inventario.entities.Contacto;
import cl.duoc.inventario.model.ContactoFacadeLocal;
import cl.duoc.inventario.service.ContactoService;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static cl.duoc.inventario.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;

/**
 *
 * @author Alvaro San Martín
 */
@Named
@ViewScoped
public class ContactoFormMB implements Serializable {


    private Integer idContacto;
    private Contacto contacto;


    @Inject
    ContactoService contactoService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(idContacto)) {
            contacto = contactoService.findById(idContacto);
        } else {
            contacto = new Contacto();
        }
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void remove() throws IOException {
        if (has(contacto) && has(contacto.getIdContacto())) {
            contactoService.remove(contacto);
            addDetailMessage("Contacto " + contacto.getNombre()
                    + " ha sido eliminado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("contact-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (contacto.getIdContacto() == null) {
            contactoService.insert(contacto);
            msg = "Contacto " + contacto.getNombre() + " creado";
        } else {
            contactoService.update(contacto);
            msg = "Contacto " + contacto.getNombre() + " actualizado";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        contacto = new Contacto();
        idContacto = null;
    }

    public boolean isNew() {
        return contacto == null || contacto.getIdContacto() == null;
    }


}
