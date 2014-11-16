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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.theme.css"/>
        <title>Site Map</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading" align="center">
                    <div class="col-xs-1" ><img src="images/swcg_sm_logo.png" alt="SWCG Logo" align="left" /></div>
                    <h2 align="center">Software Craftsmanship Guild Java Cohort</h2>
                    <h3 align="center">Jsp Site Lab</h3>
                </div>
                <div class="panel-body">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li><a href="index.jsp">Home</a></li>
                                    <li><a href="luckyseven.jsp">Lucky Sevens</a></li>
                                    <li><a href="factorizer.jsp">Factorizer</a></li>
                                    <li><a href="interestcalc.jsp">Interest Calculator</a></li>
                                    <li><a href="flooringcalc.jsp">Flooring Calculator</a></li>
                                    <li class="active"><a href="tipcalc.jsp">Tip Calculator</a></li>
                                    <li><a href="converter.jsp">Unit Converter</a></li>
                            </div>
                        </div>                        
                    </nav>
                   
                    Amount : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${dollarValue}"/><br>
                    Tip %  : &nbsp;<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${tipPercentage}"/><br>
                    Tip    : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${tip}"/><br>
                    Total  : &nbsp;<fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${total}"/><br>
                </div>
                <div class="panel-footer" align="center" >
                    Created by Josephine Lao 2014<br>
                    Powered by Java and Bootstrap
                </div>
            </div>
        </div>
    </body>
</html>
