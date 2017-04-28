/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.EstudioFacade;
import appweb.entity.DatosUsuario;
import appweb.entity.Estudio;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
@WebServlet(name = "ServletInsertEstudio", urlPatterns = {"/ServletInsertEstudio"})
public class ServletInsertEstudio extends HttpServlet {

    @EJB
    private EstudioFacade estudioFacade;

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        DatosUsuario usuarioEnSession = (DatosUsuario) session.getAttribute("usuario");
        //-------Obteniendo valores del request----------
        String stringFechaComienzo = request.getParameter("fechaComienzo");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //surround below line with try catch block as below code throws checked exception
        Date fechaComienzo = sdf.parse(stringFechaComienzo);
        //do further processing with Date object
        
        String stringFechaFin = request.getParameter("fechaFin");
        //surround below line with try catch block as below code throws checked exception
        Date fechaFin = sdf.parse(stringFechaFin);
        //do further processing with Date object
        
        String descripcion = request.getParameter("descripcion");
        String ubicacion = request.getParameter("ubicacion");
        //------Creacion del estudio-------
        Estudio estudio = new Estudio(new BigDecimal(5),fechaComienzo,descripcion);
        estudio.setDatosUsuarioIdUsuario(usuarioEnSession);
        if (ubicacion != null && !ubicacion.isEmpty()){
            estudio.setUbicacion(ubicacion);
        }
        if (fechaFin != null){
            estudio.setFechaFinalizacion(fechaFin);
        }
        this.estudioFacade.create(estudio);
        //------Actualizacion usuario---------
        List<Estudio> listaDeEstudios = (List<Estudio>) usuarioEnSession.getEstudioCollection();
        listaDeEstudios.add(estudio);
        usuarioEnSession.setEstudioCollection(listaDeEstudios);
        session.setAttribute("usuario", usuarioEnSession);
        //------Finalizamos el servlet--------
        
        /*
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/editar.jsp");
        rd.forward(request, response);
        */
        
        response.sendRedirect("ServletEditar");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletInsertEstudio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletInsertEstudio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
