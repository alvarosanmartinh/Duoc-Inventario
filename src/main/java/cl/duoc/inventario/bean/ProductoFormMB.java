package cl.duoc.inventario.bean;

import cl.duoc.inventario.DAO.ProductoFacade;
import cl.duoc.inventario.entities.Producto;
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
public class ProductoFormMB implements Serializable {


    private Integer id;
    private Producto producto;


    @Inject
    ProductoFacade productoService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            producto = productoService.find(id);
        } else {
            producto = new Producto();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void remove() throws IOException {
        if (has(producto) && has(producto.getId())) {
            productoService.remove(producto);
            addDetailMessage("Producto " + producto.getNombre()
                    + " ha sido eliminado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("product-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (producto.getId() == null) {
            productoService.create(producto);
            msg = "Producto " + producto.getNombre() + " creado";
        } else {
            productoService.edit(producto);
            msg = "Producto " + producto.getNombre() + " actualizado";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        producto = new Producto();
        id = null;
    }

    public boolean isNew() {
        return producto == null || producto.getId() == null;
    }


}
