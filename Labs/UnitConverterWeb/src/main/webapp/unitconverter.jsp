<%-- 
    Document   : unitconverter
    Created on : Oct 10, 2014, 1:42:05 PM
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
        <title>Unit Converter</title>
    </head>
    <body>
        <h1>Unit Converter</h1>        
        <table>
            <tr>
                <th>Converting</th>
                <td>${param.operation}</td>
            </tr>
            <tr>
                <th>From</th> 
                <td>${from}</td>
            </tr>
            <tr>
                <th>To</th>   
                <td>${to}</td>
            </tr>
            <tr>
                <th>Quantity</th> 
                <td><fmt:formatNumber type="number" value="${quantity}"/></td>
            </tr>
            <tr>
                <th>Answer</th> 
                <td><fmt:formatNumber type="number" value="${answer}"/></td>
            </tr>
        </table>
    </body>
</html>
