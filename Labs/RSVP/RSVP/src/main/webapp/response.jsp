<%-- 
    Document   : response
    Created on : Oct 8, 2014, 11:59:18 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Response</title>
    </head>
    <body>
        <h1>Response</h1>
        <p>Your answer was: ${param.answer}</p>
        <p>Message: ${message}</p>
    </body>
</html>
