/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.presentacion;

import cl.duoc.inventario.DAO.UsuarioDAO;
import cl.duoc.inventario.DTO.UsuarioDTO;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListarUsuarioServlet", urlPatterns = {"/listarUsuario"})
public class ListarUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioDAO DAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        try {
            
            List<UsuarioDTO> listaUsuario = DAO.findAll();
            
            if (null != listaUsuario) {
                sesion.setAttribute("listaUsuario", listaUsuario);
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
