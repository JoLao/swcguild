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

                            <h2 align="center">Edit Equipment in Inventory</h2>
                            <hr />
                            <h4 align="center" class="text-success"><strong>${param.message}</strong></h4>
                            <h4 align="center" class="text-danger"><strong>${message}</strong></h4>
                            <div style="height: 25px"></div>
                            <sf:form class="form-horizontal" role="form" method="post" action="editProductItem" modelAttribute="productItem">
                                <sf:input type="hidden" path="productItemId" value="${productItemId}" />
                                <sf:input type="hidden" path="productId" value="${productId}" />
                                <div class="form-group">                                    
                                    <sf:label path="productItemName" class="col-xs-3 control-label">Product Item Name</sf:label>                                     
                                        <div class="col-xs-9">
                                        <sf:input path="productItemName" size="15" class="form-control" placeholder="Product Item Name"/>
                                        <sf:errors path="productItemName" cssClass="error"></sf:errors>
                                        </div>
                                    </div>
                                        <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9">
                                        <div class="checkbox">
                                            <sf:checkbox path="active"/><sf:label path="active">Active<br/></sf:label>
                                        </div> 
                                    </div>
                                </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-9">
                                            <div class="checkbox">
                                            <sf:checkbox path="damaged"/><sf:label path="damaged">Damaged<br/></sf:label>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <div class="col-sm-offset-3 col-sm-9">
                                        <div class="checkbox">
                                            <sf:checkbox path="lost"/><sf:label path="lost">Lost<br/></sf:label>
                                        </div> 
                                    </div>
                                </div>
                                <br />
                                <div align="center">                                    
                                    <a href="editProduct"><button type="submit" class="btn-lg btn-primary">Save</button></a>
                                </div>
                            </sf:form>
                            <br />
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
