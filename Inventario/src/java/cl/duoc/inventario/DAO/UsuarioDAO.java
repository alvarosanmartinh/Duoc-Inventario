package cl.duoc.inventario.DAO;

import cl.duoc.inventario.DTO.UsuarioDTO;
import cl.duoc.inventario.conversores.ConversorUsuario;
import cl.duoc.inventario.entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alvaro
 */
@Stateless
public class UsuarioDAO {

    @PersistenceContext
    EntityManager em;

    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> result = null;
        try {
            List<Usuario> usuarios = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
            if (null != usuarios) {
                result = ConversorUsuario.convertirEntidad(usuarios);
            }
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    public UsuarioDTO findById(Long id) {
        UsuarioDTO result = null;
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findById", Usuario.class).setParameter("id", id).getSingleResult();
            if (null != usuario) {
                result = ConversorUsuario.convertirEntidad(usuario);
            }
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    public UsuarioDTO findByUsername(String username) {
        UsuarioDTO result = null;
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findByUsername", Usuario.class).setParameter("username", username).getSingleResult();
            if (null != usuario) {
                result = ConversorUsuario.convertirEntidad(usuario);
            }
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }

    public UsuarioDTO add(UsuarioDTO usuario) {
        Usuario entidad = ConversorUsuario.convertirDTO(usuario);
        System.out.println("entidad: " + entidad);
        em.persist(entidad);
        return ConversorUsuario.convertirEntidad(entidad);
    }

    public UsuarioDTO findByUsernameAndClave(String username, String clave) {
        UsuarioDTO result = null;
        try {
            Usuario usuario = em.createNamedQuery("Usuario.findByUsernameAndClave", Usuario.class)
                    .setParameter("username", username)
                    .setParameter("clave", clave)
                    .getSingleResult();
            if (null != usuario) {
                result = ConversorUsuario.convertirEntidad(usuario);
            }
        } catch (NoResultException e) {
            return null;
        }
        return result;
    }
}
