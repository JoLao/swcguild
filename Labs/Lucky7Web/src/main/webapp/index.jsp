<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Lucky 7</title>
    </head>
    <body>
        <h1>Lucky 7</h1>
        
        <form action="Lucky7Servlet" method="post">
            How many dollars do you have?
            <input type="text" name="moneyStr" value="${param.moneyStr}"/>&nbsp;&nbsp;${errorMessage}<br>
            <input type="submit" value="start"/>
        </form>
    </body>
</html>
