<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SWCG Recreation Center Admin Portal</title>
        <meta name="description" content="Admin Portal">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">

    </head>
    <body>
        <div class="container">
            <div class="page-header">
                <div class="row"> 
                    <div class="col-xs-3">
                        <a href="index"><img src="img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                    </div>
                    <jsp:include page="../Headers-Footers/Portal-Header.jsp"/>
                </div>
            </div>
            <div class="row"> 
                <div class="col-xs-3">
                    <ul class="nav nav-pills nav-stacked">                      

                        <li><a href="AdminPortalHome">Portal Home</a></li>
                        <li class="active"><a href="Check-In-Out">Check-In & Check-Out Equipment</a></li>
                        <li><a href="Reports">Reports</a></li>
                        <li><a href="Equipment">Equipment</a></li>
                        <li><a href="Equipment-Categories">Equipment Categories</a></li>
                        <li><a href="Events">Events</a></li>
                        <li><a href="Users">Users</a></li>
                    </ul>
                </div>

                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h2 align="center">Quick Check-Out</h2>
                            <hr />
                            <div style="height: 25px"></div>

                            <sf:form class="form-horizontal" role="form" method="post" action="processExpressCheckOut" modelAttribute="newEvent">
                                <div align="center">  
                                    <a href="processExpressCheckOut"><button type="submit" class="btn-lg btn-primary">Check Out</button></a>
                                </div>
                                <br />
                                <div class="form-group">
                                    <label path="username" class="col-xs-3 control-label">Associated User</label>
                                        <div class="col-xs-9">
                                        <select path="userId" class="form-control" id="userName" name="userId">
                                            <c:forEach var="user" items="${users}">
                                                <option value="${user.userId}">${user.userName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <h4 align="center">${userMessage}</h4>

                                    <h4 align="center" class="text-success"><strong>${param.message}</strong></h4>
                                <h4 align="center" class="text-danger"><strong>${message}</strong></h4>
                                        <c:forEach var="productView" items="${productCheckOutView.productCheckOutList}"> 
                                    <div class="panel-group" id="accordion">
                                        <div class="panel panel-default" id="panel${collapse}">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">
                                                    <a data-toggle="collapse" data-target="#collapse${collapse}" 
                                                       href="#collapseOne" class="collapsed">
                                                        ${productView.productName}
                                                    </a>
                                                </h4>
                                            </div>
                                            <div id="collapse${collapse}" class="panel-collapse collapse">
                                                <div class="panel-body">

                                                    <div class="form-group">

                                                        <c:forEach var="productItems" items="${productView.productItemView}"> 


                                                            <div class="col-sm-offset-3 col-sm-9">

                                                                <div class="checkbox">
                                                                    <sf:checkbox path="productItemIds" value="${productItems.productItemId}"/>
                                                                    ${productItems.productItemName}                                                                      

                                                                    <br />
                                                                    <br />
                                                                </div>
                                                            </div>

                                                        </c:forEach>



                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <c:set var="collapse" value="${collapse+1}"/>
                                </c:forEach>

                            </sf:form>

                            <div style="height: 25px"></div>
                        </div>
                    </div>
                </div>
                <jsp:include page="User-Pane.jsp"/>
                <div style="height: 25px"></div>
            </div>
            <jsp:include page="../Headers-Footers/footer.jsp"/>
        </div>
    </body>
</html>
