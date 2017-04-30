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
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
    private DatosUsuarioFacade datosUsuarioFacade;

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

        DatosUsuario usuario = (DatosUsuario) session.getAttribute("usuario");
        usuario = this.datosUsuarioFacade.find(usuario.getIdUsuario());
        String idAmigo = (String) request.getParameter("amigo");
        request.setAttribute("listaAmigos", usuario.getMisAmigos());
        
        if (idAmigo != null) {
            DatosUsuario amigo = this.datosUsuarioFacade.find(new BigDecimal(idAmigo));
            List<Mensaje> listaMensajesAmigo = new ArrayList<>();

            for (Mensaje mensaje : usuario.getMensajeCollection()) {
                Collection<DatosUsuario> coleccionParticipantes = mensaje.getDatosUsuarioCollection();
                if (coleccionParticipantes.contains(usuario) && coleccionParticipantes.contains(amigo)) {
                    listaMensajesAmigo.add(mensaje);

                }
            }
            
            for (Mensaje mensaje : amigo.getMensajeCollection()) {
                Collection<DatosUsuario> coleccionParticipantes = mensaje.getDatosUsuarioCollection();
                if (coleccionParticipantes.contains(usuario) && coleccionParticipantes.contains(amigo)) {
                    if (!listaMensajesAmigo.contains(mensaje)) {
                        listaMensajesAmigo.add(mensaje);
                    }
                }
            }

            Collections.sort(listaMensajesAmigo);
            request.setAttribute("listaMensajesAmigo", listaMensajesAmigo);
            request.setAttribute("amigo", amigo);
        }
        session.setAttribute("usuario", usuario);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/bandejaentrada.jsp");
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
