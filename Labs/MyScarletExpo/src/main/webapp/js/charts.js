$(document).ready(function() {
    drawChartA();
    drawChartB();
    drawChartC();
    drawChartD();
    drawChartE();
    drawChartF();


    function drawChartA() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartA').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartA = new google.visualization.BarChart(document.getElementById('chartDivA'));
            chartA.draw(dataTable, options);
        });
    };
    
    function drawChartB() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartB').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartB = new google.visualization.BarChart(document.getElementById('chartDivB'));
            chartB.draw(dataTable, options);
        });
    };
    
     function drawChartC() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartC').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartC = new google.visualization.BarChart(document.getElementById('chartDivC'));
            chartC.draw(dataTable, options);
        });
    };
    
     function drawChartD() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartD').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartD = new google.visualization.BarChart(document.getElementById('chartDivD'));
            chartD.draw(dataTable, options);
        });
    };
    
     function drawChartE() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartE').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartE = new google.visualization.BarChart(document.getElementById('chartDivE'));
            chartE.draw(dataTable, options);
        });
    };
    
     function drawChartF() {
        $.get('http://localhost:8080/ScarletExpo/spring/chartF').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {'title': 'Test Title', 'width': 400, 'height': 400};
            var chartF = new google.visualization.BarChart(document.getElementById('chartDivF'));
            chartF.draw(dataTable, options);
        });
    };
    
    
    
    

});