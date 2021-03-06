<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- #1 - Directive for Spring Form tag libraries -->
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
                        <li><a href="Events">Events</a></li>
                        <li class="active"><a href="Users">Users</a></li>
                    </ul>
                </div>

                <div class="col-xs-6">
                    <div class="panel panel-default">
                        <div class="panel-body">

                            <h2 align="center">Edit an Existing User</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            
                            <sf:form class="form-horizontal" role="form" method="post" action="editUser" modelAttribute="user">
                                <sf:input type="hidden" path="userId" value="${userId}" />
                                <div class="form-group">                                    
                                    <sf:label path="userName" class="col-xs-3 control-label">Username</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="userName" size="15" class="form-control" placeholder="Username"/>
                                        <sf:errors path="userName" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                        <div class="form-group">                                    
                                    <sf:label path="userPass" class="col-xs-3 control-label">Password</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="userPass" size="15" class="form-control" placeholder="Password"/>
                                        <sf:errors path="userPass" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                <div class="form-group">                                    
                                    <sf:label path="firstName" class="col-xs-3 control-label">First Name</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="firstName" size="15" class="form-control" placeholder="First Name"/>
                                        <sf:errors path="firstName" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                    <div class="form-group">                                    
                                    <sf:label path="lastName" class="col-xs-3 control-label">Last Name</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="lastName" size="15" class="form-control" placeholder="Last Name"/>
                                        <sf:errors path="lastName" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9">
                                        <div class="checkbox">
                                            <sf:label path="lost">
                                                    <input type="checkbox" 
                                                    <c:if test="${productItemView.lost == false}"></c:if>
                                                    <c:if test="${productItemView.lost == true}">checked="checked"</c:if>/>
                                                Is Lost
                                            </sf:label>
                                        </div> 
                                    </div>
                                </div>

                                    <div align="center">                                    
                                        <a href="editUser"><button type="submit" class="btn-lg btn-primary">Save</button></a>
                                    </div>
                            </sf:form>
                            <h4><strong>${param.message}
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