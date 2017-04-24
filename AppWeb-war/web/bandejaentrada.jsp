<%-- 
    Document   : bandejaEntrada
    Created on : 22-abr-2017, 11:37:22
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        <div class="container bootstrap snippet middlePage" style="margin-top: 5%; width: 80%; height: auto;">
            <div class="row">
                <a href="#" class="btn btn-info  send-message-btn" role="button"><i class="fa fa-search"></i> Search</a>
                <a href="#" class="btn btn-info  send-message-btn" role="button"><i class="fa fa-gears"></i> Settings</a>
            </div>
            <div class="row" >
                <div class="conversation-wrap col-md-3" style=" background-color: whitesmoke;">
                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle"  style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/user_2.jpg">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Michael clarkt</h5>
                            <small class="text-muted">Lorem ipsum dolor...</small>
                        </div>
                    </div>

                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle"  style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/user_1.jpg">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Pauline mothg</h5>
                            <small class="text-muted">Cras commodo...</small>
                        </div>
                    </div>

                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle" style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/user_3.jpg">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Manuel mcKlein</h5>
                            <small class="text-muted">Cras sit amet...</small>
                        </div>
                    </div>

                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle" style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/User_for_snippets.png">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Markt prame</h5>
                            <small class="text-muted">Morbi felis...</small>
                        </div>
                    </div>

                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle"style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/user-453533-fdadfd.png">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Bort snudert</h5>
                            <small class="text-muted">Vivamus semper...</small>
                        </div>
                    </div>

                    <div class="media conversation">
                        <a class="pull-left" href="#">
                            <img class="media-object img-circle" style="width: 50px; height: 50px;" src="http://bootdey.com/img/Content/HexGames349.jpg">
                        </a>
                        <div class="media-body">
                            <h5 class="media-heading">Maria monthg</h5>
                            <small class="text-muted">cursus ac...</small>
                        </div>
                    </div>
                </div>



                <div class="message-wrap col-md-8" style=" background-color: whitesmoke;">
                    <div class="msg-wrap">
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
                        <div class="alert alert-info msg-date">
                            <strong>Today</strong>
                        </div>
                        <div class="media msg">
                            <a class="pull-left" href="#">
                                <img class="media-object   img-circle" style="width: 32px; height: 32px;" src="http://bootdey.com/img/Content/user_2.jpg">
                            </a>
                            <div class="media-body">
                                <small class="pull-right time"><i class="fa fa-clock-o"></i> 12:10am</small>
                                <h5 class="media-heading">Pauline mothg</h5>
                                <small class="col-md-10 text-muted">Interdum et malesuada fames ac ante ipsum primis in faucibus. In at lacus ac velit vehicula elementum at a lorem. Nullam quis augue sodales, porttitor orci non"</small>
                            </div>
                        </div>

                        <div class="media msg">
                            <a class="pull-left" href="#">
                                <img class="media-object  img-circle" data-src="holder.js/64x64" alt="64x64" style="width: 32px; height: 32px;" src="http://bootdey.com/img/Content/user_2.jpg">
                            </a>
                            <div class="media-body">
                                <small class="pull-right time"><i class="fa fa-clock-o"></i> 12:10am</small>
                                <h5 class="media-heading">Pauline mothg</h5>
                                <small class="col-md-10 text-muted">consectetur dui. Quisque lacinia vitae lectus placerat dictum. Integer tristique sem a risus egestas, ac accumsan ligula volutpat. Donec at convallis elit"</small>
                            </div>
                        </div>

                        <div class="media msg">
                            <a class="pull-left" href="#">
                                <img class="media-object img-circle" style="width: 32px; height: 32px;" src="http://bootdey.com/img/Content/user_2.jpg">
                            </a>
                            <div class="media-body">
                                <small class="pull-right time"><i class="fa fa-clock-o"></i> 12:10am</small>
                                <h5 class="media-heading">Pauline mothg</h5>
                                <small class="col-md-10 text-muted">Cras commodo ante sit amet nulla porta, sed feugiat lectus accumsan. Maecenas luctus est sed dignissim mattis. Mauris ullamcorper hendrerit est in pharetra text-muted"</small>
                            </div>
                        </div>
                    </div>

                    <div class="send-wrap ">
                        <textarea class="form-control send-message" rows="3" placeholder="Write a reply..."></textarea>
                    </div>
                    <div class="btn-panel">
                        <button class="btn btn-success" role="button">
                            <i class="fa fa-share"></i> Send Message
                        </button>
                    </div>
                </div>
            </div>
        </div>                
    </body>
</html>
