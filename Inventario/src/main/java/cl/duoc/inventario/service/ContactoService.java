package cl.duoc.inventario.service;

import cl.duoc.inventario.infra.model.Filter;
import cl.duoc.inventario.infra.model.SortOrder;
import cl.duoc.inventario.model.Contacto;
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
public class ContactoService implements Serializable {

    @Inject List<Contacto> allContactos;

    public ContactoService() {
        this.allContactos = new ArrayList<>();
    }

    public List<Contacto> listByNombre(String nombre) {
        return allContactos.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());

    }

    public List<Contacto> paginate(Filter<Contacto> filter) {
        List<Contacto> pagedContactos = new ArrayList<>();
        System.out.println("paginate allContactos start:");  
        for(Contacto p : allContactos){
            System.out.println(p.toString());            
        }
        System.out.println("paginate allContactos end");  
        if(has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {
            pagedContactos = allContactos.stream().
                sorted((c1, c2) -> {
                    if (filter.getSortOrder().isAscending()) {
                        return c1.getIdContacto().compareTo(c2.getIdContacto());
                    } else {
                        return c2.getIdContacto().compareTo(c1.getIdContacto());
                    }
                })
                .collect(Collectors.toList());
        }

        int page = filter.getFirst() + filter.getPageSize();
        if (filter.getParams().isEmpty()) {
            pagedContactos = pagedContactos.subList(filter.getFirst(), page > allContactos.size() ? allContactos.size() : page);
            return pagedContactos;
        }

        List<Predicate<Contacto>> predicates = configFilter(filter);

        List<Contacto> pagedList = allContactos.stream().filter(predicates
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
                            return c1.getIdContacto().compareTo(c2.getIdContacto());
                        } else {
                            return c2.getIdContacto().compareTo(c1.getIdContacto());
                        }
                    })
                    .collect(Collectors.toList());
        }
        return pagedList;
    }

    private List<Predicate<Contacto>> configFilter(Filter<Contacto> filter) {
        List<Predicate<Contacto>> predicates = new ArrayList<>();
        if (filter.hasParam("idContacto")) {
            Predicate<Contacto> idPredicate = (Contacto c) -> c.getIdContacto().equals(filter.getParam("idContacto"));
            predicates.add(idPredicate);
        }

        if (has(filter.getEntity())) {
            Contacto filterEntity = filter.getEntity();


            if (has(filterEntity.getNombre())) {
                Predicate<Contacto> namePredicate = (Contacto c) -> c.getNombre().toLowerCase().contains(filterEntity.getNombre().toLowerCase());
                predicates.add(namePredicate);
            }
        }
        return predicates;
    }

    public void insert(Contacto contacto) {
        beforeInsert(contacto);
        contacto.setIdContacto(allContactos.stream()
                .mapToInt(c -> c.getIdContacto())
                .max()
                .getAsInt()+1);
        allContactos.add(contacto);
    }

    public void beforeInsert(Contacto contacto) {
        if (!contacto.hasNombre()) {
            throw new BusinessException("El nombre no puede estar vacio");
        }

        if (allContactos.stream().filter(c -> c.getNombre().equalsIgnoreCase(contacto.getNombre())
                && c.getIdContacto() != c.getIdContacto()).count() > 0) {
            throw new BusinessException("El nombre debe ser unico");
        }
    }


    public void remove(Contacto contacto) {
        allContactos.remove(contacto);
    }

    public long count(Filter<Contacto> filter) {
        return allContactos.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    public Contacto findById(Integer id) {
        return allContactos.stream()
                .filter(c -> c.getIdContacto().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("No se encontro el contacto con id " + id));
    }

    public void update(Contacto contacto) {
        allContactos.remove(allContactos.indexOf(contacto));
        allContactos.add(contacto);
    }
    
    public List<String> getNombres(String query) {
        return allContactos.stream().filter(c -> c.getNombre()
                .toLowerCase().contains(query.toLowerCase()))
                .map(Contacto::getNombre)
                .collect(Collectors.toList());
    }
}
