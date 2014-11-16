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
                        <li><a href="Equipment">Equipment</a></li>
                        <li><a href="Equipment-Categories">Equipment Categories</a></li>
                        <li class="active"><a href="Events">Events</a></li>
                        <li><a href="Users">Users</a></li>
                    </ul>
                </div>
                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h2 align="center">Add a New Event</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            <h4 align="center" class="text-success"><strong>${param.message}</strong></h4>
                            <h4 align="center" class="text-danger"><strong>${message}</strong></h4>
                            
                            <sf:form class="form-horizontal" role="form" method="POST" action="addEvent" modelAttribute="event">
                                <div class="form-group">                                    
                                    <sf:label path="eventDesc" class="col-xs-3 control-label">Event Description</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="eventDesc" size="15" class="form-control" placeholder="Description"/>
                                        <sf:errors path="eventDesc" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                    <div class="form-group">                                    
                                    <sf:label path="eventStart" class="col-xs-3 control-label">Event Start Date</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="eventStart" size="15" class="form-control" placeholder="Start Date"/>
                                        <sf:errors path="eventStart" cssClass="error"></sf:errors>${startMsg}
                                        </div>
                                    </div>
                                    <div class="form-group">                                    
                                    <sf:label path="eventEnd" class="col-xs-3 control-label">Event End Date</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="eventEnd" size="15" class="form-control" placeholder="End Date"/>
                                        <sf:errors path="eventEnd" cssClass="error"></sf:errors>${endMsg}
                                        </div>
                                    </div>
                                    <div class="form-group">                                    
                                    <sf:label path="returnDate" class="col-xs-3 control-label">Return Date</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="returnDate" size="15" class="form-control" placeholder="Return Date"/>
                                        <sf:errors path="returnDate" cssClass="error"></sf:errors>${returnMsg}
                                        </div>
                                    </div>

                                    <div class="form-group">
                                    <label path="username" class="col-xs-3 control-label">Associated User</label>
                                        <div class="col-xs-9">
                                        <sf:select path="userId" class="form-control" id="userName">
                                            <c:forEach var="user" items="${users}">
                                                <option value="${user.userId}">${user.userName}</option>
                                            </c:forEach>
                                        </sf:select>
                                    </div>
                                </div>



                                    <div align="center">
                                        <a href="addEvent"><button type="submit" class="btn-lg btn-primary">Save</button></a>
                                    </div>
                                </sf:form>
                                <br />

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