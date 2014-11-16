$(document).ready(function() {
    drawChartA();
    drawChartB();
    drawChartC();
    drawChartD();
    drawChartE();
    drawChartF();


    function drawChartA() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartA').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {
//                title: 'Asset Damage By Product'
                width: 525,
                height: 400,
                hAxis: {title: 'Product' },
                vAxis: {title: 'Number of Damage Incidents'}
            };


            var chartA = new google.visualization.PieChart(document.getElementById('chartDivA'));
            chartA.draw(dataTable, options);
        });
    };



    function drawChartB() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartB').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {
//                title: 'Asset Usage By Product',
                width: 525,
                height: 400,
//                hAxis: {title: 'Number of Uses'},
//                vAxis: {title: 'Product'}
            };



            var chartB = new google.visualization.PieChart(document.getElementById('chartDivB'));
            chartB.draw(dataTable, options);
        });
    };




    function drawChartC() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartC').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {
//                title: 'Losses By Product',
                width: 525,
                height: 400,
                hAxis: {title: 'Number of Losses'},
                vAxis: {title: 'Product'}
            };
            
            var chartC = new google.visualization.BarChart(document.getElementById('chartDivC'));
            chartC.draw(dataTable, options);
        });
    };




    function drawChartD() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartD').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {
//                title: 'Late Returns By Product',
                width: 525,
                height: 400,
                hAxis: {title: 'Product'},
                vAxis: {title: 'Number of Late Returns'}
            };
            
            var chartD = new google.visualization.ColumnChart(document.getElementById('chartDivD'));
            chartD.draw(dataTable, options);
        });
    };

    function drawChartE() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartE').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
            var options = {
//                title: 'Late Returns By User',
                width: 525,
                height: 400,
                hAxis: {title: 'Number of Late Returns'},
                vAxis: {title: 'User'}
            };
            
            
            var chartE = new google.visualization.BarChart(document.getElementById('chartDivE'));
            chartE.draw(dataTable, options);
        });
    };
    


    function drawChartF() {
        $.get('http://localhost:8080/ScarletExpo/charts/chartF').success(function(data) {
            var json = data;
            var dataTable = new google.visualization.DataTable(json);
           var options = {
//                title: 'Losses By User',
                width: 525,
                height: 400,
                hAxis: {title: 'Number of Losses'},
                vAxis: {title: 'User'}
            };
            
            var chartF = new google.visualization.ColumnChart(document.getElementById('chartDivF'));
            chartF.draw(dataTable, options);
        });
    }
    ;





});