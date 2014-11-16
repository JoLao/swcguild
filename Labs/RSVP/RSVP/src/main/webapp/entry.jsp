<%-- 
    Document   : entry
    Created on : Oct 8, 2014, 11:19:14 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>You're Invited!</title>
    </head>
    <body>
        <h1>I'm Having a Party and You're Invited</h1>
        
        <h2>Can You Attend?</h2>
        
        <form action="RSVPServlet" method="post">
            Answer: <input type="text" name="answer" value="${param.answer}"/><br/>
            <%--Number Attending: <input type="text" name="numAttending" value="${param.numAttending}"/>${errorMessage}<br/>--%>
            Number Attending: 
            <select name="numAttending">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            ${errorMessage}<br/>
            <input type="submit" value="RSVP"/>
        </form>
    </body>
</html>
