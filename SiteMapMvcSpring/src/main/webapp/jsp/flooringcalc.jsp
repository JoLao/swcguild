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
            <c:set var="flooringCalcActive" value="active"/>
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                 
                <div class="panel-body">
                    <jsp:directive.include file="siteMapNav.jsp"/>   

                    <form action="fcresponse" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">                        
                            <label for="widthLbl" class="col-md-3 control-label">Width :</label>
                            <div class="col-md-3">
                                <input type="text" name="widthStr" class="form-control" placeholder="enter a number" 
                                       value="${param.widthStr}"/>
                            </div>

                            <label class="control-label">${errorMessage1}</label>
                        </div>
                        <div class="row form-group">
                            <label for="lengthLbl" class="col-md-3 control-label">Length :</label>
                            <div class="col-md-3">
                                <input type="text" name="lengthStr" class="form-control" placeholder="enter a number" 
                                       value="${param.lengthStr}"/>
                            </div>

                            <label class="control-label">${errorMessage2}</label>
                        </div>
                        <div class="row form-group">
                            <label for="costLbl" class="col-md-3 control-label">Cost :</label>
                            <div class="col-md-3">
                                <input type="text" name="costStr" class="form-control" placeholder="enter a number" 
                                       value="${param.costStr}"/>
                            </div>

                            <label class="control-label">${errorMessage3}</label>
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
