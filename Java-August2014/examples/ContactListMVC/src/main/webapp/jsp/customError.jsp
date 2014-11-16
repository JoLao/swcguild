<%-- 
    Document   : customError
    Created on : Oct 29, 2014, 9:43:52 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>An error has occurred...</h1>
        <a href="../index.jsp">Home</a><br/>
        <h3>${errorMessage}</h3>
    </body>
</html>
