<%-- 
    Document   : addressNav
    Created on : Oct 15, 2014, 10:56:40 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="listAllSel" value=""/>
<c:set var="dvdIdSel" value=""/>
<c:set var="titleSel" value=""/>
<c:set var="lastNYearsSel" value=""/>
<c:set var="mpaaRatingSel" value=""/>
<c:set var="director" value=""/>
<c:set var="studio" value=""/>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
            <ul class="nav nav-tabs" role="tablist">
                <c:choose>
                    <c:when test="${inputInd == 'listAll'}">
                        <c:set var="listAllSel" value="selected"/>
                    </c:when>
                    <c:when test="${inputInd == 'dvdId'}">
                        <c:set var="dvdIdSel"  value="selected"/>
                    </c:when>
                    <c:when test="${inputInd == 'title'}">
                        <c:set var="titleSel" value="selected"/>
                    </c:when>
                    <c:when test="${inputInd == 'lastNYears'}">
                        <c:set var="lastNYearsSel" value='selected'/>
                    </c:when>
                    <c:when test="${inputInd == 'mpaaRating'}">
                        <c:set var="mpaaRatingSel" value="selected"/>
                    </c:when>
                    <c:when test="${inputInd == 'director'}">
                        <c:set var="directorSel" value="selected"/>
                    </c:when>
                    <c:when test="${inputInd == 'studio'}">
                        <c:set var="studioSel" value="selected"/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="listAllSel" value="selected"/>
                    </c:otherwise>
                </c:choose>
                <li class="${homeActive}"><a href="../index.jsp">Home</a></li>
                <li class="${addActive}"><a href="addDvdForm">Add DVD</a></li>                       
                <li class=""${avgActive}"><a href="averageAgeForm">Average Age of Movies</a></li>   
                <li class="${searchActive}">
                    <form action="searchDvds" method="get" class="navbar-form navbar-left" role="search">
                        <select name="search" class="form-control">                            
                            <option value="listAll" ${listAllSel}>List All</option>
                            <option value="dvdId" ${dvdIdSel}>DVD Id</option>
                            <option value="title" ${titleSel}>Title</option>
                            <option value="lastNYears" ${lastNYearsSel}>Movies in last n years</option>
                            <option value="mpaaRating" ${mpaaRatingSel}>MPAA Rating</option>
                            <option value="director" ${directorSel}>Director</option>
                            <option value="studio" ${studioSel}>Studio</option>                                                       
                        </select>    
                        <div class="form-group">
                            <input name="searchStr" type="text" class="form-control" placeholder="Search"
                                   value="${param.searchStr}">
                        </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>
                </li>
            </ul>

        </div>
    </div>                        
</nav>
