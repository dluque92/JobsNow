/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.AmigosFacade;
import appweb.ejb.DatosusuarioFacade;
import appweb.entity.Amigos;
import appweb.entity.Datosusuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@WebServlet(name = "ServletAceptarAmigo", urlPatterns = {"/ServletAceptarAmigo"})
public class ServletAceptarAmigo extends HttpServlet {

    @EJB
    private DatosusuarioFacade datosusuarioFacade;

    @EJB
    private AmigosFacade amigosFacade;
    

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
        
        String id = request.getParameter("id");
        
        Datosusuario usuario = (Datosusuario)session.getAttribute("usuario");
        Datosusuario nuevoAmigo = this.datosusuarioFacade.find(new BigDecimal(id));
                
        this.amigosFacade.create(new Amigos(usuario.getId().toBigInteger(),nuevoAmigo.getId().toBigInteger()));
        
        usuario.getDatosusuarioCollection().remove(nuevoAmigo);
        nuevoAmigo.getDatosusuarioCollection().remove(usuario);
        
        
        this.datosusuarioFacade.edit(usuario);
        this.datosusuarioFacade.edit(nuevoAmigo);
        
        session.setAttribute("usuario", usuario);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/bandejapeticiones.jsp");
        rd.forward(request,response);
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
