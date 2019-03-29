package cl.duoc.inventario.service;

import cl.duoc.inventario.infra.model.Filter;
import cl.duoc.inventario.infra.model.SortOrder;
import cl.duoc.inventario.model.Producto;
import com.github.adminfaces.template.exception.BusinessException;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.github.adminfaces.template.util.Assert.has;
import javax.inject.Inject;

/**
 *
 * @author Alvaro San Martín
 */
@Stateless
public class ProductoService implements Serializable {

    @Inject List<Producto> allProductos;

    public ProductoService() {
        this.allProductos = new ArrayList<>();
    }

    public List<Producto> listByNombre(String nombre) {
        return allProductos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());

    }

    public List<Producto> paginate(Filter<Producto> filter) {
        List<Producto> pagedProductos = new ArrayList<>();
        if(has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {
                pagedProductos = allProductos.stream().
                    sorted((c1, c2) -> {
                        if (filter.getSortOrder().isAscending()) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
            }

        int page = filter.getFirst() + filter.getPageSize();
        if (filter.getParams().isEmpty()) {
            pagedProductos = pagedProductos.subList(filter.getFirst(), page > allProductos.size() ? allProductos.size() : page);
            return pagedProductos;
        }

        List<Predicate<Producto>> predicates = configFilter(filter);

        List<Producto> pagedList = allProductos.stream().filter(predicates
                .stream().reduce(Predicate::or).orElse(t -> true))
                .collect(Collectors.toList());

        if (page < pagedList.size()) {
            pagedList = pagedList.subList(filter.getFirst(), page);
        }

        if (has(filter.getSortField())) {
            pagedList = pagedList.stream().
                    sorted((c1, c2) -> {
                        boolean asc = SortOrder.ASCENDING.equals(filter.getSortOrder());
                        if (asc) {
                            return c1.getId().compareTo(c2.getId());
                        } else {
                            return c2.getId().compareTo(c1.getId());
                        }
                    })
                    .collect(Collectors.toList());
        }
        return pagedList;
    }

    private List<Predicate<Producto>> configFilter(Filter<Producto> filter) {
        List<Predicate<Producto>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Producto> idPredicate = (Producto c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        if (filter.hasParam("precioMin") && filter.hasParam("precioMax")) {
            Predicate<Producto> minMaxPricePredicate = (Producto c) -> c.getPrecio()
                    >= Double.valueOf((String) filter.getParam("precioMin")) && c.getPrecio()
                    <= Double.valueOf((String) filter.getParam("precioMax"));
            predicates.add(minMaxPricePredicate);
        } else if (filter.hasParam("precioMin")) {
            Predicate<Producto> precioMinPredicate = (Producto c) -> c.getPrecio()
                    >= Double.valueOf((String) filter.getParam("precioMin"));
            predicates.add(precioMinPredicate);
        } else if (filter.hasParam("precioMax")) {
            Predicate<Producto> precioMaxPredicate = (Producto c) -> c.getPrecio()
                    <= Double.valueOf((String) filter.getParam("precioMax"));
            predicates.add(precioMaxPredicate);
        }

        if (has(filter.getEntity())) {
            Producto filterEntity = filter.getEntity();

            if (has(filterEntity.getPrecio())) {
                Predicate<Producto> pricePredicate = (Producto c) -> c.getPrecio().equals(filterEntity.getPrecio());
                predicates.add(pricePredicate);
            }

            if (has(filterEntity.getNombre())) {
                Predicate<Producto> namePredicate = (Producto c) -> c.getNombre().toLowerCase().contains(filterEntity.getNombre().toLowerCase());
                predicates.add(namePredicate);
            }
        }
        return predicates;
    }

    public void insert(Producto producto) {
        beforeInsert(producto);
        producto.setId(allProductos.stream()
                .mapToInt(c -> c.getId())
                .max()
                .getAsInt()+1);
        allProductos.add(producto);
    }

    public void beforeInsert(Producto producto) {
        if (!producto.hasNombre()) {
            throw new BusinessException("El nombre no puede estar vacio");
        }

        if (allProductos.stream().filter(c -> c.getNombre().equalsIgnoreCase(producto.getNombre())
                && c.getId() != c.getId()).count() > 0) {
            throw new BusinessException("El nombre debe ser unico");
        }
    }


    public void remove(Producto producto) {
        allProductos.remove(producto);
    }

    public long count(Filter<Producto> filter) {
        return allProductos.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    public Producto findById(Integer id) {
        return allProductos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("No se encontro el producto con id " + id));
    }

    public void update(Producto producto) {
        allProductos.remove(allProductos.indexOf(producto));
        allProductos.add(producto);
    }
    
    public List<String> getNombres(String query) {
        return allProductos.stream().filter(c -> c.getNombre()
                .toLowerCase().contains(query.toLowerCase()))
                .map(Producto::getNombre)
                .collect(Collectors.toList());
    }
}
