<html>
    <head>
        <!-- Include Bootstrap CSS to make it look decent -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <title>Google Charts with AngularJS</title>
    </head>
    <body>
        <h1>Displaying Google Charts with AngularJS Ajax</h1>
        <a href="index.jsp" class="btn btn-primary">Home</a>
        <hr/>
        <!-- ng-app tells AngularJS that this div is the Angular application           -->
        <!-- ng-controller tells Angular which JavaScript function should be run when  -->
        <!-- the Angular application is loaded - in our case it is the function called -->
        <!-- chartController which lives in the angularChart.js file                   -->
        <div ng-app="" ng-controller="chartController">
            <!-- This is the div into which we want the Google chart to be rendered    -->
            <div id="chartDiv"></div>  
        </div>

        <!-- Reference the Google Charts JavaScript library                            -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <!-- We have to load the Google Charts JavaScript library before we can use it -->
        <script>google.load('visualization', '1.0', {'packages': ['corechart']});</script>
        <!-- Reference the AngularJS JavaScript library                                -->
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
        <!-- Finally, reference our own JavaScript functions                           -->
        <script src="${pageContext.request.contextPath}/js/angularChart.js"></script>
    </body>
</html>
