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
        <link rel="stylesheet" href="css/bootstrap.min.css">        
        <title>Interest Calculator</title>
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
        <h1>Interest Calculator</h1>

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

    </body>
</html>
