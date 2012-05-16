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
        <link rel="stylesheet"  href="http://jquerymobile.com/branches/popup-widget/css/themes/default/jquery.mobile.css" /> 

        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> 
        <script src="http://jquerymobile.com/branches/popup-widget/js/"></script>
        <style>
            .stylea{background-color: #cccccc;
            }
            .styleb{background-color: #666666;}
        </style>
    </head>
    <% User u = (User) request.getAttribute("user");%>
    <body>
        
        <div data-role="page" id="<%= u.getIdUser()%>">
            <div data-role="header">
                <h1>User <%out.println(u.getIdUser());%></h1>
               </div>
            <div data-role="content">
                <table><tr><th colspan="2">
                <%
                
                    out.println("User " + u.getNameUser() );
                    %>
                        </th></tr><tr><td>
                    <%
                    out.println(u.getIdUser());
                    out.println("<img src=\"" + u.getIdPicture() + "\" style=\"width:180px; max-width:100%; vertical-align:middle;\" />");
                    %>
                        </td><td>
                            <%
                    out.println("Session " + u.getActualSession());
                    out.println("<br />");
                    out.println("ActualState " + u.getActualState());
                    out.println("<br />");
                    for (int i = 0; i < u.getAllHistoryUser().size(); i++) {
                        out.println("<div class=\"styleb\">History of PC used " + u.getAllHistoryUser().get(i).getPcUsed());
                        out.println("Start" + u.getAllHistoryUser().get(i).getStartTimeSession());
                        out.println("END" + u.getAllHistoryUser().get(i).getEndTimeSession());

                        out.println("</div><br />");
                    }

                    
                %>
                        </td></tr></table>
            </div>
        </div>

    </body>
</html>
