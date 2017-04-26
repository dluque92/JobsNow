package appweb.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import appweb.ejb.DatosusuarioFacade;
import appweb.entity.Aficion;
import appweb.entity.Datosusuario;
import appweb.entity.Estudio;
import appweb.entity.Experiencia;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/ServletBuscar"})
public class ServletBuscar extends HttpServlet {

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
        Datosusuario usuarioEnSesion = (Datosusuario) session.getAttribute("usuario");
        
        List<Datosusuario> listaUsuariosPorNombre;
        List<Datosusuario> listaUsuariosPorAficion;
        List<Datosusuario> listaUsuariosPorEstudios;
        List<Datosusuario> listaUsuariosPorExperiencia;
        
        String busqueda = request.getParameter("busqueda");
        
        listaUsuariosPorNombre = this.datosusuarioFacade.findByName(busqueda, usuarioEnSesion.getId());
        listaUsuariosPorAficion = this.datosusuarioFacade.findByAficion(busqueda, usuarioEnSesion.getId());
        listaUsuariosPorEstudios = this.datosusuarioFacade.findByEstudios(busqueda, usuarioEnSesion.getId());
        listaUsuariosPorExperiencia = this.datosusuarioFacade.findByExperiencia(busqueda, usuarioEnSesion.getId());
        
        request.setAttribute("listaUsuariosPorNombre", listaUsuariosPorNombre);
        request.setAttribute("listaUsuariosPorAficion", listaUsuariosPorAficion);
        request.setAttribute("listaUsuariosPorEstudios", listaUsuariosPorEstudios);
        request.setAttribute("listaUsuariosPorExperiencia", listaUsuariosPorExperiencia);
        request.setAttribute("busqueda", busqueda);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/listarBusqueda.jsp");
        rd.forward(request, response);
        
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
