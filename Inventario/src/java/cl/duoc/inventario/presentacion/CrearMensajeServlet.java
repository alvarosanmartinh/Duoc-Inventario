/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.presentacion;

import cl.duoc.inventario.DAO.ContactoDAO;
import cl.duoc.inventario.DAO.UsuarioDAO;
import cl.duoc.inventario.DTO.ContactoDTO;
import cl.duoc.inventario.DTO.UsuarioDTO;
import cl.duoc.inventario.util.Utilidades;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "CrearMensajeServlet", urlPatterns = {"/crearMensaje"})
public class CrearMensajeServlet extends HttpServlet {

    @EJB
    private ContactoDAO DAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        System.out.println("asdfasdfasdfasdf");

        String nombre = request.getParameter("c_fname");
        String apellido = request.getParameter("c_lname");
        String email = request.getParameter("c_email");
        String asunto = request.getParameter("c_subject");
        String mensaje = request.getParameter("c_message");

        ContactoDTO contacto = null;
        
        try {

            contacto = DAO.add(new ContactoDTO().withNombre(nombre).withMensaje(mensaje).withEmail(email).withAsunto(asunto).withApellido(apellido));

            sesion.setAttribute("exito", "Hemos recibido tu mensaje, muchas gracias "+nombre);
            response.sendRedirect("./contact.jsp");
            

        } catch (Exception e) {
            e.printStackTrace();
            sesion.setAttribute("error", "Ocurrio un error: " + e.getMessage());
            response.sendRedirect("./contact.jsp");
        }

    }

}
