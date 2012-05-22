<%-- 
    Document   : hom
    Created on : 4 avr. 2012, 12:19:58
    Author     : Yacine
--%>
<%@ page errorPage="ShowError.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <script type="text/javascript" charset="utf-8" src="phonegap.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yuukou2WebApp Main Page</title>
    </head>
    <body>
        <div data-role="page" data-theme="d">

            <div data-role="header">
                <h1>Home</h1>
            </div>
            <ul data-role="listview">
                <% try {%>
                <li data-icon="search" data-iconpos="left"><a href="YuukouServlet?choice=find" >Find a PC</a>
                </li>

                <li ><a href="YuukouServlet?choice=stats">Statistics</a>
                </li>

                <li ><a href="YuukouServlet?choice=stattest">Statistics Test page</a>
                </li>

                <li data-icon="gear" data-iconpos="left" ><a href="YuukouServlet?choice=adminView" >Administator View</a></li>
                <% } catch (Exception e) {

                        out.println("Error" + e.getMessage().toString());
                        System.out.println("Sa marche pas ");
                    }

                %>
            </ul>
        </div>
        <%
            if ((session.getAttribute("status") != null) && (session.getAttribute("status").equals(new Integer(42)))) {

                out.println("<br><p>An error was done...<br>");
                out.println(session.getAttribute("error").toString());

                out.println("</p>");
                session.setAttribute("status", null);
            }

        %>

    </body>
</html>
