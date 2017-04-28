/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.AmigosFacade;
import appweb.ejb.DatosusuarioFacade;
import appweb.entity.Datosusuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adri_
 */
@WebServlet(name = "ServletEnviarPeticion", urlPatterns = {"/ServletEnviarPeticion"})
public class ServletEnviarPeticion extends HttpServlet {

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
        HttpSession session = request.getSession();
        Datosusuario usuario = (Datosusuario) session.getAttribute("usuario");
        String idSolicitud = request.getParameter("id");
        Datosusuario solicitado = this.datosusuarioFacade.find(new BigDecimal(idSolicitud));
        //Relaciones a ambos lados
        usuario.getDatosusuarioCollection().add(solicitado);
        solicitado.getDatosusuarioCollection1().add(usuario);
        //Editamos ambos usuarios
        this.datosusuarioFacade.edit(usuario);
        this.datosusuarioFacade.edit(solicitado);
        //actualizamos session
        session.setAttribute("usuario", usuario);
        session.setAttribute("id", idSolicitud);
        
        response.sendRedirect("ServletListarDatos");
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
