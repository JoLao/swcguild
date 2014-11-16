<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.theme.css"/>
        <title>Site Map</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading" align="center">
                    <div class="col-xs-1" ><img src="images/swcg_sm_logo.png" alt="SWCG Logo" align="left" /></div>
                    <h2 align="center">Software Craftsmanship Guild Java Cohort</h2>
                    <h3 align="center">Jsp Site Lab</h3>
                </div>
                <div class="panel-body">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
                                <ul class="nav nav-tabs" role="tablist">
                                    <li><a href="index.jsp">Home</a></li>
                                    <li class="active"><a href="luckyseven.jsp">Lucky Sevens</a></li>
                                    <li><a href="factorizer.jsp">Factorizer</a></li>
                                    <li><a href="interestcalc.jsp">Interest Calculator</a></li>
                                    <li><a href="flooringcalc.jsp">Flooring Calculator</a></li>
                                    <li><a href="tipcalc.jsp">Tip Calculator</a></li>
                                    <li><a href="converter.jsp">Unit Converter</a></li>
                            </div>
                        </div>                        
                    </nav>                    
                    <h3>The rules of the game are as follow: </h3>
                    <ol>
                        <li>Each round the program rolls a virtual pair of dice for the user</li>
                        <li>If the sum of the 2 dice is equal to 7, the play wins $4; else the play loses $1</li>
                    </ol>
                    <form action="LuckySevensServlet" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="dollarLbl" class="col-md-3 control-label">How many dollars do you have?</label>
                            <div class="col-md-3">
                                <input type="text" name="moneyStr" class="form-control" placeholder="enter dollar amount"
                                       value="${param.moneyStr}"/>
                            </div>
                            <label class="control-label">${errorMessage}</label>
                        </div>
                        
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Compute</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer" align="center" >
                    Created by Josephine Lao 2014<br>
                    Powered by Java and Bootstrap
                </div>
            </div>
        </div>
    </body>
</html>
