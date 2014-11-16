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
                             <a href="index"><img src="img/logo-alpha150px.png" alt="SWCG Recreation Center Logo"></a>
                        </div>


                        <div class="col-xs-9">
                            <div style="margin-top: 65px;">
                                <ul class="nav nav-pills">
                                    <li><a href="index"><h4><span class="glyphicon glyphicon-home"></span>&#160; Home</h4></a></li>
                                    <li><a href="Equipment-Services"><h4><span class="glyphicon glyphicon-wrench"></span>&#160; Equipment and Services</h4></a></li>
                                    <li class="active"><a href="Rental-Policy"><h4><span class="glyphicon glyphicon-list-alt"></span>&#160; Rental Policy</h4></a></li>
                                    <li><a href="About-Us"><h4><span class="glyphicon glyphicon-info-sign"></span>&#160; About Us</h4></a></li>
                                </ul>
                            </div></div>
                    </div>
                </div>


                <div class="row"> 

                    <div class="col-xs-9">
                        <div class="panel panel-default">
                            <div class="panel-body"  style="margin-left: 25px; margin-right: 25px;">
                                <div style="height: 25px"></div>
                                <h3 align="center">Rental Policies</h3>
                                <hr />
                                <br />
                                <h4 style="margin-left: 25px;">Rental Time Frame</h4>
                                <ul>
                                    <li>A day rental is 24 hours</li>
                                    <li>A weekend rental is Thursday - Monday</li>
                                    <li>A week rental is 5 consecutive days</li>
                                </ul>
                                <br />
                                <br />
                                <ol>
                                    <li>RESERVATIONS
                                        To reserve equipment, full rental fee must be paid.<br /><br /></li>

                                    <li>CANCELLATIONS: 
                                        <ul><li>No charge if cancelled more than 2 days in advance.</li> 
                                            <li>50% of the fee will be charged if cancelled less than two days in advance. </li>
                                            <li>Refunds will not be available for equipment not picked up.</li>
                                        </ul><br />
                                    </li>

                                    <li>REQUIRED IDENTIFICATION: You must present proper identification (student ID or driver's license) to be able to rent equipment.<br /><br /></li>

                                    <li>EQUIPMENT RETURNS: No equipment will be considered returned until it is inspected. Allow yourself time for this inspection. No refunds for early returns.
                                    Tents-Upon return, you will be required to set up your tents for inspection and drying.<br /><br /></li>

                                    <li>LATE FEE: Equipment returned late will be subject to additional days' rental fees, plus a $10.00 late fee.<br /><br /></li>

                                    <li>CLEANING: Please return items clean and dry. A $10.00 per item cleaning charge will be assessed for items that must be cleaned.<br /><br /></li>

                                    <li>DAMAGE/LOSS: The renter is responsible for costs of repair or replacement.<br /><br /></li>

                                    <li>RESPONSIBILITY: It is responsibility of the renter to know how to use the equipment. The renter may ask a staff member for clarification about 
                                    the proper use of equipment; however, the staff member explanation is not a substitute for proper training from a certified instructor.<br /><br /></li>
                                    
                                    <li>LIABILITY: Each renter of equipment must sign a liability statement when checking out the equipment. The user agrees to pay for any damages or 
                                    loss of equipment and also agrees not to hold the University, and its employees, or the State of Ohio responsible for injuries, 
                                    accidents, or other mishaps which may occur while using the equipment.<br /><br /></li>
                                    
                                </ol>
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