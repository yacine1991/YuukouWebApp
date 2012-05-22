<%-- 
    Document   : userInfos
    Created on : 15 mai 2012, 11:46:34
    Author     : Yacine
--%>

<%@page import="com.yuukou.data.Computer"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.yuukou.data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Computer Infos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <style>
            .stylea{background-color: #cccccc;
            }
            .styleb{background-color: #666666;}
        </style>
    </head>
    <% Computer cp = (Computer) request.getAttribute("computer");%>
    <body>

        <div data-role="page" data-theme="d" data-add-back-btn="true">
            <div data-role="header">
                <h1>PC <%out.println(cp.getRessourceName());%></h1>
            </div>
            <div data-role="content">
                <ul data-role="listview" data-theme="d" data-filter="true" data-inset="true">
                    <li data-role="list-divider" data-theme="a"><%out.println("PC " + cp.getRessourceName() + " History");%></li>
                    <%
                        if (cp.isHasPreviousUser() == true) {
                            for (int i = 0; i < cp.getPreviousUsers().size(); i++) {
                                out.println("<li><a href=\"YuukouServlet?choice=findUser&idUser=" + cp.getPreviousUsers().get(i).getIdUser() + "\"> ");
                                out.println("<img src=\"" + cp.getPreviousUsers().get(i).getIdPicture() + "\" alt=\"imgUser\"/>");
                                out.println("<h3>" + cp.getPreviousUsers().get(i).getNameUser() + "</h3>");
                                out.println("<p><strong>ID :" + cp.getPreviousUsers().get(i).getIdUser() + "</strong></p>");
                                if (!cp.getPreviousUsers().get(i).getActualState().equals("User logged out")) {
                                    out.println("<p> Session :" + cp.getPreviousUsers().get(i).getStartTimeSession() + "--" + cp.getPreviousUsers().get(i).getActualState() + " ("+cp.getPreviousUsers().get(i).getDureeSession()+")</p>");
                                } else {
                                    out.println("<p> Session :" + cp.getPreviousUsers().get(i).getStartTimeSession() + "--" + cp.getPreviousUsers().get(i).getEndTimeSession() +" ("+cp.getPreviousUsers().get(i).getDureeSession()+")</p>");
                                }
                                //out.println("<a href=\"YuukouServlet?choice=findUser&idUser=" + cp.getPreviousUsers().get(i).getIdUser() + "\" data-role=\"button\">More about Him </a>");
                                out.println("</a>");
                                out.println("</li>");
                            }
                        } else {
                            out.println("<li>No History</li>");
                        }
                    %>
                </ul>
            </div>
        </div>

    </body>
</html>
