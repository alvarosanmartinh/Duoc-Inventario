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
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alvaro
 */
@WebServlet(name = "ListarMensajeServlet", urlPatterns = {"/listarMensaje"})
public class ListarMensajeServlet extends HttpServlet {

    @EJB
    private ContactoDAO DAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        try {
            
            List<ContactoDTO> listaMensaje = DAO.findAll();
            
            if (null != listaMensaje) {
                sesion.setAttribute("listaMensaje", listaMensaje);
            }

        } catch (Exception e) {
            sesion.setAttribute("error", "Ocurrio un error: "+e.getMessage());
            response.sendRedirect("/private/dashboard.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
