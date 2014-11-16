<%-- 
    Document   : flooringcalculator
    Created on : Oct 9, 2014, 6:01:40 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">           
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        Material cost :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${materialCost}"/><br>
        Labor cost    :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${laborCost}"/><br>
        Total cost    :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${totalCost}"/><br>
    </body>
</html>
