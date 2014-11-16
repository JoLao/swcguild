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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Factorizer</title>                
    </head>
    <body>
        <h1>The factors of ${numStr} :</h1>
        <c:forEach var="num" items="${numList}">
            <c:out value="${num}"/><br>
        </c:forEach>
        <c:if test="${perfectNum == true}">
            ${numStr}&nbsp; is a perfect number.<br>
        </c:if>
        <c:if test="${primeNum == false}">
            ${numStr}&nbsp; is not a prime number.<br>
        </c:if>
    </body>
</html>
