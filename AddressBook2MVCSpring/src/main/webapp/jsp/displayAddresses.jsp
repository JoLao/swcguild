<%-- 
    Document   : displayAddresses
    Created on : Oct 15, 2014, 7:54:18 PM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="addressNav.jsp"/>

                    <div class="col-md-offset-2 col-md-10">
                        <table style="width:80%">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Street</th>    
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Zip</th>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Action</th>
                                    </sec:authorize>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="i" items="${aList}">
                                    <tr>
                                        <td>${i.firstName}</td>
                                        <td>${i.lastName}</td>
                                        <td>${i.street}</td>
                                        <td>${i.city}</td>
                                        <td>${i.state}</td>
                                        <td>${i.zipCode}</td>
                                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <td><a href="editAddressForm?addressId=${i.addressId}">Edit</a>|<a href="deleteAddress?addressId=${i.addressId}">Delete</a></td>
                                        </sec:authorize>
                                    </tr>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>   
                    <div class="col-md-offset-2 col-md-10">
                            <label for="errorMessage" class="col-md-8 control-label">${errorMessage}</label>
                        </div>
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
