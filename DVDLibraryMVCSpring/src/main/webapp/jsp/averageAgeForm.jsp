<%-- 
    Document   : computeAvgDvd
    Created on : Oct 19, 2014, 3:50:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>DVD Library</title>
    </head>
    <body>
        <c:set var="avgActive" value="active"/>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="dvdNav.jsp"/>
                    <h1>The average age of the movies in the collection is ${averageAge}</h1>
                </div>
                <jsp:include page="footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
