package cl.duoc.inventario.bean;

import cl.duoc.inventario.DAO.UsuarioFacade;
import cl.duoc.inventario.entities.Usuario;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static cl.duoc.inventario.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alvaro San Martín
 */
@Named
@SessionScoped
public class UsuarioFormMB implements Serializable {


    private Integer id;
    private Usuario usuario;


    @Inject
    UsuarioFacade usuarioService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            usuario = usuarioService.find(id);
        } else {
            usuario = new Usuario();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void remove() throws IOException {
        if (has(usuario) && has(usuario.getId())) {
            usuarioService.remove(usuario);
            addDetailMessage("Usuario " + usuario.getNombre()
                    + " ha sido eliminado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("product-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (usuario.getId() == null) {
            usuarioService.create(usuario);
            msg = "Usuario " + usuario.getNombre() + " creado";
        } else {
            usuarioService.edit(usuario);
            msg = "Usuario " + usuario.getNombre() + " actualizado";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        usuario = new Usuario();
        id = null;
    }

    public boolean isNew() {
        return usuario == null || usuario.getId() == null;
    }


}
