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

                            <h2 align="center">All Checked-Out Equipment</h2>
                            <hr />
                            <div style="height: 25px"></div>
                            <c:forEach var="productView" items="${productViewList}">                                
                                <table class="table">
                                    <tbody>
                                        <tr>
                                            <th>
                                                Equipment Name
                                            </th>
                                            <td>${productView.productName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Equipment Category
                                            </th>
                                            <td>${productView.categoryName}</td>
                                        </tr>
                                        <tr>
                                            <th>
                                                Equipment Description
                                            </th>
                                            <td>${productView.productDesc}</td>
                                        </tr>
                                        <tr>
                                            <th>Equipment Items</th>
                                            <td>
                                                <div class="panel-group" id="accordion">
                                                    <div class="panel panel-default" id="panel1">
                                                        <div class="panel-heading">
                                                            <h4 class="panel-title">
                                                                <a data-toggle="collapse" data-target="#collapseOne" 
                                                                   href="#collapseOne" class="collapsed">
                                                                    View All
                                                                </a>
                                                            </h4>
                                                        </div>
                                                        <div id="collapseOne" class="panel-collapse collapse">
                                                            <div class="panel-body">
                                                                <c:forEach var="productItemView" items="${productView.productItemView}">
                                                                    <c:forEach var="n" items="${productItemView.notes}">
                                                                        ${n.dateEntered}, ${n.note}<br />
                                                                    </c:forEach>
                                                                </c:forEach>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right"><a href="deleteProduct?productId=${productView.productId}">
                                                    <button type="submit" class="btn-lg btn-primary">Delete</button></a></td>                                
                                            <td><a href="editProductForm?productId=${productView.productId}">
                                                    <button type="submit" class="btn-lg btn-primary">Edit</button></a></td>
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