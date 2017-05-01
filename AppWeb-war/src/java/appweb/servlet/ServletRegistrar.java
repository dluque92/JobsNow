/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.DatosUsuarioFacade;
import appweb.entity.DatosUsuario;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "ServletRegistrar", urlPatterns = {"/ServletRegistrar"})
public class ServletRegistrar extends HttpServlet {

    @EJB
    private DatosUsuarioFacade datosusuarioFacade;

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
        DatosUsuario datosUsuario;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String nombre = request.getParameter("nombre");//obligatorio
        String apellidos = request.getParameter("apellidos");//obligatorio
        String email = request.getParameter("email");//obligatorio
        String password = request.getParameter("password");//obligatorio
        String password2 = request.getParameter("password2");//obligatorio
        String twitter = request.getParameter("twitter");
        String instagram = request.getParameter("instagram");
        String web = request.getParameter("web");
        String foto = request.getParameter("foto");//serializable??

        if (this.datosusuarioFacade.emailUsado(email)) {
            Boolean emailusado = true;
            request.setAttribute("emailusado", emailusado);
        }
        if (!password.equals(password2)) {
            Boolean pass = true;
            request.setAttribute("pass", pass);
        }
        if (this.datosusuarioFacade.emailUsado(email) || !password.equals(password2)) {
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/registrar.jsp");
            rd.forward(request, response);
        } else {

            datosUsuario = this.datosusuarioFacade.crearUsuario(email, password, nombre, apellidos);

            if (twitter != null) {
                datosUsuario.setTwitter(twitter);
            }
            if (instagram != null) {
                datosUsuario.setInstagram(instagram);
            }
            if (web != null) {
                datosUsuario.setWeb(web);
            }
            if (foto != null) {
                datosUsuario.setFoto(foto);
            }

            this.datosusuarioFacade.create(datosUsuario);

            RequestDispatcher rd;
            rd = this.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
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
