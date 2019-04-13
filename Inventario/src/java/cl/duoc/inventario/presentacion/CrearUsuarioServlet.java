/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.presentacion;

import cl.duoc.inventario.DAO.UsuarioDAO;
import cl.duoc.inventario.DTO.UsuarioDTO;
import cl.duoc.inventario.conversores.ConversorUsuario;
import cl.duoc.inventario.util.Utilidades;
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
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = {"/crearUsuario"})
public class CrearUsuarioServlet extends HttpServlet {

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

        String user = request.getParameter("inputUsername");
        String nivelUsuario = request.getParameter("gridRadios");
        String pass = Utilidades.generateMD5Signature(request.getParameter("inputClave"));
        if (nivelUsuario == null || nivelUsuario.isEmpty()) {
            sesion.setAttribute("error", "Debe seleccionar un nivel de usuario");
            response.sendRedirect("./private/nuevoUsuario.jsp");
        }

        UsuarioDTO usuario = null;

        try {
            usuario = DAO.findByUsername(user);
        } catch (Exception e) {
        }
        
        try {
            int nivel = Integer.parseInt(nivelUsuario);

            if (null == usuario) {
                usuario = DAO.add(new UsuarioDTO().withClave(pass).withNivelUsuario(nivel).withUsername(user));

                if (null != usuario) {
                    sesion.setAttribute("exito", "Usuario " + usuario.getUsername() + " creado");
                    response.sendRedirect("./private/listaUsuario.jsp");
                }
            } else {
                sesion.setAttribute("error", "Ya hay un usuario con ese nombre");
                response.sendRedirect("./private/nuevoUsuario.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sesion.setAttribute("error", "Ocurrio un error: " + e.getMessage());
            response.sendRedirect("./private/nuevoUsuario.jsp");
        }

    }

}
