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



    </head>
    <% User u = (User) request.getAttribute("user");%>
    <body>
        <div data-role="page">
            <div data-role="header">
                <h1>User <%out.println(u.getIdUser());%></h1>
                <a href="" data-icon="back" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>
            <div data-role="content">
                <%
                    out.println("<p>User " + u.getNameUser() + "</p>");
                    out.println("</br>");
                    out.println("Session " + u.getActualSession());
                    out.println("</br>");
                    out.println("ActualState " + u.getActualState());
                    out.println("</br>");
                    out.println("User url pict " + u.getIdPicture());
                    out.println("</br>");
                    for (int i = 0; i < u.getAllHistoryUser().size(); i++) {
                        out.println("History of PC used " + u.getAllHistoryUser().get(i).getPcUsed());
                        out.println("Start" + u.getAllHistoryUser().get(i).getStartTimeSession());
                        out.println("END" + u.getAllHistoryUser().get(i).getEndTimeSession());

                        out.println("</br>");
                    }

                    out.println("<img src=\"" + u.getIdPicture() + "\" style=\"width:180px; max-width:100%; vertical-align:middle;\" />");
                %>

            </div>
        </div>

    </body>
</html>
