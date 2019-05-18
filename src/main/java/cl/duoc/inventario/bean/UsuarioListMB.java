package cl.duoc.inventario.bean;

import cl.duoc.inventario.DAO.UsuarioFacade;
import cl.duoc.inventario.entities.Usuario;
import cl.duoc.inventario.infra.model.Filter;
import com.github.adminfaces.template.exception.BusinessException;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static cl.duoc.inventario.util.Utils.addDetailMessage;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alvaro San Martín
 */
@Named
@SessionScoped
public class UsuarioListMB implements Serializable {

    @Inject
    UsuarioFacade usuarioService;

    Integer id;

    List<Usuario> usuarios;

    Filter<Usuario> filter = new Filter<>(new Usuario());

    List<Usuario> selectedUsuarios; //usuarios con checkbox seleccionado

    List<Usuario> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        usuarios = 
                        usuarioService
                        .findAll();
    }

    public void clear() {
        filter = new Filter<Usuario>(new Usuario());
    }

    public void findUsuarioById(Integer id) {
        if (id == null) {
            throw new BusinessException("Ingrese un id a buscar");
        }
        selectedUsuarios.add(usuarioService.find(id));
    }

    public void delete() {
        int numUsuarios = 0;
        for (Usuario selectedUsuario : selectedUsuarios) {
            numUsuarios++;
            usuarioService.remove(selectedUsuario);
        }
        selectedUsuarios.clear();
        addDetailMessage(" Se han eliminado correctamente los "+numUsuarios+" usuarios seleccionados");
    }

    public List<Usuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }

    public List<Usuario> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Usuario> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedUsuarios(List<Usuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Filter<Usuario> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Usuario> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
