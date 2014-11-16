<%-- 
    Document   : addContactForm
    Created on : Oct 14, 2014, 11:07:08 AM
    Author     : apprentice
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contact Form</title>
    </head>
    <body>
        <h1>Contact Information Form</h1>
        ${errorMessage}          
        <sf:form method="post" action="addContact" modelAttribute="contact">    
            <sf:label path="firstName">First Name:</sf:label><sf:input path="firstName" size="15"/>
            <sf:errors path="firstName" cssClass="error"></sf:errors><br>
            <sf:label path="lastName">Last Name:</sf:label><sf:input path="lastName" size="15"/>
            <sf:errors path="lastName" cssClass="error"></sf:errors><br>
            <sf:label path="company">Company:</sf:label><sf:input path="company" size="15"/>
            <sf:errors path="company" cssClass="error"></sf:errors><br>
            <sf:label path="phone">Phone:</sf:label><sf:input path="phone" size="15"/>
            <sf:errors path="phone" cssClass="error"></sf:errors><br>
            <sf:label path="email">Email:</sf:label><sf:input path="email" size="15"/>
            <sf:errors path="email" cssClass="error"></sf:errors><br>
            <sf:hidden path="contactId"/><br>
            <input type="submit" value="Add Contact"/>
        </sf:form>
        <!--        <form action="addContact" method="post">
                    First Name: <input type="text" name="contactFirstName" value="${param.contactFirstName}"/><br>
                    Last Name: <input type="text" name="contactLastName" value="${param.contactLastName}"/><br>
                    Company: <input type="text" name="contactCompany" value="${param.contactCompany}"/><br>
                    Phone: <input type="text" name="contactPhone" value="${param.contactPhone}"/><br>
                    Email: <input type="text" name="contactEmail" value="${param.contactEmail}"/><br>
                    <input type="submit" value="Add Contact"/><br>                
                </form>-->
    </body>
</html>
