<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Unit Converter</title>
    </head>
    <body>
        <h1>Unit Converter</h1>
        <div>Temperature</div>
        <form name="Temperature" action="UnitConverterServlet" method="post">
            Convert what quantity?
            <input type="text" name="quantityStr1" value="${param.quantityStr1}"/>${errorMessage1}<br>
            From :
            <select name="fromTemp">
                <option value="Celsius">Celsius</option>
                <option value="Farenheit">Farenheit</option>
                <option value="Kelvin">Kelvin</option>
            </select>
            To :
            <select name="toTemp">
                <option value="Celsius">Celsius</option>
                <option value="Farenheit">Farenheit</option>
                <option value="Kelvin">Kelvin</option>
            </select>
            <input type="hidden" name="operation" value="temperature"/><br>
            <input type="submit" name="Convert"/>
        </form>
        <hr>
        <div>Mass</div>
        <form name="Mass" action="UnitConverterServlet" method="post">
            Convert what quantity?
            <input type="text" name="quantityStr2" value="${param.quantityStr2}"/>${errorMessage2}<br>
            From :
            <select name="fromMass">
                <option value="Kilogram">Kilogram</option>
                <option value="Ounce">Ounce</option>
                <option value="Pound">Pound</option>
            </select>
            To :
            <select name="toMass">
                <option value="Kilogram">Kilogram</option>
                <option value="Ounce">Ounce</option>
                <option value="Pound">Pound</option>
            </select>
            <input type="hidden" name="operation" value="mass"/><br>
            <input type="submit" name="Convert"/>
        </form>
        <hr>
        <div>Volume</div>
        <form name="Volume" action="UnitConverterServlet" method="post">
            Convert what quantity?
            <input type="text" name="quantityStr3" value="${param.quantityStr3}"/>${errorMessage3}<br>
            From :
            <select name="fromVolume">
                <option value="Galon">Galon</option>
                <option value="Quart">Quart</option>
                <option value="Pint">Pint</option>
            </select>
            To :
            <select name="toVolume">
                <option value="Galon">Galon</option>
                <option value="Quart">Quart</option>
                <option value="Pint">Pint</option>
            </select>
            <input type="hidden" name="operation" value="volume"/><br>
            <input type="submit" name="Convert"/>
        </form>
    </body>
</html>
