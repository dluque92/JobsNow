<%-- 
    Document   : registrar
    Created on : 21-abr-2017, 10:40:16
    Author     : david
--%>

<%@page import="appweb.entity.Aficion"%>
<%@page import="appweb.entity.Experiencia"%>
<%@page import="appweb.entity.Estudio"%>
<%@page import="appweb.entity.Datosusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //Datosusuario contacto = (Datosusuario) request.getAttribute("usuario");
    //Datos para hacer debugging
    Datosusuario contacto = new Datosusuario();
    contacto.setNombre("John Carlo");
    contacto.setApellidos("Purihin Enriquez");
    contacto.setTwitter("@JCarlo36");
    contacto.setInstagram("@JCarlo36Instagram");
    contacto.setEmail("johncarlo@gmail.com");
    contacto.setPassword("purihin");
    contacto.setWeb("johncarlo.com");
%>
<html>
    <link href='style.css' rel='stylesheet' type='text/css'>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JobsNow</title>
        <!-- Latest compiled and minified CSS -->

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="https://use.fontawesome.com/40f6f1cf0c.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <style type="text/css">
            .bs-example{
                margin: 20px;
            }
        </style>
    </head>
    <body>

    <body>
        <div class="middlePage" style="margin-top:  0;">
            <div class="page-header">
                <h1 class="logo">JobsNow <small>Welcome to our place!</small></h1>

            </div>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Editar</h3>
                </div>
                <div class="panel-body">

                    <div class="row">
                        <div class="col-md-7" style="border-left:1px solid #ccc;height:auto; width: 680px">
                            <form class="form-horizontal" action="ServletLogin" method="post">
                                <fieldset>
                                    <div class="spacing"><small>Nombre</small></div>
                                    <input id="nombre" name="nombre" type="text" placeholder="Nombre" class="form-control input-md" value="<%= contacto.getNombre()%>">
                                    <div class="spacing"><small>Apellidos</small></div>
                                    <input id="apellidos" name="apellidos" type="text" placeholder="Apellidos" class="form-control input-md" value="<%=contacto.getApellidos()%>">
                                    <div class="spacing"><small>Email</small></div>
                                    <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" value="<%=contacto.getEmail()%>">
                                    <div class="spacing"><small>Contraseña Actual</small></div>
                                    <input id="password" name="password" type="password" placeholder="Contrasela actual" class="form-control input-md" value="">
                                    <div class="spacing"><small>Nueva Contraseña</small></div>
                                    <input id="password2" name="password2" type="password2" placeholder="Nueva contraseña" class="form-control input-md">
                                    <input id="password3" name="password3" type="password3" placeholder="Repetir contraseña" class="form-control input-md">
                                    <div class="spacing"><small>Twitter</small></div>
                                    <input id="twitter" name="twitter" type="text" placeholder="@NombreUsuario" class="form-control input-md" value="<%=contacto.getTwitter()%>">
                                    <div class="spacing"><small>Instagram</small></div>
                                    <input id="instagram" name="instagram" type="text" placeholder="@NombreUsuario" class="form-control input-md" value="<%=contacto.getInstagram()%>">
                                    <div class="spacing"><small>Página Web</small></div>
                                    <input id="paginaweb" name="paginaweb" type="text" placeholder="www.tuweb.com" class="form-control input-md" value="<%=contacto.getWeb()%>">
                                    <div class="spacing"><small>Foto</small></div>
                                    <%
                                        //PARA HACER PRUEBA<--------------OJOOOOOOOOOOOOOOOOOOOOOOOOOO
                                        if(1==0){
                                    %>
                                    <input id="imagen" name="nombre" type="file" placeholder="Foto" class="form-control input-md" value="<%=contacto.getFoto()%>">
                                    <div class="spacing"><small>Estudios</small></div>
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th style="width:150px;">Comienzo</th>
                                                <th style="width:150px;">Finalizacion</th>
                                                <th style="width:150px;">Descripcion</th>  
                                                <th style="width:150px;">Ubicacion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Estudio estudio : contacto.getEstudioCollection()) {
                                            %>
                                            <tr>
                                                <td style="width:150px;"><%=estudio.getFechaComienzo()%></td>
                                                <td style="width:150px;"><%=estudio.getFechoFinalizacion() %></td>
                                                <td style="width:150px;"><%=estudio.getDescripcion()%></td>
                                                <td style="width:150px;"><%=estudio.getUbicacion()%></td>  
                                                <td ><a href="EditarEstudio?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                                                <td><a href="BorrarEstudio?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span></button></a></td> 
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                    <div class="spacing"><small>Experiencia</small></div>
                                    <table class="table table-striped">
                                        <thead>
                                            <%
                                                for (Experiencia experiencia

                                                : contacto.getExperienciaCollection () 
                                                    ) {
                                            %>
                                            <tr>
                                                <th style="width:150px;">Comienzo</th>
                                                <th style="width:150px;">Finalizacion</th>
                                                <th style="width:150px;">Empresa</th>
                                                <th style="width:150px;">Web Empresa</th>  
                                                <th style="width:150px;">Puesto</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td style="width:150px;"><%=experiencia.getFechaComienzo()%></td>
                                                <td style="width:150px;"><%=experiencia.getFechaFinalizacion()%></td>
                                                <td style="width:150px;"><%=experiencia.getEmpresa()%></td>
                                                <td style="width:150px;"><%=experiencia.getWebEmpresa()%></td>
                                                <td style="width:150px;"><%=experiencia.getPuesto()%></td>
                                                <td><a href="EditarExperiencia?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                                                <td><a href="BorrarExperiencia?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span></button></a></td> 
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>

                                    <div class="spacing"><small>Aficiones</small></div>
                                    <table class="table table-striped">
                                        <thead>
                                            <%
                                                for (Aficion aficion

                                                : contacto.getAficionCollection () 
                                                    ) {
                                            %>
                                            <tr>
                                                <th style="width:150px;">Nombre</th>
                                                <th style="width:150px;"> </th>
                                                <th style="width:150px;"> </th>
                                                <th style="width:150px;"> </th>

                                            </tr>
                                        </thead>
                                        <tbody >
                                            <tr >
                                                <td style="width:150px;"><%= aficion.getNombre()%></td>
                                                <td style="width:150px;"></td>
                                                <td style="width:150px;"></td>
                                                <td style="width:150px;"></td>
                                                <td><a href="EditarAficion?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-pencil"></span></button></a></td>
                                                <td><a href="BorrarAficion?id="><button type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-remove"></span></button></a></td>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                            <%
                                                }//END DEL IF(1==0) <-------------------------------------OJOOOOOOOOOOOOOOOOOOOOOO
                                            %>
                                    <div class="spacing"></div>
                                    <button id="singlebutton" name="singlebutton" class="btn btn-info btn-sm pull-right" value="<%=contacto.getId()%>">Guardar cambios</button>
                                    <button id="singlebutton" name="singlebutton" class="btn btn-default btn-sm pull-right">Cancelar</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>