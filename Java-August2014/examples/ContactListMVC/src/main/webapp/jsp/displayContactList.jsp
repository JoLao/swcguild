<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <h1>Company Contacts</h1>
        Hello <sec:authentication property="principal.username" />!<br/>
        <a href="<c:url value="../j_spring_security_logout" />" > Logout</a><br/>
        
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="displayNewContactForm">Add A Contact</a></p>
        </sec:authorize>
        <hr/>
        
        <c:forEach var="contact" items="${contactList}">
            <p>
                First Name: ${contact.firstName} 
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                | 
                <a href="deleteContact?contactId=${contact.contactId}">Delete</a> | 
                <a href="editContactForm?contactId=${contact.contactId}">Edit</a>
                </sec:authorize><br/>
            Last Name: ${contact.lastName}<br/>
            Company: ${contact.company}<br/>
            Phone: ${contact.phone}<br/>
            Email: ${contact.email}<br/>
            </p>
        </c:forEach>
    </body>
</html>
