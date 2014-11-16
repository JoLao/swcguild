<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Tip Calculator</title>
    </head>
    <body>
        <h1>Tip Calculator</h1>
        
        <form action="TipCalculatorServlet" method="post">
            Dollar Value :
            <input type="text" name="dollarValueStr" value="${param.dollarValueStr}"/>${errorMessage1}<br>
            Tip Percentage :
            <input type="text" name="tipPercentageStr" value="${param.tipPercentageStr}"/>${errorMessage2}<br>
            <input type="submit" value="start"/>
        </form>
    </body>
</html>
