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

        <link rel="stylesheet" type="text/css" href="yuukou.css"/>
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>

    </head>
    <body>
        <div data-role="page">

            <div data-role="header">
                <h1>Rooms</h1>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <% RoomList rl = (RoomList) request.getAttribute("roomList");%>



            <ul data-role="listview" data-theme="c" data-filter="true">
                <li data-role="list-divider"> JSON State : ${roomList.JSONstate}
                    JSON LastCycle : ${roomList.JSONlastCycle}
                    JSON Maintenance : ${roomList.JSONmaintenance}</li>

                <%
                    Iterator it = rl.getJSONcontent().iterator();
                    while (it.hasNext()) {
                        Room r = (Room) it.next();
                %>
                <li><% out.println("<a href=YuukouServlet?choice=Room&id=" + r.getIdRoom() + ">");%>
                    <%
                        if (r.getTypeResource().equals("mc")) {%>
                    <img src="images/apple.jpg" alt="macintosh" align="middle"/>
                    <% } else {%>
                    <img src="images/windows.jpg" alt="windows" align="middle"/>
                    <% }%>
                    <h3><% out.println(r.getIdRoom());%></h3>
                    
                    <% if (!r.getStatus().equals("Busy")) {%>
                    <p><%   out.println("Status : " + r.getStatus());%></p>
                    <p><%  if (Float.parseFloat(r.getAvailability()) >= 75.0) {

                            out.println("Availability : <span style=\" background-color: #0DED20;\"> " + r.getAvailability() + " </span>");
                        } else if (Float.parseFloat(r.getAvailability()) >= 50.0) {
                            out.println("Availability : <span style=\" background-color: #F7B10D;\"> " + r.getAvailability() + " </span>");
                        } else {
                            out.println("Availability : <span style=\" background-color: #F90909;\"> " + r.getAvailability() + " </span>");
                        }
                        %></p>
                    <p><%   out.println("Campus location : " + r.getLongDescription());%></p>



                    <%out.println("</a>");%>
                </li>
                <% } else if (r.getStatus().equals("Busy")){
                            out.println("<blink><font color=\"red\">Room busy</font></blink>");
                           }
                    }%>
            </ul>

        </div>
    </body>
</html>


