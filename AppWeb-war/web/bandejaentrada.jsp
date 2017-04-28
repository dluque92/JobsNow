<%-- 
    Document   : bandejaEntrada
    Created on : 22-abr-2017, 11:37:22
    Author     : david
--%>

<%@page import="java.util.List"%>
<%@page import="appweb.entity.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<List<Mensaje>> listaMensajesAmigos = (List<List<Mensaje>>) request.getAttribute("listaMensajesAmigos");
    listaMensajesAmigos.get(0);
%>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/40f6f1cf0c.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
        <link href='style.css' rel='stylesheet' type='text/css'>
        <title>Bandeja de Entrada</title>
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
                        <li><a href="ServletListarCorreos"><i class="fa fa-envelope"></i></a></li>
                        <li><a href="ServletListarPeticiones"><i class="fa fa-users" style="color:green"></i></a></li>
                        <li><a href="ServletCerrarSesion">Cerrar Sesión</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container bootstrap snippet middlePage" style="margin-top: 5%; width: 80%; height: auto;">
            <div class="row" >
                <%
                    //for (Datosusuario usuario : listaCorreos) {
                %>
                <div class="conversation-wrap col-md-3" style=" background-color: whitesmoke;">
                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle"  style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/user_2.jpg">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading"></h5>
                            <small class="text-muted">Lorem ipsum dolor...</small>
                        </div>
                    </div>
                </div>
                <div class="message-wrap col-md-8" style=" background-color: whitesmoke;">
                    <div class="msg-wrap">
                        
                        <% //for( Mensaje mensaje: usuario.getMensaje){
                            //
                        %>
                        <div class="media msg ">
                            <a class="pull-left" href="#">
                                <img class="media-object    img-circle" style="width: 32px; height: 32px;" src="http://bootdey.com/img/Content/user_2.jpg">
                            </a>
                            <div class="media-body">
                                <small class="pull-right time"><i class="fa fa-clock-o"></i> 12:10am</small>
                                <h5 class="media-heading">Pauline mothg</h5>
                                <small class="col-md-10 text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam convallis, augue sed euismod varius, nisl metus vestibulum neque, nec dictum est dui et tellus</small>
                            </div>
                        </div>
                        <!-- <div class="alert alert-info msg-date">
                             <strong>Today</strong>
                         </div> -->
                        <%
                        //}
                        %>
                        
                        <div class="send-wrap ">
                            <textarea class="form-control send-message" rows="3" placeholder="Escribe un mensaje..."></textarea>
                        </div>
                        <div class="btn-panel">
                            <button class="btn btn-success" role="button">
                                <i class="fa fa-share"></i> Enviar mensaje
                            </button>
                        </div>
                    </div>
                </div>
                <%
                  //  }
                %>
            </div>                
    </body>
</html>
