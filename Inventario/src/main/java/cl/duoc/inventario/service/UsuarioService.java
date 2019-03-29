package cl.duoc.inventario.service;

import cl.duoc.inventario.infra.model.Filter;
import cl.duoc.inventario.infra.model.SortOrder;
import cl.duoc.inventario.model.Usuario;
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
public class UsuarioService implements Serializable {

    @Inject List<Usuario> allUsuarios;

    public UsuarioService() {
        this.allUsuarios = new ArrayList<>();
    }

    public List<Usuario> listByNombre(String nombre) {
        return allUsuarios.stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());

    }

    public List<Usuario> paginate(Filter<Usuario> filter) {
        List<Usuario> pagedUsuarios = new ArrayList<>();
        if(has(filter.getSortOrder()) && !SortOrder.UNSORTED.equals(filter.getSortOrder())) {
                pagedUsuarios = allUsuarios.stream().
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
            pagedUsuarios = pagedUsuarios.subList(filter.getFirst(), page > allUsuarios.size() ? allUsuarios.size() : page);
            return pagedUsuarios;
        }

        List<Predicate<Usuario>> predicates = configFilter(filter);

        List<Usuario> pagedList = allUsuarios.stream().filter(predicates
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

    private List<Predicate<Usuario>> configFilter(Filter<Usuario> filter) {
        List<Predicate<Usuario>> predicates = new ArrayList<>();
        if (filter.hasParam("id")) {
            Predicate<Usuario> idPredicate = (Usuario c) -> c.getId().equals(filter.getParam("id"));
            predicates.add(idPredicate);
        }

        if (has(filter.getEntity())) {
            Usuario filterEntity = filter.getEntity();

            if (has(filterEntity.getUserName())) {
                Predicate<Usuario> userNamePredicate = (Usuario c) -> c.getUserName().toLowerCase().contains(filterEntity.getUserName().toLowerCase());
                predicates.add(userNamePredicate);
            }
            
            if (has(filterEntity.getClave())) {
                Predicate<Usuario> clavePredicate = (Usuario c) -> c.getClave().toLowerCase().contains(filterEntity.getClave().toLowerCase());
                predicates.add(clavePredicate);
            }
            
            if (has(filterEntity.getClave())) {
                Predicate<Usuario> clavePredicate = (Usuario c) -> c.getClave().toLowerCase().contains(filterEntity.getClave().toLowerCase());
                predicates.add(clavePredicate);
            }
            
            if (has(filterEntity.getNombre())) {
                Predicate<Usuario> namePredicate = (Usuario c) -> c.getNombre().toLowerCase().contains(filterEntity.getNombre().toLowerCase());
                predicates.add(namePredicate);
            }
        }
        return predicates;
    }

    public void insert(Usuario usuario) {
        beforeInsert(usuario);
        usuario.setId(allUsuarios.stream()
                .mapToInt(c -> c.getId())
                .max()
                .getAsInt()+1);
        allUsuarios.add(usuario);
    }

    public void beforeInsert(Usuario usuario) {
        if (!usuario.hasNombre()) {
            throw new BusinessException("El nombre no puede estar vacio");
        }

        if (allUsuarios.stream().filter(c -> c.getNombre().equalsIgnoreCase(usuario.getNombre())
                && c.getId() != c.getId()).count() > 0) {
            throw new BusinessException("El nombre debe ser unico");
        }
    }


    public void remove(Usuario usuario) {
        allUsuarios.remove(usuario);
    }

    public long count(Filter<Usuario> filter) {
        return allUsuarios.stream()
                .filter(configFilter(filter).stream()
                        .reduce(Predicate::or).orElse(t -> true))
                .count();
    }

    public Usuario findById(Integer id) {
        return allUsuarios.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException("No se encontro el auto con id " + id));
    }

    public void update(Usuario usuario) {
        allUsuarios.remove(allUsuarios.indexOf(usuario));
        allUsuarios.add(usuario);
    }
    
    public List<String> getNombres(String query) {
        return allUsuarios.stream().filter(c -> c.getNombre()
                .toLowerCase().contains(query.toLowerCase()))
                .map(Usuario::getNombre)
                .collect(Collectors.toList());
    }
}
