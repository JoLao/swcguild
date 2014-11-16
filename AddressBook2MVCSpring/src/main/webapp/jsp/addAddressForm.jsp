<%-- 
    Document   : addAddress
    Created on : Oct 15, 2014, 11:10:09 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
        <title>Address Book</title>
    </head>
    <body>
        <c:set var="addActive" value="active"/>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="addressNav.jsp"/>
                    <form action="addAddress" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="firstNameLbl" class="col-md-3 control-label">First Name:</label>
                            <div class="col-md-3">
                                <input type="text" name="firstName" class="form-control" placeholder="enter first name"
                                       value="${param.firstName}"/>
                            </div>
                            <label class="control-label">${errorMessage1}</label>
                        </div>
                        <div class="row form-group">
                            <label for="lastNameLbl" class="col-md-3 control-label">Last Name:</label>
                            <div class="col-md-3">
                                <input type="text" name="lastName" class="form-control" placeholder="enter last name"
                                       value="${param.lastName}"/>
                            </div>
                            <label class="control-label">${errorMessage2}</label>
                        </div>                        
                        <div class="row form-group">
                            <label for="steetAddrLbl" class="col-md-3 control-label">Street:</label>
                            <div class="col-md-3">
                                <input type="text" name="street" class="form-control" placeholder="enter street"
                                       value="${param.street}"/>
                            </div>
                            <label class="control-label">${errorMessage3}</label>
                        </div>
                        <div class="row form-group">
                            <label for="cityLbl" class="col-md-3 control-label">City:</label>
                            <div class="col-md-3">
                                <input type="text" name="city" class="form-control" placeholder="enter city"
                                       value="${param.city}"/>
                            </div>
                            <label class="control-label">${errorMessage4}</label>
                        </div>
                        <div class="row form-group">
                            <label for="stateLbl" class="col-md-3 control-label">State:</label>
                            <div class="col-md-3">
                                <input type="text" name="state" class="form-control" placeholder="enter state"
                                       value="${param.state}"/>
                            </div>
                            <label class="control-label">${errorMessage5}</label>
                        </div>
                        <div class="row form-group">
                            <label for="zipLbl" class="col-md-3 control-label">Zip Code:</label>
                            <div class="col-md-3">
                                <input type="text" name="zip" class="form-control" placeholder="enter zip"
                                       value="${param.zip}"/>
                            </div>
                            <label class="control-label">${errorMessage6}</label>
                        </div>                        
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </form>
                    <c:if test="${param.message == true}">
                        <div class="col-md-offset-3 col-md-8">
                            <label for="message" class="col-md-8 control-label">Address added successfully</label>
                        </div>
                    </c:if>
                </div>
                <jsp:include page="footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
