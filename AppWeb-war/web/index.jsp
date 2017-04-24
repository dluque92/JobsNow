<%-- 
    Document   : index
    Created on : 24-abr-2017, 17:08:29
    Author     : adri_
--%>

<%@page import="appweb.entity.Datosusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Datosusuario usuario = (Datosusuario) session.getAttribute("usuario");
    String nombre = usuario.getNombre();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuario registradooo</h1>
        <h2><%= nombre%></h2>
        
    </body>
</html>
