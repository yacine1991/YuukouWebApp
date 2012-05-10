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
            out.println("hasdaata " + g.getHasData().toString());
            out.println("Image type" + g.getImageType());

            out.println("<center><img src=\"images/test.png\" alt=\"salle\" width='90%' style='max-width:400px;max-height:300px'></center>");%>
        %>
    </body>
</html>
