<%-- 
    Document   : AdminPortalHome
    Created on : Oct 22, 2014, 3:16:49 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SWCG Recreation Center Admin Portal</title>
        <meta name="description" content="Admin Portal">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <div class="row"> 

                    <div class="col-xs-3">
                        <a href="index"><img src="img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                    </div>

                    <jsp:include page="../Headers-Footers/Portal-Header.jsp"/>

                </div>
            </div>

            <div class="row"> 

                <div class="col-xs-3">

                    <ul class="nav nav-pills nav-stacked">                       

                        <li><a href="AdminPortalHome">Portal Home</a></li>
                        <li><a href="Check-In-Out">Check-In & Check-Out Equipment</a></li>
                        <li><a href="Reports">Reports</a></li>
                        <li><a href="Equipment">Equipment</a></li>
                        <li><a href="Equipment-Categories">Equipment Categories</a></li>
                        <li class="active"><a href="Events">Events</a></li>
                        <li><a href="Users">Users</a></li>

                    </ul>

                </div>



                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h2 align="center">Events</h2>
                            <hr />
                            <div style="height: 25px"></div>

                            <a href="displayEventList"><button type="button" class="btn btn-default btn-lg btn-block">View All Events</button></a>
                            <br />
                            <a href="addEventForm"><button type="button" class="btn btn-default btn-lg btn-block">Add New Event</button></a>
                            <br />
                           <a href="displayEventList"> <button type="button" class="btn btn-default btn-lg btn-block">Edit Event</button></a>
                            <br />
                            <a href="displayEventList"><button type="button" class="btn btn-default btn-lg btn-block">Remove Event</button></a>


                            <div style="height: 25px"></div>
                        </div>
                    </div>


                </div>
                <jsp:include page="User-Pane.jsp"/>

                <div style="height: 25px"></div>
            </div>
            <jsp:include page="../Headers-Footers/footer.jsp"/>
        </div>
    </body>
</html>