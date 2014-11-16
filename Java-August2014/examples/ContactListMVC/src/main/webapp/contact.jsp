<%-- 
    Document   : contact
    Created on : Nov 6, 2014, 9:48:27 AM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <h1>Contact List</h1>
        
        <h2>Contacts</h2>
        <div id="contact-list"></div>
        
        <h2>Contact Details</h2>
        <div>
            <p id="detail-firstName"></p>
            <p id="detail-lastName"></p>
            <p id="detail-company"></p>
            <p id="detail-phone"></p>
            <p id="detail-email"></p>
            <hr/>
        </div>
        
        <h2>Edit Contact</h2>
        <div>
            First Name: <input id="edit-firstName" type="text"/><br/>
            Last Name: <input id="edit-lastName" type="text"/><br/>
            Company: <input id="edit-company" type="text"/><br/>
            Phone: <input id="edit-phone" type="text"/><br/>
            Email: <input id="edit-email" type="text"/><br/>
            <input id="edit-contactId" type="hidden"/>
            <input id="editButton" type="submit" value="Edit"/><br/>
            <hr/>            
        </div>
        
        <h2>Add New Contact</h2>
        <div>
            First Name: <input id="add-firstName" type="text"/><br/>
            Last Name: <input id="add-lastName" type="text"/><br/>
            Company: <input id="add-company" type="text"/><br/>
            Phone: <input id="add-phone" type="text"/><br/>
            Email: <input id="add-email" type="text"/><br/>
            <input id="addButton" type="submit" value="Add"/><br/>
            <hr/>            
        </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/contact.js"></script>
    </body>
</html>
