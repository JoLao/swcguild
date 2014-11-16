
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Scarlet Expo Rentals</title>
        <meta name="description" content="Scarlet Expo Rentals Home Page">
        <script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
        <script src="../js/bootstrap.js"></script>
        <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">


    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <div class="row"> 
                    <div class="col-xs-3">
                        <a href="index.jsp"><img src="../img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                    </div>
                    <div class="col-xs-9">
                        <div style="margin-top: 65px;">
                            <ul class="nav nav-pills">
                                <li><a href="../index.jsp"><h4><span class="glyphicon glyphicon-home"></span> &#160; Home &#160; </h4></a></li>
                                <li><a href="EquipmentServices.jsp"><h4>&#160; Equipment and Services &#160; </h4></a></li>
                                <li><a href="RentalPolicy.jsp"><h4><span class="glyphicon glyphicon-list-alt"></span> &#160; Rental Policy &#160; </h4></a></li>
                                <li><a href="AboutUs.jsp"><h4><span class="glyphicon glyphicon-info-sign"></span> &#160; About Us &#160; </h4></a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>

            <div class="row">
                <div class="col-xs-3">
                    <ul class="nav nav-pills nav-stacked">
                        <li class="active"><a href="#">Portal Home</a></li>
                        <li><a href="#">View Equipment</a></li>
                        <li><a href="#">View Past </a></li>

                    </ul>
                </div>
                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body"  align="center">
                            Employee Portal Home

                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="panel panel-default">
                        <div class="panel-body"  align="center">
                            <div class="panel panel-default">
                                <div class="panel-body"  align="center">
                                    <h1><span class="glyphicon glyphicon-user"></span></h1>

                                </div>
                            </div>
                            <h4>Welcome, user!</h4>
                            <p>Your last visit was on<br />MM-DD-YYYY.</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>



        <div style="height: 25px"></div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>