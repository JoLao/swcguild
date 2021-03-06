<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                                    <li><a href="luckyseven.jsp">Lucky Sevens</a></li>
                                    <li><a href="factorizer.jsp">Factorizer</a></li>
                                    <li><a href="interestcalc.jsp">Interest Calculator</a></li>
                                    <li><a href="flooringcalc.jsp">Flooring Calculator</a></li>
                                    <li><a href="tipcalc.jsp">Tip Calculator</a></li>
                                    <li class="active"><a href="converter.jsp">Unit Converter</a></li>
                            </div>
                        </div>                        
                    </nav>                    

                    <h4>Temperature</h4>

                    <form name="Temperature" action="UnitConverterServlet" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="qtyLbl" class="col-md-3 control-label">Convert what quantity?</label>
                            <div class="col-md-3">
                                <input type="text" name="quantityStr1" class="form-control" placeholder="enter quantity"
                                       value="${param.quantityStr1}"/>

                            </div>
                            <label class="control-label">${errorMessage1}</label>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-offset-3 col-md-6">
                                <label for="fromLbl" class=" control-label">From :</label>

                                <select name="fromTemp" class=form-control">
                                    <option value="Celsius">Celsius</option>
                                    <option value="Farenheit">Farenheit</option>
                                    <option value="Kelvin">Kelvin</option>
                                </select>

                                <label for="toLbl" class="control-label">To :</label>

                                <select name="toTemp">
                                    <option value="Celsius">Celsius</option>
                                    <option value="Farenheit">Farenheit</option>
                                    <option value="Kelvin">Kelvin</option>
                                </select>
                            </div>
                        </div>    
                        <input type="hidden" name="operation" value="temperature"/><br>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Compute</button>
                            </div>
                        </div>
                    </form>

                    <hr>

                    <h4>Mass</h4>

                    <form name="Mass" action="UnitConverterServlet" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">                            
                            <label for="qtyLbl" class="col-md-3 control-label">Convert what quantity?</label>
                            <div class="col-md-3">
                                <input type="text" name="quantityStr2" class="form-control" placeholder="enter quantity"
                                       value="${param.quantityStr2}"/>

                            </div>
                            <label class="control-label">${errorMessage2}</label>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-offset-3 col-md-6">
                                <label for="fromLbl" class="control-label">From :</label>

                                <select name="fromMass">
                                    <option value="Kilogram">Kilogram</option>
                                    <option value="Ounce">Ounce</option>
                                    <option value="Pound">Pound</option>
                                </select>
                                <label for="toLbl" class="control-label">To :</label>
                                <select name="toMass">
                                    <option value="Kilogram">Kilogram</option>
                                    <option value="Ounce">Ounce</option>
                                    <option value="Pound">Pound</option>
                                </select>
                            </div>
                        </div>    
                        <input type="hidden" name="operation" value="mass"/><br>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-8">
                                <button type="submit" class="btn btn-primary">Compute</button>
                            </div>
                        </div>

                    </form>

                    <hr>

                    <h4>Volume</h4>

                    <form name="Volume" action="UnitConverterServlet" method="post" class="form-horizontal" role="form">
                        <div class="row form-group">
                            <label for="qtyLbl" class="col-md-3 control-label">Convert what quantity?</label>
                            <div class="col-md-3">
                                <input type="text" name="quantityStr3" class="form-control" placeholder="enter quantity"
                                       value="${param.quantityStr3}"/>

                            </div>
                            <label class="control-label">${errorMessage3}</label>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-offset-3 col-md-6">                             
                                <label for="fromLbl" class="control-label">From :</label>
                                <select name="fromVolume">
                                    <option value="Galon">Galon</option>
                                    <option value="Quart">Quart</option>
                                    <option value="Pint">Pint</option>
                                </select>
                                To :
                                <select name="toVolume">
                                    <option value="Galon">Galon</option>
                                    <option value="Quart">Quart</option>
                                    <option value="Pint">Pint</option>
                                </select>
                            </div>
                        </div>    
                        <input type="hidden" name="operation" value="volume"/><br>
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
