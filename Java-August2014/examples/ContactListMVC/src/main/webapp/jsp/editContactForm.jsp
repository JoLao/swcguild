<%-- 
    Document   : editContactForm
    Created on : Oct 14, 2014, 3:22:00 PM
    Author     : apprentice
--%>

<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact Form</title>
    </head>
    <body>
        <h1>Edit Contact</h1>
        ${errorMessage}<br/>
        <sf:form method="post" action="updateContact" modelAttribute="contact">
            <sf:label path="firstName">First Name:</sf:label><sf:input path="firstName" size="15"/>
            <sf:errors path="firstName" cssClass="error"></sf:errors><br/>
            <sf:label path="lastName">Last Name:</sf:label><sf:input path="lastName" size="15"/>
            <sf:errors path="lastName" cssClass="error"></sf:errors><br/>
            <sf:label path="company">Company:</sf:label><sf:input path="company" size="15"/>
            <sf:errors path="company" cssClass="error"></sf:errors><br/>
            <sf:label path="phone">Phone:</sf:label><sf:input path="phone" size="15"/>
            <sf:errors path="phone" cssClass="error"></sf:errors><br/>
            <sf:label path="email">Email:</sf:label><sf:input path="email" size="15"/>
            <sf:errors path="email" cssClass="error"></sf:errors><br/>
            <sf:hidden path="contactId"/>
            <input type="submit" value="Update Contact"/><br/>
        </sf:form>
<!--        
        <form method="post" action="updateContact">
            First Name: <input type="text" name="contactFirstName" value="${contact.firstName}"/><br/>
            Last Name: <input type="text" name="contactLastName" value="${contact.lastName}"/><br/>
            Company: <input type="text" name="contactCompany" value="${contact.company}"/><br/>
            Phone: <input type="text" name="contactPhone" value="${contact.phone}"/><br/>
            Email: <input type="text" name="contactEmail" value="${contact.email}"/><br/>
            <input type="hidden" name="contactId" value="${contact.contactId}"/>
            <input type="submit" value="Edit Contact"/><br/>
        </form>-->
        
    </body>
</html>
