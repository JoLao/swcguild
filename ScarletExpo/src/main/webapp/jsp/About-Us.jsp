<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>SWCG Recreation Center</title>
        <meta name="description" content="SWCG Recreation Center">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">

    </head>
    <body>

        <div class="container">

            <div class="container-fluid">
                <div class="page-header">
                    <div class="row"> 

                        <div class="col-xs-3">
                            <a href="home"><img src="img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                        </div>


                        <div class="col-xs-9">
                            <div style="margin-top: 65px;">
                                <ul class="nav nav-pills">
                                    <li><a href="index"><h4><span class="glyphicon glyphicon-home"></span>&#160; Home</h4></a></li>
                                    <li><a href="Equipment-Services"><h4><span class="glyphicon glyphicon-wrench"></span>&#160; Equipment and Services</h4></a></li>
                                    <li><a href="Rental-Policy"><h4><span class="glyphicon glyphicon-list-alt"></span>&#160; Rental Policy</h4></a></li>
                                    <li class="active"><a href="About-Us"><h4><span class="glyphicon glyphicon-info-sign"></span>&#160; About Us</h4></a></li>
                                </ul>
                            </div></div>
                    </div>
                </div>


                <div class="row"> 

                    <div class="col-xs-9">
                        <div class="panel panel-default">
                            <div class="panel-body" >
                                <div style="height: 25px"></div>
                                <h3 align="center">About Us</h3>
                                <hr />
                                <br />
                                <div class="row"> 

                                    <div class="col-xs-6">
                                        <p style="margin-left: 25px; margin-right: 25px;">We have a tradition of providing recreational and experiential education opportunities in diverse recreational programs, 
                                            services, and facilities, including: fitness and wellness, intramural sports, club sports, outdoor adventure, aquatics, 
                                            informal open recreation, special events, and student staff development.  We promote physical, emotional, and social 
                                            growth of individuals by encouraging the development of lifelong skills and positive attitudes through recreation activities.
                                            <br /><br />
                                            We are happy that you are here.</p>
                                    </div>
                                    <div class="col-xs-6"><img src="img/sean-cat300px.png" alt="Sean">
                                    </div>
                                </div>
                                <div style="height: 25px"></div>
                            </div>
                        </div>
                    </div>

                    <jsp:include page="Login-Pane.jsp"/>
                </div>


                <div style="height: 25px"></div>
            </div>
            <jsp:include page="Headers-Footers/footer.jsp"/>
        </div>
    </body>
</html>