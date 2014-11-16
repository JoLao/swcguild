<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
        <title>Addess Book</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>        

                <div class="panel-body">
                    <jsp:directive.include file="addressNav.jsp"/>
                    <h2>Address Book MVC Spring Lab</h2>                    
                    <hr>
                    Welcome <sec:authentication property="principal.username" />!<br/>
                </div>
                <jsp:include page="jsp/footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
