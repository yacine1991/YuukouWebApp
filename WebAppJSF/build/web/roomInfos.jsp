<%-- 
    Document   : index
    Created on : 28 mars 2012, 16:20:37
    Author     : Yacine
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.awt.Robot"%>
<%@page import="com.yuukou.common.YuukouServlet"%>
<%@page import="com.yuukou.common.Room"%>
<%@page import="com.yuukou.common.RoomList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.PrintWriter"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Infos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <script type="text/javascript" charset="utf-8" src="phonegap.js"></script>
        <link rel="stylesheet" href="jquery.mobile-1.0.1.min.css" />
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>
    </head>
    <body>
        <div data-role="page">
            <%
                RoomList rl = (RoomList) request.getAttribute("roomList");
                Room r = (Room) request.getAttribute("room");
            %>


            <div data-role="header">
                <h1>Room <%out.println(r.getIdRoom());%></h1>
                <a href="" data-icon="Back" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>
            <center>



                <%out.println("<img src=\"images/" + r.getIdRoom() + ".jpg\" alt=\"salle\"/>");%>
                <ul data-role="listview" data-theme="c">

                    <li>

                        <% if (r.getStatus().equals("Available")) {%>
                    <li><%out.println("Health Room : " + r.getHealthRoom());%></li>
                    <li><%out.println("Available Computers : " + r.getPcAvailable());%></li>
                    <li><%out.println("Computer down : " + r.getPcDown());%></li>
                    <li><%out.println("Computer Busy : " + r.getBusy());%></li>
                    <li><%out.println("Computer Types : " + r.getTypeResource());%></li>
                    <li><%out.println("Long Description : " + r.getLongDescription());%></li>

                    <%} else {
                            out.println("<li><blink><font color=\"red\">Room busy</font></blink></li>");
                            out.println("<li>Start time : " + r.getStartTime() + "</li>");
                            out.println("<li>End Time : " + r.getEndTime() + "</li>");
                            out.println("<li>Event type : " + r.getEventType() + "</li>");
                        }%>                
                </ul>
                <a href="campusLocations.html" data-role="button" data-icon="search">View on Google Map</a>
            </center>
        </div>
    </body>
</html>


