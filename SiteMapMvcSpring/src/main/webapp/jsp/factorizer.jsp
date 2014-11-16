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
            <c:set var="factorizerActive" value="active"/>
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>  
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>  
                          
                    <form action="factresponse" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="qtyLbl" class="col-md-3 control-label">What number would you like to factor?</label>
                            <div class="col-md-3">
                                <input type="text" name="numStr" class="form-control" placeholder="enter a number" 
                                       value="${param.numStr}"/>
                            </div>
                            <label class="control-label">${errorMessage}</label>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Compute</button>
                            </div>
                        </div>
                    </form>
                </div>
                        
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>

