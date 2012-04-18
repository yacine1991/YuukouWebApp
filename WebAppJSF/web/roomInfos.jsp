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

            <div data-role="header">
                <h1>Room</h1>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <% Room r = (Room) request.getAttribute("room");%>



            <ul data-role="listview" data-theme="c" data-filter="true">

                <li>


                <li><%out.println("Health Room : " + r.getHealthRoom());%></li>
                <li><%out.println("Pc dispo : " + r.getPcAvailable());%></li>
                <li><%out.println("Pc down : " + r.getPcDown());%></li>
                <li><%out.println("Start time : " + r.getStartTime());%></li>
                <li><%out.println("Desc : " + r.getLongDescription());%></li>
                <li><%out.println("Has Image ? : " + r.getHasImage());%></li>


                <li><%out.println("Rcontepath " + request.getRequestURL());%></li>
                <li><%out.println("<img src=" + YuukouServlet.class.getClassLoader().getResource("pictures").getPath() + r.getIdRoom() + " alt=\"salle\"/>");%> </li>









            </ul>

        </div>
    </body>
</html>


