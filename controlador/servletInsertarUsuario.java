/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import persistencia.Conectar;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Alfredo Ruíz
 */
@WebServlet(name = "servletInsertarUsuario", urlPatterns = {"/servletInsertarUsuario"})
public class servletInsertarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaRespuesta;

        String nombre_usuario = "";
        String tipo_usuario = "";
        String password_usuario = "";
        String correo_usuario = "";
        String telefono_usuario = "";

        Conectar obj = new Conectar();
        Usuario a = new Usuario();

        nombre_usuario = request.getParameter("txtNombre");
        tipo_usuario = request.getParameter("txtTipoUsuario");
        password_usuario = request.getParameter("txtPass");
        correo_usuario = request.getParameter("txtCorreo");
        telefono_usuario = request.getParameter("txtTel");

        a.setNombre_usuario(nombre_usuario);
        a.setTipo_usuario(tipo_usuario);
        a.setPassword_usuario(password_usuario);
        a.setCorreo_usuario(correo_usuario);
        a.setTelefono_usuario(telefono_usuario);

        try {
            obj.abrir();
            int i = obj.insertar(a);
            obj.cerrar();

            if (i == 0) {
                paginaRespuesta = "admin.jsp";
                request.setAttribute("mensaje", "alert('Error en la inserccion!')");
            } else {
                paginaRespuesta = "admin.jsp";
                request.setAttribute("mensaje", "alert('inserccion correcta!')");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            paginaRespuesta = "admin.jsp";
            request.setAttribute("mensaje", "alert('error en la inserccion')");
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(paginaRespuesta);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
