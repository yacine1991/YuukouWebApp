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

    </head>

    <body>
        <div data-role="page">

            <div data-role="header">
                <h1>Statistics</h1>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <!--Div that will hold the pie chart-->
            <div id="test">
                <% RoomList rl = (RoomList) request.getAttribute("roomList");
                    
                    PieStatistics ps = new PieStatistics();
                    ChartStatistics cs = new ChartStatistics();
                %>
                <h1><%                    
                    
                    /*ps.drawPieMacPc(rl);
                    ps.drawPieComputerPerCampus(rl);
                    ps.drawPieComputerBusyAvailableDown(rl);
                    ps.drawPieRoomsBusyAvailable(rl);
                    ps.drawPieRoomsBusyAvailablePerCampus(rl, "Regent");
                    
                    cs.createLegendItems();
                    cs.createChart(cs.createDataset(rl));*/
                    
                    %>   </h1>
                    <h2>Test image :<br>
                        <%out.println("<img src=\"macPC.jpg\" alt=\"salle\"/>");%></h2>

            </div>


        </div>
    </body>
</html>
