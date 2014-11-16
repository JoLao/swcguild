<%-- 
    Document   : interestcalculator
    Created on : Oct 9, 2014, 1:01:20 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">  
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>Site Map Spring MVC Lab</title>        
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 5px;
                text-align: center;
            }
        </style>
    </head>  
    <body>
        <div class="container">
            <c:set var="interestCalcActive" value="active"/>
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>  
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>               

                    <table style="width:80%">
                        <thead>
                            <tr>
                                <th>Year #</th>
                                <th>Beginning<br>Principal</th>
                                <th>Interest</th>    
                                <th>Ending<br>Principal</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="${interestTable}">
                                <tr>
                                    <td><fmt:formatNumber type="number" value="${i.year}"/></td>
                                    <td><fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${i.begPrincipal}"/></td>
                                    <td><fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${i.interest}"/></td>
                                    <td><fmt:formatNumber type="currency" minFractionDigits="2" maxFractionDigits="2" value="${i.endPrincipal}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
