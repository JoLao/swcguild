// This is our Angular controller - it gets called when the Angular app gets loaded
function chartController($http) {
    // $http is the Angular object we use to send the Ajax request
    // upon success we run the function defined below
    $http.get("http://localhost:8080/googleCharts/spring/hello/chart")
            .success(function (response) {
                // first, create the DataTable from the response string
                // our response string is generated on the server by converting the Java
                // Google DataTable object into a JSON string using the Google JsonRenderer
                // object
                var myTable = new google.visualization.DataTable(response);
                // set the options for the chart - we're setting the main title, the verticle and
                // horizontal axis labels and the height/width of the chart
                var options = {
                                'title': 'Asset Damage Report',
                                vAxis: {title: 'Assets'},
                                hAxis: {title: 'Damage Amount'},
                                'width': 500, 
                                'height': 400};
                // create the chart (a BarChart in this case) - pass in the HTML element into which
                // you want to render the chart - in our case it is the <div> called 'chartDiv' on the
                // angularChart.jsp page
                var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
                // finally, draw the chart
                chart.draw(myTable, options);
            });
}
