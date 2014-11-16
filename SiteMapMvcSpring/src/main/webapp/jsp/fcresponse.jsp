<%-- 
    Document   : flooringcalculator
    Created on : Oct 9, 2014, 6:01:40 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>Site Map Spring MVC Lab</title>
    </head>
    <body>
        <div class="container">
            <c:set var="flooringCalcActive" value="active"/>
            <div class="panel panel-default">     
                <jsp:include page="header.jsp"/>     
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>                       
                    
                    Material cost :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${materialCost}"/><br>
                    Labor cost    :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${laborCost}"/><br>
                    Total cost    :&nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${totalCost}"/><br>
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
