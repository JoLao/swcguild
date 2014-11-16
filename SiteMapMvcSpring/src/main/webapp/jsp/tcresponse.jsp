<%-- 
    Document   : tipcalculator
    Created on : Oct 9, 2014, 7:51:53 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>Site Map Spring MVC Lab</title>
    </head>
    <body>
        <div class="container">
            <c:set var="tipCalcActive" value="active"/>
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/> 
                
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>                       
                   
                    Amount : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${dollarValue}"/><br>
                    Tip %  : &nbsp;<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${tipPercentage}"/><br>
                    Tip    : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${tip}"/><br>
                    Total  : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${total}"/><br>
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
