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
        <p>Essai </p>
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
            <li>
                <%   
                    if (r.getTypeResource().equals("mc")) {%>
                <img src="images/apple.jpg" align="middle"/>
                <% } else {%>
                <img src="images/windows.jpg" align="middle"/>
                <% }%>
                <h3><% out.println(r.getIdRoom());%></h3>                
                <p><%   out.println(r.getAvailability());%></p>
                <ul>
							<li><%out.println("Health Room : "+r.getHealthRoom());%></li>
                                                        <li><%out.println("Pc dispo : "+r.getPcAvailable());%></li>
                                                        <li><%out.println("Pc down : "+r.getPcDown());%></li>
                                                        <li><%out.println("Start time : "+r.getStartTime());%></li>
							
		</ul>
            </li>
            <% }%>

            <%--<li><% out.print(rl.getJSONcontent().size());%></li>--%>
        </ul>

        <h2>${roomList.JSONstate}</h2>





        <%--   <jsp:useBean id="room" scope="request" class="YuukouServlet.getRes" />
                <%

            try {
                out.print("<h1> <b>WHO</b> </h1></br>");
                jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
                jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
                // TODO process result here
                java.lang.String result = port.who();
                out.println(result);

            } catch (Exception ex) {
                Properties prop = System.getProperties();
                out.println(prop.get("javax.net.ssl.trustStore"));
                out.println(ex.getMessage());
                // TODO handle custom exceptions here
            }
        %>--%>



    </body>
</html>


