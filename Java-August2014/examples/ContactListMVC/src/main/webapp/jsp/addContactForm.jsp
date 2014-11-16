<%-- 
    Document   : addContactForm
    Created on : Oct 14, 2014, 11:07:08 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contact Form</title>
    </head>
    <body>
        <h1>Contact Information Form</h1>
        
        <form method="post" action="addContact">
            First Name: <input type="text" name="contactFirstName"/><br/>
            Last Name: <input type="text" name="contactLastName"/><br/>
            Company: <input type="text" name="contactCompany"/><br/>
            Phone: <input type="text" name="contactPhone"/><br/>
            Email: <input type="text" name="contactEmail"/><br/>
            <input type="submit" value="Add Contact"/><br/>
        </form>
    </body>
</html>
