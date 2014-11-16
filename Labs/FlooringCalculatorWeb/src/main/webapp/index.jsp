<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        
        <form action="FlooringCalculatorServlet" method="post">
            Width :
            <input type="text" name="widthStr" value="${param.widthStr}"/>${errorMessage1}<br>
            Length :
            <input type="text" name="lengthStr" value="${param.lengthStr}"/>${errorMessage2}<br>
            Cost :
            <input type="text" name="costStr" value="${param.costStr}"/>${errorMessage3}<br>
            <input type="submit" value="start"/>
        </form>        
    </body>
</html>
