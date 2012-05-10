<%-- 
    Document   : roomStatisticsadmin
    Created on : 9 mai 2012, 17:25:05
    Author     : Yacine
--%>

<%@page import="com.yuukou.stats.Graph"%>
<%@page import="com.yuukou.data.RoomList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        RoomList rl = (RoomList) request.getAttribute("roomList");
        Graph g = (Graph) request.getAttribute("graph");
    %>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println("hasata " + g.getHasData().toString());
        %>
    </body>
</html>
