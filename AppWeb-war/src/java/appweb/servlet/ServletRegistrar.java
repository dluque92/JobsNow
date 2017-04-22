/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.DatosusuarioFacade;
import appweb.entity.Datosusuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
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
    private DatosusuarioFacade datosusuarioFacade;
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
        Datosusuario datosUsuario;
        String nombre = request.getParameter("nombre");//obligatorio
        String apellidos = request.getParameter("apellidos");//obligatorio
        String email = request.getParameter("email");//obligatorio
        String password = request.getParameter("password");//obligatorio
        String twitter = request.getParameter("twitter");
        String instagram = request.getParameter("instagram");
        String web = request.getParameter("web");
        String foto = request.getParameter("foto");//serializable??
        
        if(this.datosusuarioFacade.emailUsado(email)){
            //mandar alerta
        } else {
        
        datosUsuario = new Datosusuario();
        Integer clave = this.datosusuarioFacade.obtenerProximoValorIdUsuario();
        datosUsuario.setId(BigDecimal.valueOf(clave));
        datosUsuario.setNombre(nombre);
        datosUsuario.setApellidos(apellidos);
        datosUsuario.setPassword(password);
        if(twitter != null || !twitter.isEmpty()){
            datosUsuario.setTwitter(twitter);
        }
        if(instagram != null || !instagram.isEmpty()){
            datosUsuario.setInstagram(instagram);
        }
        if(web != null || !web.isEmpty()){
            datosUsuario.setWeb(web);
        }
        if(foto != null || !foto.isEmpty()){
            datosUsuario.setFoto(foto);
        }
        
        response.sendRedirect("ServletLogin");
       
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
