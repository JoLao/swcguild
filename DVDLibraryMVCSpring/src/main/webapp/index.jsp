<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.theme.css"/>
        <title>DVD Library</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="col-xs-1" ><img src="images/swcg_sm_logo.png" alt="SWCG Logo" align="left" /></div>
                    <h2 align="center">Software Craftsmanship Guild Java Cohort</h2>
                    <h3 align="center">DVD Library MVC Spring Lab</h3>                    
                </div>               
                <div class="panel-body">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li class="active"><a href="index.jsp">Home</a></li>
                                    <li><a href="spring/addDvdForm">Add DVD</a></li>                                                           
                                    <li><a href="spring/averageAgeForm">Average Age of Movies</a></li>                                                           
                                    <li>
                                        <form action="spring/searchDvds" method="get" class="navbar-form navbar-left" role="search">
                                            <select name="search" class="form-control">
                                                <option value="listAll">List All</option>
                                                <option value="dvdId">DVD Id</option>
                                                <option value="title">Title</option>
                                                <option value="lastNYears">Movies in last n years</option>
                                                <option value=""mpaaRating">MPAA Rating</option>
                                                <option value="director">Director</option>
                                                <option value="studio">Studio</option>                                                
                                            </select>    
                                            <div class="form-group">
                                                <input name="searchStr" type="text" class="form-control" placeholder="Search">
                                            </div>
                                            <button type="submit" class="btn btn-default">Search</button>
                                        </form>
                                    </li>
                                </ul>
                            </div>
                        </div>                        
                    </nav>


                    <h2>Address Book MVC Spring Lab</h2>                    
                    <hr>
                    <h3>Overview</h3>

                </div>
                <jsp:include page="jsp/footer.jsp"/>    
            </div>
        </div>
    </body>
</html>

