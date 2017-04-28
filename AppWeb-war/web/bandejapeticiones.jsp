<%-- 
    Document   : bandejapeticiones
    Created on : 26-abr-2017, 12:22:42
    Author     : adri_
--%>

<%@page import="java.util.List"%>
<%@page import="appweb.entity.Datosusuario"%>
<%
    Datosusuario du = (Datosusuario)session.getAttribute("usuario");
    List<Datosusuario> listaPeticiones = (List)du.getDatosusuarioCollection1();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peticiones de amistad</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <!-- Icons -->
        <script src="https://use.fontawesome.com/0e798431ad.js"></script>

        <style>
            body {
                background: -webkit-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Chrome 10+, Saf5.1+ */
                background:    -moz-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* FF3.6+ */
                background:     -ms-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* IE10 */
                background:      -o-linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* Opera 11.10+ */
                background:         linear-gradient(90deg, #16222A 10%, #3A6073 90%); /* W3C */
                padding-top: 60px; /* ESTO LO PIDE LA PAGINA WEB DE BOOTSTRAP */
            }
            .jumbotron{
                margin: 1em;
                padding: 2em;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top  navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="ServletListarDatos">Brand</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <form class="navbar-form navbar-left" action="ServletBuscar" method="POST">
                        <div class="form-group">
                            <input type="text" name="busqueda" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default fa fa-search"></button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="bandejaentrada.jsp"><i class="fa fa-envelope"></i></a></li>
                        <li><a href="ServletCerrarSesion">Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron vertical-center">
                <h3>Usuarios</h3>
                <div class="list-group">
                    <%
                        if (listaPeticiones != null) {
                            for (Datosusuario usuario : listaPeticiones) {
                    %>
                    <div class="list-group-item">
                        <h4><%= usuario.getNombre()%>  <%= usuario.getApellidos()%>
                            <a href="ServletAceptarAmigo?id=<%= usuario.getId()%>"><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-check"></span></button></a>
                        </h4>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
