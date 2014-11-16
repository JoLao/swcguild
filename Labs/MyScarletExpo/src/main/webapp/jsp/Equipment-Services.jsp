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
        <script type="text/javascript"><!--
            var image1 = new Image()
            image1.src = "img/volleyball.png"

            var image2 = new Image()
            image2.src = "img/basketball.png"

            var image3 = new Image()
            image3.src = "img/soccerball.png"

            var image4 = new Image()
            image4.src = "img/baseball.png"

            var image5 = new Image()
            image5.src = "img/hockey-puck.png"

            var image6 = new Image()
            image6.src = "img/racket.png"

            var image7 = new Image()
            image7.src = "img/racket.png"

            var image8 = new Image()
            image8.src = "img/tennisball.png"

            var image9 = new Image()
            image9.src = "img/softball.png"

            var image10 = new Image()
            image10.src = "img/football.png"
--></script>
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
                                    <li><a href="index"><h4><span class="glyphicon glyphicon-home"></span>&#160;Home</h4></a></li>
                                    <li class="active"><a href="Equipment-Services"><h4><span class="glyphicon glyphicon-wrench"></span>&#160;Equipment and Services</h4></a></li>
                                    <li><a href="Rental-Policy"><h4><span class="glyphicon glyphicon-list-alt"></span>&#160;Rental Policy</h4></a></li>
                                    <li><a href="About-Us"><h4><span class="glyphicon glyphicon-info-sign"></span>&#160;About Us</h4></a></li>
                                </ul>
                            </div></div>
                    </div>
                </div>


                <div class="row"> 

                    <div class="col-xs-9">
                        <div class="panel panel-default">
                            <div class="panel-body" >
                                <div style="height: 25px"></div>                                
                                <h3 align="center">Equipment and Services</h3>
                                <hr />
                                <br />
                                <div style="margin-left: 25px;">
                                    <img src="images/pentagg.jpg" name="slide" align="right" style="margin-left: 25px; margin-right: 25px;"/>
                                    <script type="text/javascript"><!--
var step = 1;
                                        function slideit()
                                        {
                                            document.images.slide.src = eval("image" + step + ".src");
                                            if (step < 10)
                                                step++;
                                            else
                                                step = 1;
                                            setTimeout("slideit()", 3000);
                                        }
                                        slideit();
--></script>
                                    <p>
                                        SWC Guild Recreation and Fitness Center offers a comprehensive collection of the highest quality outdoor gear on the market. 
                                        Equipment rental is available to the students and faculty/staff of The SWC Guild as well as to the local community.
                                    </p>
                                    <ul>
                                        <li>Quickly check out equipment for your workouts.</li>
                                        <li>Rent out courts and fields for pick-up games or events like fundraisers tournaments.</li>
                                    </ul>
                                </div>

                                <br />



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