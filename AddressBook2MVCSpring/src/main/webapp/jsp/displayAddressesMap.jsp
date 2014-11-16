<%-- 
    Document   : displayAddressesMap
    Created on : Oct 16, 2014, 10:50:17 AM
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
                        <table style="width:90%">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Street</th>    
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Zip</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${byStateMap}" var="entry">
                                    <tr>
                                        <td colspan="7"><hr></td>
                                    </tr>
                                    <tr>
                                        <td colspan="7">${entry.key}</td>
                                    </tr>
                                    <tr>
                                        <td colspan="7"><hr></td>
                                    </tr>
                                    <c:forEach items="${entry.value}" var="item" varStatus="loop">                                       
                                        <tr>
                                        <td>${item.firstName}</td>
                                        <td>${item.lastName}</td>
                                        <td>${item.street}</td>
                                        <td>${item.city}</td>
                                        <td>${item.state}</td>
                                        <td>${item.zipCode}</td>
                                        <td>
                                            <a href="editAddressForm?addressId=${item.addressId}">Edit</a>|
                                            <a href="deleteAddress?addressId=${item.addressId}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach><br>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>                    
                </div>
                <jsp:include page="footer.jsp"/> 
            </div>
        </div>
    </body>
</html>
