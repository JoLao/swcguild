
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
        <script src="js/charts.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <div class="row"> 
                    <div class="col-xs-3">
                        <a href="index"><img src="img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                    </div>
                    <jsp:include page="Portal-Header.jsp"/>
                </div>
            </div>
            <div class="row"> 
                <div class="col-xs-3">
                    <ul class="nav nav-pills nav-stacked">                       

                        <li><a href="AdminPortalHome">Portal Home</a></li>
                        <li><a href="Check-In-Out">Check-In & Check-Out Equipment</a></li>
                        <li class="active"><a href="Reports">Reports</a></li>
                        <li><a href="Equipment">Equipment</a></li>
                        <li><a href="Equipment-Categories">Equipment Categories</a></li>
                        <li><a href="Events">Events</a></li>
                        <li><a href="Users">Users</a></li>
                    </ul>
                </div>
                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h2 align="center">Late Returns By Product</h2> 
                            <hr/>
                            
                            
                            
                            <div id="chartDivD"></div>
                            
                            
                            
                            
                            
                            <div style="height: 25px"></div>
                        </div>
                    </div>
                </div>
                <jsp:include page="../User-Pane.jsp"/>
                <div style="height: 25px"></div>
            </div>
            <jsp:include page="footer.jsp"/>
        </div>
        
        
        
         <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script>
                google.load('visualization', '1.0', {'packages':['corechart']});
        </script>
        <script src="${pageContext.request.contextPath}js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}js/charts.js"></script>
    </body>
</html>
