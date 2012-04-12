<%-- 
    Document   : Statistics
    Created on : 12 avr. 2012, 16:32:04
    Author     : Yacine
--%>

<%@page import="com.yuukou.common.RoomList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Load the AJAX API-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Stats</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <script type="text/javascript" charset="utf-8" src="phonegap.js"></script>
        <link rel="stylesheet" href="jquery.mobile-1.0.1.min.css" />
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript">

            // Load the Visualization API and the piechart package.
            google.load('visualization', '1.0', {'packages':['corechart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.setOnLoadCallback(drawChart);
            <% RoomList rl = (RoomList) request.getAttribute("roomList");%>
                // Callback that creates and populates a data table,
                // instantiates the pie chart, passes in the data and
                // draws it.
                function drawChart() {

                    // Create the data table.
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', 'Topping');
                    data.addColumn('number', 'Slices');
        
                    data.addRows([
                        ['Mushrooms', 3],
                        ['Onions', 1],
                        ['Olives', 1], 
                        ['Zucchini', 1],
                        ['Pepperoni', 2]
                    ]);


                    // Set chart options
                    var options = {'title':'Percentage of Pcs and Macs',
                        'width':800,
                        'height':800};

                    // Instantiate and draw our chart, passing in some options.
                    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                    chart.draw(data, options);
                }
        </script>
    </head>

    <body>
        <div data-role="page">

            <div data-role="header">
                <h1>Statistics</h1>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <!--Div that will hold the pie chart-->
            <div id="chart_div"></div>


        </div>
    </body>
</html>
