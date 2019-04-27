package cl.duoc.inventario.model;

import java.io.Serializable;
/**
 *
 * @author Alvaro San Martín
 */
public class Contacto implements Serializable, Comparable<Contacto> {

    private Integer idContacto;
    private String nombre;
    private String apellido;
    private String email;
    private String mensaje;
    private String asunto;

    /**
     * @return the idContacto
     */
    public Integer getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Contacto(Integer idContacto, String nombre, String apellido, String email, String mensaje, String asunto) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.mensaje = mensaje;
        this.asunto = asunto;
    }

    public Contacto() {
    }

    @Override
    public String toString() {
        return "Contacto{" + "idContacto=" + idContacto + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", mensaje=" + mensaje + ", asunto=" + asunto + '}';
    }

    @Override
    public int compareTo(Contacto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean hasNombre() {
        return nombre != null && !"".equals(nombre.trim());
    }
    
    public Contacto asunto(String asunto) {
        this.asunto = asunto;
        return this;
    }
    
    public Contacto mensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }
    public Contacto email(String email) {
        this.email = email;
        return this;
    }
    public Contacto apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }
     public Contacto nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Contacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
     
     
}
