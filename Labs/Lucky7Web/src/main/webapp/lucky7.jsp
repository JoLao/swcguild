<%-- 
    Document   : lucky7
    Created on : Oct 9, 2014, 10:44:50 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Lucky 7</title>
    </head>
    <body>
        <h1>Lucky 7</h1>
        You are broke after&nbsp;${totalRolls}&nbsp; rolls<br>
        You should have quit after&nbsp;${rollsMostMoney}&nbsp;rolls when you had $${mostMoney}
    </body>
</html>
