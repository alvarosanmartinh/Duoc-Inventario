package cl.duoc.inventario.bean;

//import cl.duoc.inventario.model.Contacto;
import cl.duoc.inventario.entities.Contacto;
import cl.duoc.inventario.DAO.ContactoFacade;
import cl.duoc.inventario.util.Utils;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static com.github.adminfaces.template.util.Assert.has;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alvaro San Martín
 */
@Named
@SessionScoped
public class ContactoFormMB implements Serializable {


    private Integer idContacto;
    private Contacto contacto;

    @Inject
    ContactoFacade contactoService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(idContacto)) {
            contacto = contactoService.find(idContacto);
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
            Utils.addDetailMessage("Contacto " + contacto.getNombre()
                    + " ha sido eliminado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("contact-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (contacto.getIdContacto() == null) {
            contactoService.create(contacto);
            msg = "Contacto " + contacto.getNombre() + " creado";
        } else {
            contactoService.edit(contacto);
            msg = "Contacto " + contacto.getNombre() + " actualizado";
        }
        Utils.addDetailMessage(msg);
    }

    public void clear() {
        contacto = new Contacto();
        idContacto = null;
    }

    public boolean isNew() {
        return contacto == null || contacto.getIdContacto() == null;
    }


}
