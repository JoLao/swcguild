<%-- 
    Document   : displayContacts
    Created on : Oct 8, 2014, 2:52:47 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var="contact" items="${contactList}">
            <hr/>
            <c:out value="${contact.name}"/><br/>
            <c:out value="${contact.phone}"/><br/>
            <c:out value="${contact.email}"/><br/>
        </c:forEach>
    </body>
</html>
