<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>Site Map Spring MVC Lab</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">                
                <c:set var="luckySevenActive" value="active"/>
                <jsp:include page="header.jsp"/> 
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>         
                    
                    You are broke after&nbsp;${totalRolls}&nbsp; rolls<br>
                    You should have quit after&nbsp;${rollsMostMoney}&nbsp;rolls when you had $${mostMoney}
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
