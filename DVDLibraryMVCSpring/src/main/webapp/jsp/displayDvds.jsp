<%-- 
    Document   : displayDvds
    Created on : Oct 17, 2014, 3:35:09 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.theme.css"/>
        <title>DVD Library</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="dvdNav.jsp"/>

                    <div class="col-md-12">
                        <table style="width:80%">
                            <thead>
                                <tr>
                                    <th>DVD Id</th>
                                    <th>Video Format</th>
                                    <th>Movie Title</th>
                                    <th>Release Date</th>    
                                    <th>MPAA Rating</th>
                                    <th>Director</th>
                                    <th>Studio</th>
                                    <th>Reviews</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>                                    
                                    <c:when test="${inputInd == 'director'}">
                                        <c:forEach items="${dvdMap}" var="entry">
                                            <tr>
                                                <td colspan="8"><hr></td>
                                            </tr>
                                            <tr>
                                                <td colspan="8">${entry.key}</td>
                                            </tr>
                                            <tr>
                                                <td colspan="8"><hr></td>
                                            </tr>
                                            <c:set var="dvdList" value="${entry.value}"/> 
                                            <jsp:directive.include file="displayDvdList.jsp"/>
                                        </c:forEach>
                                    <hr>Output NOT using streams & lambdas

                                    <c:forEach items="${dvdMap2}" var="entry">
                                        <tr>
                                            <td colspan="8"><hr></td>
                                        </tr>
                                        <tr>
                                            <td colspan="8">${entry.key}</td>
                                        </tr>
                                        <tr>
                                            <td colspan="8"><hr></td>
                                        </tr>
                                        <c:set var="dvdList" value="${entry.value}"/> 
                                        <jsp:directive.include file="displayDvdList.jsp"/>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <jsp:directive.include file="displayDvdList.jsp"/>
                                </c:otherwise>
                            </c:choose>
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
