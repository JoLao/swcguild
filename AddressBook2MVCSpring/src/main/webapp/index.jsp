<%-- 
    Document   : index
    Created on : Oct 29, 2014, 3:51:44 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
        <title>Addess Book</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="jsp/header.jsp"/>        

                <div class="panel-body">
                    <%--<jsp:directive.include file="jsp/addressNav.jsp"/>--%>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="${homeActive}"><a href="index">Home</a></li>

                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <li class="${addActive}"><a href="addAddressForm">Add Address</a></li>                       
                                       m </sec:authorize>

                                    <li class="${searchActive}">
                                        <form action="searchAddress" method="get" class="navbar-form navbar-left" role="search">
                                            <select name="search" class="form-control">                            
                                                <option value="listAll">List All</option>
                                                <option value="addressId">Address Id</option>
                                                <option value="lastName">Last Name</option>
                                                <option value="city">City</option>
                                                <option value="state">State</option>
                                                <option value="zip">Zip</option>                                                      
                                            </select>    
                                            <div class="form-group">
                                                <input name="searchStr" type="text" class="form-control" placeholder="Search">
                                            </div>
                                            <button type="submit" class="btn btn-default">Search</button>
                                        </form>
                                    </li>                 
                                    <li align="right"> <a href="<c:url value="j_spring_security_logout" />Sign Out</a></li>
                                </ul>

                            </div>
                        </div>                        
                    </nav>

                    <h2>Address Book MVC Spring Lab</h2>                    
                    <hr>
                    Welcome <sec:authentication property="principal.username" />!<br/>
                </div>
                <jsp:include page="jsp/footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
