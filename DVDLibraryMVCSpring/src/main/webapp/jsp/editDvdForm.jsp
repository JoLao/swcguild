<%-- 
    Document   : editDvdForm
    Created on : Oct 17, 2014, 4:42:46 PM
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

        <div class="container">
            <div class="panel panel-default">
                <jsp:include page="header.jsp"/>                
                <div class="panel-body">
                    <jsp:directive.include file="dvdNav.jsp"/>
                    <form action="editDvd" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="videoTypeLbl" class="col-md-3 control-label">Video Format:</label>
                            <div class="col-md-3">
                                <select name="videoType" class="form-control">  
                                    <c:choose>
                                        <c:when test="${dvd.videoType == 'BluRay'}">                                             
                                            <c:set var="bluRaySel" value="selected"/>
                                            <c:set var="dvdSel" value=""/>
                                        </c:when>
                                        <c:when test="${dvd.videoType == 'DVD'}">
                                            <c:set var="bluRaySel" value=""/>
                                            <c:set var="dvdSel" value="selected"/>
                                        </c:when>
                                    </c:choose>
                                    <option value="BluRay" ${bluRaySel}>BluRay</option>
                                    <option value="DVD" ${dvdSel}>DVD</option>        
                                </select>    
                            </div>

                        </div>
                        <div class="row form-group">
                            <label for="titleLbl" class="col-md-3 control-label">Movie Title:</label>
                            <div class="col-md-3">
                                <input type="text" name="title" class="form-control" placeholder="enter movie title"
                                       value="${dvd.title}"/>
                            </div>
                            <label class="control-label">${errorMessage1}</label>
                        </div>                        
                        <div class="row form-group">
                            <label for="releaseDateLbl" class="col-md-3 control-label">Release Date:</label>
                            <div class="col-md-3">
                                <input type="text" name="releaseDate" class="form-control" placeholder="enter a date"
                                       value="${dvd.releaseDate}"/>
                            </div>
                            <label class="control-label">${errorMessage2}</label>
                        </div>
                        <div class="row form-group">
                            <label for="mpaaRatingLbl" class="col-md-3 control-label">MPAA Rating:</label>
                            <div class="col-md-3">
                                <select name="mpaaRating" class="form-control">   
                                    <c:choose>
                                        <c:when test="${dvd.mpaaRating == 'G'}">  
                                            <c:set var="gSel" value="selected"/>
                                            <c:set var="pgSel" value=""/>
                                            <c:set var="pg13Sel" value=""/>
                                            <c:set var="rSel" value=""/>
                                            <c:set var="nc17Sel" value=""/>
                                        </c:when>
                                        <c:when test="${dvd.mpaaRating == 'PG'}">  
                                            <c:set var="gSel" value=""/>
                                            <c:set var="pgSel" value="selected"/>
                                            <c:set var="pg13Sel" value=""/>
                                            <c:set var="rSel" value=""/>
                                            <c:set var="nc17Sel" value=""/>
                                        </c:when>
                                        <c:when test="${dvd.mpaaRating == 'PG-13'}">  
                                            <c:set var="gSel" value=""/>
                                            <c:set var="pgSel" value=""/>
                                            <c:set var="pg13Sel" value="selected"/>
                                            <c:set var="rSel" value=""/>
                                            <c:set var="nc17Sel" value=""/>
                                        </c:when>
                                        <c:when test="${dvd.mpaaRating == 'R'}">  
                                            <c:set var="gSel" value=""/>
                                            <c:set var="pgSel" value=""/>
                                            <c:set var="pg13Sel" value=""/>
                                            <c:set var="rSel" value="selected"/>
                                            <c:set var="nc17Sel" value=""/>
                                        </c:when>
                                        <c:when test="${dvd.mpaaRating == 'NC-17'}">  
                                            <c:set var="gSel" value=""/>
                                            <c:set var="pgSel" value=""/>
                                            <c:set var="pg13Sel" value=""/>
                                            <c:set var="rSel" value=""/>
                                            <c:set var="nc17Sel" value="selected"/>
                                        </c:when>
                                    </c:choose>
                                    <option value="G" ${gSel}>General Audiences (G)</option>
                                    <option value="PG" ${pgSel}>Parental Guidance Suggested (PG)</option>
                                    <option value="PG-13" ${pg13Sel}>Parents Strongly Cautioned (PG-13)</option>
                                    <option value="R" ${rSel}>Restricted (R)</option>
                                    <option value="NC-17" ${nc17Sel}>No One 17 and Under Admitted(NC-17)</option>

                                </select>   
                            </div>                            
                        </div>
                        <div class="row form-group">
                            <label for="directorLbl" class="col-md-3 control-label">Director:</label>
                            <div class="col-md-3">
                                <input type="text" name="director" class="form-control" placeholder="enter a name"
                                       value="${dvd.director}"/>
                            </div>
                            <label class="control-label">${errorMessage3}</label>
                        </div>
                        <div class="row form-group">
                            <label for="studioLbl" class="col-md-3 control-label">Studio:</label>
                            <div class="col-md-3">
                                <input type="text" name="studio" class="form-control" placeholder="enter studio name"
                                       value="${dvd.studio}"/>
                            </div>
                            <label class="control-label">${errorMessage4}</label>
                        </div>           
                        <div class="row form-group">
                            <label for="reviewsLbl" class="col-md-3 control-label">Reviews:</label>
                            <div class="col-md-3">
                                <textarea name="reviews" class="form-control" placeholder="enter reviews"
                                          value="${dvd.reviews}" rows="4" cols="50">${dvd.reviews}</textarea>
                            </div>
                            <label class="control-label">${errorMessage5}</label>
                        </div>    
                        <input type="hidden" name="dvdId" value="${dvd.dvdId}"/>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Edit</button>
                            </div>
                        </div>
                    </form>                   
                </div>
                <jsp:include page="footer.jsp"/>    
            </div>
        </div>
    </body>
</html>

