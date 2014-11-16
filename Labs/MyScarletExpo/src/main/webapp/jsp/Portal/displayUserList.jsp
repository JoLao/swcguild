<%-- 
    Document   : AdminPortalHome
    Created on : Oct 22, 2014, 3:16:49 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SWCG Recreation Center User List</title>
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
                            <h2 align="center">Complete User List</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            <c:forEach var="userView" items="${userViewList}">                                
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>
                                                First Name
                                            </th>
                                            <td>${userView.firstName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Last Name
                                            </th>
                                            <td>${userView.lastName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Username
                                            </th>
                                            <td>${userView.userName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Profile Risk Level
                                            </th>
                                            <td>
                                                <c:if test="${userView.profileId == '1' }">
                                                    High
                                                </c:if>
                                                <c:if test="${userView.profileId == '2' }">
                                                    Medium
                                                </c:if>
                                                <c:if test="${userView.profileId == '3' }">
                                                    Low
                                                </c:if>

                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Access Level
                                            </th>
                                            <td>${userView.authority}</td>

                                        </tr>

                                        <tr>
                                            <th>Is Active</th>
                                            <td>
                                                <c:if test="${userView.isActive == true }">
                                                    Yes
                                                </c:if>
                                                    <c:if test="${userView.isActive == false }">
                                                    No
                                                </c:if>

                                            </td>
                                        </tr>
                                        <tr>
                                            <th>User Notes</th>
                                            <td> <c:forEach var="n" items="${userView.userNotes}">

                                                    ${n.dateEntered}, ${n.note}<br />
                                    </c:forEach>
                                            </td>
                                    </tr>


                                    <tr>
                                        <td align="right"><a href="deleteUser?userId=${userView.userId}"><button type="submit" class="btn-lg btn-primary">Delete</button></a></td>                                
                                        <td><a href="editUserForm?userId=${userView.userId}"><button type="submit" class="btn-lg btn-primary">Edit</button></a></td>
                                    <br />
                                    </tr>
                                    </tbody>
                                </table>
                            </c:forEach>
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