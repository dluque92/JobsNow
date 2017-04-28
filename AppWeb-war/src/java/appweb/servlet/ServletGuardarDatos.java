/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appweb.servlet;

import appweb.ejb.DatosUsuarioFacade;
import appweb.entity.Aficion;
import appweb.entity.DatosUsuario;
import appweb.entity.Estudio;
import appweb.entity.Experiencia;
import java.io.IOException;
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
@WebServlet(name = "ServletGuardarDatos", urlPatterns = {"/ServletGuardarDatos"})
public class ServletGuardarDatos extends HttpServlet {
    @EJB
    private DatosUsuarioFacade datosUsuariofacade;
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
        request.setCharacterEncoding( "UTF-8" );//OJO!!
        
        Boolean badPassword = false;
        //siempre que haya algun cambio, hay que actualizar la sesion tambien.
        DatosUsuario usuario;
        
        String  nombre = request.getParameter("nombre");
        String  apellidos = request.getParameter("apellidos");
        String  email = request.getParameter("email");
        String  password = request.getParameter("password");
        String  password2 = request.getParameter("password2");
        String  password3 = request.getParameter("password3");
        String  twitter = request.getParameter("twitter");
        String  instagram = request.getParameter("instagram");
        String  paginaweb = request.getParameter("paginaweb");
        
        
       HttpSession session;
       session = request.getSession();
       DatosUsuario usuarioSesion = (DatosUsuario) session.getAttribute("usuario");
       BigDecimal id = usuarioSesion.getIdUsuario();
       
       usuario = this.datosUsuariofacade.find(id);
       
       List<Aficion> aficiones = (List<Aficion>) usuario.getAficionCollection();
       List<Experiencia> experiencias = (List<Experiencia>) usuario.getExperienciaCollection();
       List<Estudio> estudios = (List<Estudio>) usuario.getEstudioCollection();
       
       usuario.setNombre(nombre);
       usuario.setApellidos(apellidos);
       usuario.setEmail(email);
       
       if(password2 != null && !password2.isEmpty() && password !=null && !password.isEmpty()){           
           if(password2.equals(password3)&& password.equals(usuario.getPassword())){
               usuario.setPassword(password2);
           }else{
               usuario.setPassword(usuario.getPassword());
               badPassword = true;
           }      
       }else{
           usuario.setPassword(usuario.getPassword());
       }

       usuario.setTwitter(twitter);
       usuario.setInstagram(instagram);
       usuario.setWeb(paginaweb);
       
       this.datosUsuariofacade.edit(usuario);//actualiza el usuario
        
       session.setAttribute("usuario", usuario);//actualizamos la sesion
       
        
        RequestDispatcher rd;
        
        if(badPassword){
            request.setAttribute("usuario",usuario);
            request.setAttribute("aficiones", aficiones);
            request.setAttribute("experiencias", experiencias);
            request.setAttribute("estudios", estudios);
  
            rd = this.getServletContext().getRequestDispatcher("/editar.jsp");
            rd.forward(request, response);
        }else{
            rd = this.getServletContext().getRequestDispatcher("/ServletListarDatos");        
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
