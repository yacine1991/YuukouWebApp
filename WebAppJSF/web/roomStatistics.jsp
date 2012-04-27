<%-- 
    Document   : Statistics
    Created on : 12 avr. 2012, 16:32:04
    Author     : Yacine
--%>



<%@page import="com.yuukou.common.ChartStatistics"%>
<%@page import="com.yuukou.common.PieStatistics"%>
<%@page import="com.yuukou.common.Room"%>
<%@page import="org.jfree.chart.renderer.xy.XYLineAndShapeRenderer"%>
<%@page import="org.jfree.chart.plot.PlotOrientation"%>
<%@page import="org.jfree.data.xy.DefaultXYDataset"%>
<%@page import="org.jfree.chart.JFreeChart"%>
<%@page import="org.jfree.chart.ChartFactory"%>
<%@page import="javax.management.j2ee.statistics.Statistic"%>
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

        <%
            RoomList rl = (RoomList) request.getAttribute("roomList");
        %>
        <script type="text/javascript" src="javascript.js"></script>
        <script type="text/javascript">
            google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
                    ['Cavensih',     <%=rl.getNbComputerRoomsCavendish()%>],
                    ['ECS',      <%=rl.getNbComputerRoomsECS()%>],
                    ['Harrow',  <%=rl.getNbComputerRoomsHarrow()%>],
                    ['Little Tich', <%=rl.getNbComputerRoomsLittleTich()%>],
                    ['Regent', <%=rl.getNbComputerRoomsRegent()%>],
                    ['Marylbone',    <%=rl.getNbComputerRoomsMarylebone()%>]
                ]);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));
        chart.draw(data, options);
      }

        </script>
    </head>

    <body onload="javascript:lancerCompteur(20);">
        <div data-role="page">

            <div data-role="header">
                <h1>Statistics</h1>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <!--Div that will hold the pie chart-->
            <div id="test" data-role="collapsible">
                <h3>I'm a header</h3>

                <div id="chart_div" style="width: 900px; height: 500px;" ></div>

                <div id="chart_div2" style="width: 900px; height: 500px;"></div>
                <p><% out.println("Nb computer maryl : "+rl.getNbComputerRoomsMarylebone());%></p>
            </div>
            <div id="temps"></div>
            <h1><%

                /*
                 * PieStatistics ps = new PieStatistics(); ChartStatistics cs =
                 * new ChartStatistics(); ps.drawPieMacPc(rl);
                 * ps.drawPieComputerPerCampus(rl);
                 * ps.drawPieComputerBusyAvailableDown(rl);
                 * ps.drawPieRoomsBusyAvailable(rl);
                 * ps.drawPieRoomsBusyAvailablePerCampus(rl, "Regent");
                 *
                 * cs.createLegendItems(); cs.createChart(cs.createDataset(rl));
                 */

                %>   </h1>



        </div>
    </body>
</html>
