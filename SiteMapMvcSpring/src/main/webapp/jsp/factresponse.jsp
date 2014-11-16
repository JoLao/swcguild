<%-- 
    Document   : factorizer
    Created on : Oct 9, 2014, 11:08:29 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>Site Map Spring MVC Lab</title>
    </head>
    <body>
        <div class="container">
            <c:set var="factorizerActive" value="active"/>
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>  
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>  
                    <h3>The factors of ${numStr} :</h3>
                    <c:forEach var="num" items="${numList}">
                        <c:out value="${num}"/><br>
                    </c:forEach>
                    <c:if test="${perfectNum == true}">
                        ${numStr}&nbsp; is a perfect number.<br>
                    </c:if>
                    <c:if test="${primeNum == false}">
                        ${numStr}&nbsp; is not a prime number.<br>
                    </c:if>
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
