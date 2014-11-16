<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                    <h3>The rules of the game are as follow: </h3>
                    <ol>
                        <li>Each round the program rolls a virtual pair of dice for the user</li>
                        <li>If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1</li>
                    </ol>
                    <form action="lsresponse" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="dollarLbl" class="col-md-3 control-label">How many dollars do you have?</label>
                            <div class="col-md-3">
                                <input type="text" name="moneyStr" class="form-control" placeholder="enter dollar amount"
                                       value="${param.moneyStr}"/>
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
