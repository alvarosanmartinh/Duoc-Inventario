package cl.duoc.inventario.bean;

import cl.duoc.inventario.infra.model.Filter;
import cl.duoc.inventario.entities.Contacto;
//import cl.duoc.inventario.model.Contacto;

import cl.duoc.inventario.service.ContactoService;
import cl.duoc.inventario.service.ContactoService;
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

/**
 *
 * @author Alvaro San Martín
 */
@Named
@ViewScoped
public class ContactoListMB implements Serializable {

    @Inject
    ContactoService contactoService;

    Integer id;

    LazyDataModel<Contacto> contactos;

    Filter<Contacto> filter = new Filter<>(new Contacto());

    List<Contacto> selectedContactos; //contactos con checkbox seleccionado

    List<Contacto> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        contactos = new LazyDataModel<Contacto>() {
            @Override
            public List<Contacto> load(int first, int pageSize,
                                  String sortField, SortOrder sortOrder,
                                  Map<String, Object> filters) {
                cl.duoc.inventario.infra.model.SortOrder order = null;
                if (sortOrder != null) {
                    order = sortOrder.equals(SortOrder.ASCENDING) ? cl.duoc.inventario.infra.model.SortOrder.ASCENDING
                            : sortOrder.equals(SortOrder.DESCENDING) ? cl.duoc.inventario.infra.model.SortOrder.DESCENDING
                            : cl.duoc.inventario.infra.model.SortOrder.UNSORTED;
                }
                filter.setFirst(first).setPageSize(pageSize)
                        .setSortField(sortField).setSortOrder(order)
                        .setParams(filters);
                List<Contacto> list = contactoService.paginate(filter);
                setRowCount((int) contactoService.count(filter));
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public Contacto getRowData(String key) {
                return contactoService.findById(new Integer(key));
            }
        };
    }

    public void clear() {
        filter = new Filter<Contacto>(new Contacto());
    }

    public List<String> completeNombre(String query) {
        List<String> result = contactoService.getNombres(query);
        return result;
    }

    public void findContactoById(Integer id) {
        if (id == null) {
            throw new BusinessException("Ingrese un id a buscar");
        }
        selectedContactos.add(contactoService.findById(id));
    }

    public void delete() {
        int numContactos = 0;
        for (Contacto selectedContacto : selectedContactos) {
            numContactos++;
            contactoService.remove(selectedContacto);
        }
        selectedContactos.clear();
        addDetailMessage(" Se han eliminado correctamente los "+numContactos+" contactos seleccionados");
    }

    public List<Contacto> getSelectedContactos() {
        return selectedContactos;
    }

    public List<Contacto> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Contacto> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedContactos(List<Contacto> selectedContactos) {
        this.selectedContactos = selectedContactos;
    }

    public LazyDataModel<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(LazyDataModel<Contacto> contactos) {
        this.contactos = contactos;
    }

    public Filter<Contacto> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Contacto> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
