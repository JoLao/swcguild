<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SWCG Recreation Center Admin Portal</title>
        <meta name="description" content="Add Equipment to Inventory">
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
                        <li><a href="Check-In-Out">Check-In & Check-Out Equipment</a></li>
                        <li><a href="Reports">Reports</a></li>
                        <li class="active"><a href="Equipment">Equipment</a></li>
                        <li><a href="Equipment-Categories">Equipment Categories</a></li>
                        <li><a href="Events">Events</a></li>
                        <li><a href="Users">Users</a></li>
                    </ul>
                </div>
                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h2 align="center">Add New Event</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            <form class="form-horizontal" role="form" method="POST" action="addEvent" >
                                <div class="form-group">
                                    <label for="eventDesc" class="col-xs-3 control-label">Event Description</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="eventDesc" name="eventDesc" placeholder="Event Description">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="eventStart" class="col-xs-3 control-label">Event Start Date</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="eventStart" name="eventStart" placeholder="Event Start Date">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="eventEnd" class="col-xs-3 control-label">Event End Date</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="eventEnd" name="eventEnd" placeholder="Event End Date">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="returnDate" class="col-xs-3 control-label">Return Date</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="returnDate" name="returnDate" placeholder="Return Date">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="userId" class="col-xs-3 control-label">Associated User ID</label>
                                    <div class="col-xs-9">
                                        <input type="text" class="form-control" id="userId" name="userId" placeholder="User ID">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <sf:label path="userName" class="col-xs-3 control-label">Associated User ID</sf:label>
                                        <div class="col-xs-9">
                                        <sf:select path="userId" class="form-control" id="userName" name="userName">
                                            <c:forEach var="user" items="${users}">
                                                <option value="${user.categoryId}">${user.userId}</option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>
                                
                                
                                <div align="center">
                                    <a href="addEvent"><button type="submit" class="btn-lg btn-primary">Save</button></a>
                                </div>
                            </form>
                            <br />
                            <h4 align="center"><strong>${param.message}
                                    ${message}</strong></h4>
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