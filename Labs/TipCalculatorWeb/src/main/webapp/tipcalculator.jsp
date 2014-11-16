<%-- 
    Document   : tipcalculator
    Created on : Oct 9, 2014, 7:51:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Tip Calculator</title>
    </head>
    <body>
        <h1>Tip Calculator</h1>
        Amount : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${dollarValue}"/><br>
        Tip %  : &nbsp;<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${tipPercentage}"/><br>
        Tip    : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${tip}"/><br>
        Total  : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${total}"/><br>
    </body>
</html>
