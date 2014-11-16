<%-- 
    Document   : addUserForm
    Created on : Nov 11, 2014, 9:05:37 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Users</title>
    </head>
    <body>
        <h1>Add User Form</h1>

        <form method="POST" action="addUser">
            Username: <input type="text" name="username"/><br/>
            Password:&nbsp; <input type="password" name="password"/><br/>
            Admin User? <input type="checkbox" name="isAdmin" value="yes"/> <br/>
            <input type="submit" value="Add User"/><br/>
        </form>
    </body>
</html>
