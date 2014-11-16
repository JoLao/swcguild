<%-- 
    Document   : chart
    Created on : Oct 22, 2014, 9:20:45 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <title>Google Charts with jQuery</title>
        <script>
        </script>
    </head>
    <body>
        <h1>Displaying Google Charts with jQuery Ajax</h1>
        <a href="index.jsp" class="btn btn-primary">Home</a>
        <hr/>
        
        <div id="chartDiv"></div>
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script>
                google.load('visualization', '1.0', {'packages':['corechart']});
        </script>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jQueryChart.js"></script>
    </body>
</html>
