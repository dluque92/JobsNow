/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.DatosusuarioFacade;
import appweb.entity.Aficion;
import appweb.entity.Datosusuario;
import appweb.entity.Estudio;
import appweb.entity.Experiencia;
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
 * @author Adrián
 */
@WebServlet(name = "ServletListarDatos", urlPatterns = {"/ServletListarDatos"})
public class ServletListarDatos extends HttpServlet {

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
        String stringId = request.getParameter("id");
        if(stringId==null || stringId.isEmpty()){
            stringId = (String) session.getAttribute("id");
            session.removeAttribute("id");
        }
        
        Datosusuario usuario = null;
        if(stringId == null || stringId.isEmpty()){
            usuario = (Datosusuario) session.getAttribute("usuario");
        }else{
            usuario = this.datosusuarioFacade.find(new BigDecimal(stringId));
            Datosusuario miusuario = (Datosusuario)session.getAttribute("usuario");
            request.setAttribute("sonAmigos", this.datosusuarioFacade.sonAmigos(usuario.getId(),miusuario.getId()));
            request.setAttribute("peticionAmistad",miusuario.getDatosusuarioCollection().contains(usuario) );
        }
        
        request.setAttribute("usuario", usuario);
        request.setAttribute("listaExperiencias", usuario.getExperienciaCollection());
        request.setAttribute("listaAficiones", usuario.getAficionCollection());
        request.setAttribute("listaEstudios", usuario.getEstudioCollection());
        
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/index.jsp");
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
