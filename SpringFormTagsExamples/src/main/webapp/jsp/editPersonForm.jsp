<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/starter-template/ -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="http://getbootstrap.com/assets/ico/favicon.ico">

        <title>Starter Template for Bootstrap</title>

        <!-- Bootstrap core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="../css/starter-template.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body style="">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://getbootstrap.com/examples/starter-template/#">Project name</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="http://getbootstrap.com/examples/starter-template/#">Home</a></li>
                        <li><a href="http://getbootstrap.com/examples/starter-template/#about">About</a></li>
                        <li><a href="http://getbootstrap.com/examples/starter-template/#contact">Contact</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <div class="starter-template">
                <h1>Edit Person Form</h1>

                <sf:form method="POST" action="editPerson" modelAttribute="person">
                    <sf:label path="firstName">First Name:</sf:label><sf:input path="firstName" size="15"/><br/>
                    <sf:label path="lastName">Last Name:</sf:label><sf:input path="lastName" size="15"/><br/>
                        Gender:<br/>
                    <sf:label path="gender">Male:</sf:label><sf:radiobutton path="gender" value="M"/> | 
                    <sf:label path="gender">Female:</sf:label><sf:radiobutton path="gender" value="F"/><br/>
                    <sf:label path="dateOfBirth">Birthdate:</sf:label><sf:input path="dateOfBirth"/><br/>
                    <sf:label path="department">Department:</sf:label><sf:select path="department" items="${depts}"/><br/>
                    <sf:label path="hobbies">Hobbies:</sf:label>
                        <ul>
                        <sf:checkboxes element="li" path="hobbies" items="${hobbyList}"/>
                    </ul>
                    <sf:label path="active">Active?:</sf:label><sf:checkbox path="active"/><br/>
                        <input type="submit" value="Edit Person"/>


                </sf:form>
            </div>

        </div><!-- /.container -->


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="../js/jquery-1.11.0.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>


    </body></html>