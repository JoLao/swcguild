<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Interest Calculator</h1>
        <form action="InterestCalculatorServlet" method="post">
            Annual Interest Rate :                                                  
            <input type="text" name="annualRateStr" value="${param.annualRateStr}"/>${errorMessage1}<br>
            Principal :
            <input type="text" name="principalStr" value="${param.principalStr}"/>${errorMessage2}<br>
            # of Years : 
            <input type="text" name="numYearsStr" value="${param.numYearsStr}"/>${errorMessage3}<br>
            <input type="submit" value="start"/>
        </form>
    </body>
</html>
