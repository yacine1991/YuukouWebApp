<%-- 
    Document   : userInfos
    Created on : 15 mai 2012, 11:46:34
    Author     : Yacine
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.yuukou.data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Infos</title>
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
    <% User u = (User) request.getAttribute("user");%>
    <body>

        <div data-role="page" id="<%= u.getIdUser()%>" data-theme="d">
            <div data-role="header">
                <h1><%out.println("ID User " + u.getIdUser());%></h1>
            </div>
            <div data-role="content">
                <table><tr><th colspan="2">
                            <%

                                out.println(u.getNameUser());
                            %>
                        </th></tr><tr><td>
                        <%

                            out.println("<img src=\"" + u.getIdPicture() + "\" style=\"width:180px; max-width:100%; vertical-align:middle;\" />");
                        %>
                        </td><td>
                            <%
                                out.println("<span style=\"background:#33FF33\">Actual state : " + u.getActualState());

                                out.println("<br />");
                                out.println("Actual Session Started at : " + u.getActualSession() + "</span>");
                                out.println("<br />");
                                for (int i = 0; i < u.getAllHistoryUser().size(); i++) {
                                    out.println("<div class=\"styleb\"> <br /><font color=\"blue\"><strong>Resource Name :</strong></font>" + u.getAllHistoryUser().get(i).getPcUsed());
                                    out.println("<br />");
                                    out.println("<font color=\"green\"><strong>Start : </strong></font>" + u.getAllHistoryUser().get(i).getStartTimeSession());
                                    out.println("<br />");
                                    out.println("<font color=\"red\"><strong>End : </strong></font>" + u.getAllHistoryUser().get(i).getEndTimeSession());
                                    out.println("<br />");
                                    out.println("<font color=\"purple\"><strong>Durée : </strong></font>" + u.getAllHistoryUser().get(i).getDureeSession());
                                    out.println("</div><br />");
                                }


                            %>
                        </td></tr></table>
            </div>
        </div>

    </body>
</html>
