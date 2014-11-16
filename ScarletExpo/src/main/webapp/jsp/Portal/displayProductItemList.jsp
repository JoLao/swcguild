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
        <title>SWCG Recreation Center Admin Portal</title>
        <meta name="description" content="Add Equipment to Inventory">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    </head>
    <body>
        <c:set var="collapse" value="1"/>
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

                            <h2 align="center">Complete Equipment Items List</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            <h4 align="center" class="text-success"><strong>${param.message}</strong></h4>
                            <h4 align="center" class="text-danger"><strong>${message}</strong></h4>
                            <c:forEach var="productItemView" items="${productItemViewList}">                                
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>
                                                Equipment Name
                                            </th>
                                            <td>${productItemView.productItemName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Active?
                                            </th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${productItemView.active == true}">  
                                                        Yes
                                                    </c:when>
                                                    <c:when test="${productItemView.active == false}">
                                                        No
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Checked Out?
                                            </th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${productItemView.checkedOut == true}">
                                                        Yes
                                                    </c:when>
                                                    <c:when test="${productItemView.checkedOut == false}">
                                                        No
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Damaged?
                                            </th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${productItemView.damaged == true}">
                                                        Yes
                                                    </c:when>
                                                    <c:when test="${productItemView.damaged == false}">
                                                        No
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Lost
                                            </th>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${productItemView.lost == true}">
                                                        Yes
                                                    </c:when>
                                                    <c:when test="${productItemView.lost == false}">
                                                        No
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Notes</th>
                                            <td>
                                                
                                                <div class="panel-group" id="accordion">
                                                    <div class="panel panel-default" id="panel${collapse}">
                                                        <div class="panel-heading">
                                                            <h4 class="panel-title">
                                                                <a data-toggle="collapse" data-target="#collapse${collapse}" 
                                                                   href="#collapseOne" class="collapsed">
                                                                    View All
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapse${collapse}" class="panel-collapse collapse">
                                                            <div class="panel-body">
                                                                <c:forEach var="n" items="${productItemView.notes}">
                                                                    
                                                                        ${n.dateEntered}, ${n.note}<br />
                                                                    
                                                                </c:forEach>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:set var="collapse" value="${collapse+1}"/>
                                            </td>
                                        </tr>
                                        <tr>
                                                                           
                                            <td><a href="editProductItemForm?productItemId=${productItemView.productItemId}">
                                                    <button type="submit" class="btn-lg btn-primary">Edit</button></a></td>
                                    <br />
                                    </tr>
                                    </tbody>
                                </table>
                            </c:forEach>                         

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