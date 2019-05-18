package cl.duoc.inventario.bean;

import cl.duoc.inventario.DAO.ProductoFacade;
import cl.duoc.inventario.infra.model.Filter;
import cl.duoc.inventario.entities.Producto;
import com.github.adminfaces.template.exception.BusinessException;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
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
public class ProductoListMB implements Serializable {

    ProductoFacade productoService;

    Integer id;

    LazyDataModel<Producto> productos;

    Filter<Producto> filter = new Filter<>(new Producto());

    List<Producto> selectedProductos; //productos con checkbox seleccionado

    List<Producto> filteredValue;// datatable filteredValue attribute (column filters)

    @PostConstruct
    public void initDataModel() {
        productos = new LazyDataModel<Producto>() {
            @Override
            public List<Producto> load(int first, int pageSize,
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
                List<Producto> list = productoService.findAll();
                setRowCount((int) productoService.count());
                return list;
            }

            @Override
            public int getRowCount() {
                return super.getRowCount();
            }

            @Override
            public Producto getRowData(String key) {
                return productoService.find(new Integer(key));
            }
        };
    }

    public void clear() {
        filter = new Filter<Producto>(new Producto());
    }

    public void findProductoById(Integer id) {
        if (id == null) {
            throw new BusinessException("Ingrese un id a buscar");
        }
        selectedProductos.add(productoService.find(id));
    }

    public void delete() {
        int numProductos = 0;
        for (Producto selectedProducto : selectedProductos) {
            numProductos++;
            productoService.remove(selectedProducto);
        }
        selectedProductos.clear();
        addDetailMessage(" Se han eliminado correctamente los "+numProductos+" productos seleccionados");
    }

    public List<Producto> getSelectedProductos() {
        return selectedProductos;
    }

    public List<Producto> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Producto> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public void setSelectedProductos(List<Producto> selectedProductos) {
        this.selectedProductos = selectedProductos;
    }

    public LazyDataModel<Producto> getProductos() {
        return productos;
    }

    public void setProductos(LazyDataModel<Producto> productos) {
        this.productos = productos;
    }

    public Filter<Producto> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Producto> filter) {
        this.filter = filter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
