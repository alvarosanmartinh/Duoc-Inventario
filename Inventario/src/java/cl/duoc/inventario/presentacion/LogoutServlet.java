/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.presentacion;

import cl.duoc.inventario.DAO.UsuarioDAO;
import cl.duoc.inventario.DTO.UsuarioDTO;
import cl.duoc.inventario.util.Utilidades;
import java.io.IOException;
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
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logoutServlet", "/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        try {
            sesion.setAttribute("usuarioActivo", null);
            sesion.invalidate();
            response.sendRedirect("./index.jsp");

        } catch (Exception e) {
            response.sendRedirect("./private/login.jsp");
        }

    }

}
