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
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet", "/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UsuarioDAO DAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();

        String user = request.getParameter("user");
        String pass = Utilidades.generateMD5Signature(request.getParameter("pass"));

        //Si el checkbox esta habilitado, guardar cookie con el nombre de usuario
        if (null != request.getParameter("boolRemember")) {
            Cookie c = new Cookie("user", user);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);
        }

        try {
            
            System.out.println("user "+user);
            System.out.println("clave "+pass);
            
            UsuarioDTO usuario = DAO.findByUsernameAndClave(user, pass);
            
            if (null != usuario) {
                sesion.setAttribute("usuarioActivo", usuario);
                sesion.setAttribute("exito", "Bienvenido " + user);
                response.sendRedirect("./private/dashboard.jsp");
            } else {
                System.out.println("Usuario no existe");
                sesion.setAttribute("error", "Usuario no encontrado");
                response.sendRedirect("./private/login.jsp");
            }

        } catch (Exception e) {
            sesion.setAttribute("error", "Ocurrio un error: "+e.getMessage());
            response.sendRedirect("./private/login.jsp");
        }

    }

}
