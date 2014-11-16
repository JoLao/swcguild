<%-- 
    Document   : addDvdForm
    Created on : Oct 17, 2014, 1:55:08 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <c:set var="addActive" value="active"/>
        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="dvdNav.jsp"/>
                    <form action="addDvd" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="videoTypeLbl" class="col-md-3 control-label">Video Format:</label>
                            <div class="col-md-3">
                                <select name="videoType" class="form-control">                            
                                    <option value="BluRay">BluRay</option>
                                    <option value="DVD">DVD</option>
                                </select>    
                            </div>
                            
                        </div>
                        <div class="row form-group">
                            <label for="titleLbl" class="col-md-3 control-label">Movie Title:</label>
                            <div class="col-md-3">
                                <input type="text" name="title" class="form-control" placeholder="enter movie title"
                                       value="${param.title}"/>
                            </div>
                            <label class="control-label">${errorMessage1}</label>
                        </div>                        
                        <div class="row form-group">
                            <label for="releaseDateLbl" class="col-md-3 control-label">Release Date:</label>
                            <div class="col-md-3">
                                <input type="text" name="releaseDate" class="form-control" placeholder="enter a date"
                                       value="${param.releaseDate}"/>
                            </div>
                            <label class="control-label">${errorMessage2}</label>
                        </div>
                        <div class="row form-group">
                            <label for="mpaaRatingLbl" class="col-md-3 control-label">MPAA Rating:</label>
                            <div class="col-md-3">
                               <select name="mpaaRating" class="form-control">                            
                                    <option value="G">General Audiences (G)</option>
                                    <option value="PG">Parental Guidance Suggested (PG)</option>
                                    <option value="PG-13">Parents Strongly Cautioned (PG-13)</option>
                                    <option value="R">Restricted (R)</option>
                                    <option value="NC-17">No One 17 and Under Admitted(NC-17)</option>
                                </select>   
                            </div>                            
                        </div>
                        <div class="row form-group">
                            <label for="directorLbl" class="col-md-3 control-label">Director:</label>
                            <div class="col-md-3">
                                <input type="text" name="director" class="form-control" placeholder="enter a name"
                                       value="${param.director}"/>
                            </div>
                            <label class="control-label">${errorMessage3}</label>
                        </div>
                        <div class="row form-group">
                            <label for="studioLbl" class="col-md-3 control-label">Studio:</label>
                            <div class="col-md-3">
                                <input type="text" name="studio" class="form-control" placeholder="enter studio name"
                                       value="${param.studio}"/>
                            </div>
                            <label class="control-label">${errorMessage4}</label>
                        </div>           
                        <div class="row form-group">
                            <label for="reviewsLbl" class="col-md-3 control-label">Reviews:</label>
                            <div class="col-md-3">
                                <textarea name="reviews" class="form-control" placeholder="enter reviews"
                                          value="${param.reviews}" rows="4" cols="50"></textarea>
                            </div>
                            <label class="control-label">${errorMessage5}</label>
                        </div>    
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </form>
                    <c:if test="${param.message == true}">
                        <div class="col-md-offset-3 col-md-8">
                            <label for="message" class="col-md-8 control-label">DVD added successfully</label>
                        </div>
                    </c:if>
                </div>
                <jsp:include page="footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
