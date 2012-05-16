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
        <link rel="stylesheet"  href="http://jquerymobile.com/branches/popup-widget/css/themes/default/jquery.mobile.css" /> 

        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> 
        <script src="http://jquerymobile.com/branches/popup-widget/js/"></script>
        <style>
            .stylea{background-color: #cccccc;
            }
            .styleb{background-color: #666666;}
        </style>
    </head>
    <% Computer cp = (Computer) request.getAttribute("computer");%>
    <body>

        <div data-role="page">
            <div data-role="header">
                <h1>PC <%out.println(cp.getRessourceName());%></h1>
            </div>
            <div data-role="content">
                <%

                    out.println("pc hashistory" + cp.isHasPreviousUser());
                    out.println("<br/>");
                    out.println("<br/>");
                    if (cp.isHasPreviousUser() == true) {
                        for (int i = 0; i < cp.getPreviousUsers().size(); i++) {
                            out.println("Name ancien User : " + cp.getPreviousUsers().get(i).getNameUser());
                            out.println("Id ancien User : " + cp.getPreviousUsers().get(i).getIdUser());
                            out.println("<a href=\"YuukouServlet?choice=findUser&idUser=" + cp.getPreviousUsers().get(i).getIdUser() + "\" data-role=\"button\">More about Him </a>");
                            out.println("<br/>");
                        }
                    } else {
                        out.println("No History");
                    }
                %>
            </div>
        </div>

    </body>
</html>
