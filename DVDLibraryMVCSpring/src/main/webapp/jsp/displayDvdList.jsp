<%-- 
    Document   : displayDvdList
    Created on : Oct 18, 2014, 7:07:58 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:forEach var="i" items="${dvdList}">
    <tr>
        <td>${i.dvdId}</td>
        <td>${i.videoType}</td>
        <td>${i.title}</td>
        <td>${i.releaseDate}</td>
        <td>${i.mpaaRating}</td>
        <td>${i.director}</td>
        <td>${i.studio}</td>
        <td>${i.reviews}</td>
        <td><a href="editDvdForm?dvdId=${i.dvdId}">Edit</a>|<a href="deleteDvd?dvdId=${i.dvdId}">Delete</a></td>
    </tr>
</c:forEach>
