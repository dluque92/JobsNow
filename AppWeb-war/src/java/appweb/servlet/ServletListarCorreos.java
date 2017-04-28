/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;


import appweb.ejb.DatosUsuarioFacade;
import appweb.ejb.MensajeFacade;
import appweb.entity.DatosUsuario;

import appweb.entity.Mensaje;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ServletListarCorreos", urlPatterns = {"/ServletListarCorreos"})
public class ServletListarCorreos extends HttpServlet {

    @EJB
    private MensajeFacade mensajeFacade;

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
        List<Mensaje> listaCorreos = new ArrayList<>();
        HttpSession session = request.getSession();
        
        DatosUsuario usuario = (DatosUsuario)session.getAttribute("usuario");
        List<DatosUsuario> listaAmigos = (List) usuario.getMisAmigos();
        List<List<Mensaje>> listaMensajesAmigos = new ArrayList<>();
        for(DatosUsuario amigo: listaAmigos){
            listaMensajesAmigos.add(this.mensajeFacade.getMensajesAmigos(usuario.getIdUsuario(),amigo.getIdUsuario()));
        }
        
        request.setAttribute("listaMensajesAmigos", listaMensajesAmigos);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/bandejaentrada.jsp");
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
