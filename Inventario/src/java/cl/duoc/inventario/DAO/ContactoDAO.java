package cl.duoc.inventario.DAO;

import cl.duoc.inventario.DTO.ContactoDTO;
import cl.duoc.inventario.conversores.ConversorContacto;
import cl.duoc.inventario.entidades.Contacto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alvaro
 */
@Stateless
public class ContactoDAO {

    @PersistenceContext
    EntityManager em;
    
    public List<ContactoDTO> findAll(){
        return ConversorContacto.convertirEntidad(em.createNamedQuery("Contacto.findAll", Contacto.class).getResultList());
    }
    
    public ContactoDTO findById(Long id){
        ContactoDTO result = null;
        try {
            result = ConversorContacto.convertirEntidad(em.createNamedQuery("Contacto.findById", Contacto.class).setParameter("id", id).getSingleResult());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public ContactoDTO add(ContactoDTO contacto) {
        Contacto entidad = ConversorContacto.convertirDTO(contacto);
        em.persist(entidad);
        return ConversorContacto.convertirEntidad(entidad);
    }
}
