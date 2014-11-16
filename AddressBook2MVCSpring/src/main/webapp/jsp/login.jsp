<%-- 
    Document   : login
    Created on : Oct 28, 2014, 1:34:57 PM
    Author     : apprentice
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css"/>
        <title>Address Book</title>
    </head>
    <body>        
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="col-xs-1" ><img src="images/swcg_sm_logo.png" alt="SWCG Logo" align="left" /></div>
                    <h2 align="center">Software Craftsmanship Guild Java Cohort</h2>
                    <h3 align="center">Address Book MVC Spring Lab</h3>                    
                </div>                 
                <div class="panel-body">                    
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="active"><a href="index.jsp">Home</a></li>                                                                        
                                </ul>

                            </div>
                        </div>                        
                    </nav>


                    <h2>Address Book MVC Spring Lab</h2>                    
                    <hr>                   
                    <div class="container">
                        <div class="col-md-offset-3 col-md-8">
                            <h3>Log in</h3>
                        </div>
                    </div>
                    <!-- #2 - Post to Spring security to check our authentication -->
                    <form method="post" class="signin" action="j_spring_security_check">
                        <fieldset>
                            <div class="row form-group">
                                <label for="username" class="col-md-3 control-label" align="right">
                                    Username:
                                </label>

                                <div class="col-md-3">
                                    <input id="username_or_email"
                                           name="j_username"
                                           type="text" 
                                           class="form-control" placeholder="enter user name"/> 
                                </div>
                            </div>
                            <div class="row form-group">
                                <label for="password" class="col-md-3 control-label" align="right">
                                    Password:
                                </label>

                                <!-- #2b - must be j_password for Spring -->
                                <div class="col-md-3">
                                    <input id="password"
                                           name="j_password" 
                                           type="password" 
                                           class="form-control" placeholder="enter password"/> 
                                </div>
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-8">
                                        <br>
                                    </div>
                                </div>                                
                                <div class="form-group">
                                    <div class="col-md-offset-3 col-md-8">
                                        <input name="commit" type="submit" value="Sign In" />
                                    </div>
                                </div>

                        </fieldset>
                    </form>
                    <c:if test="${param.login_error == 1}">
                        <h3>Wrong id or password!</h3>
                    </c:if>
                    <!-- #3 - just puts focus in the username field when page loads -->
                    <script type="text/javascript">
                        document.getElementById('username').focus();
                    </script>
                </div>
                <jsp:include page="footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
