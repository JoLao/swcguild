$(document).ready(function () {
    drawChart();

    function drawChart() {
        $.get('http://localhost:8080/googleCharts/spring/hello/chart').success(function (data) {
            // first, create the DataTable from the response data string.
            // our response string is generated on the server by converting the Java
            // Google DataTable object into a JSON string using the Google JsonRenderer
            // object
            var dataTable = new google.visualization.DataTable(data);
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
            // jQueryChart.jsp page
            var chart = new google.visualization.BarChart(document.getElementById('chartDiv'));
            // finally, draw the chart
            chart.draw(dataTable, options);
        });
    };

});