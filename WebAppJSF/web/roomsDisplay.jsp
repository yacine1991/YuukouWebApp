<%-- 
    Document   : index
    Created on : 28 mars 2012, 16:20:37
    Author     : Yacine
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.awt.Robot"%>
<%@page import="com.yuukou.common.YuukouServlet"%>
<%@page import="com.yuukou.data.Room"%>
<%@page import="com.yuukou.data.RoomList"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.PrintWriter"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Infos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet"  href="http://jquerymobile.com/branches/popup-widget/css/themes/default/jquery.mobile.css" /> 
        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> 
        <script src="http://jquerymobile.com/branches/popup-widget/js/"></script>
        <style>
            .good,
            .medium,
            .bad, .zero { font-weight:bold; text-shadow: none;}
            .good { background-color:#00FF00; }
            .medium { background-color:#FFFF00; }
            .bad { background-color:#FFAA00;}
            .zero { background-color:#FF0000; }
            .ui-li-has-thumb .ui-btn-inner a.ui-link-inherit, .ui-li-static.ui-li-has-thumb {
                padding-left: 63px; 
            }
            .myThumb {margin-top: 20px; width:60px;max-width: 15%;}
        </style>
    </head>
    <body>
        <div data-role="page" data-add-back-btn="true" data-theme="d">

            <div data-role="header" data-position="fixed">
                <h3>Rooms</h3>
                <a href="" data-icon="home" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>

            <div data-role="content">
                <% RoomList rl = (RoomList) request.getAttribute("roomList");%>



                <ul data-role="listview" data-theme="d" data-filter="true">
                    <li data-role="list-divider" data-theme="a">
                        <a href="#why" data-rel="popup" data-inline="true" data-mini="true" >
                            <%if (rl.getJSONstate().equals("KO")) {
                                    out.println("Server is under maintenance, data will be back in few minutes");
                                } else {
                                    out.print("Rooms List");

                                }
                                /*
                                 * JSON State : ${roomList.JSONstate} JSON
                                 * LastCycle : ${roomList.JSONlastCycle} JSON
                                 * Maintenance : ${roomList.JSONmaintenance}
                                 */
                            %></a>
                    </li>

                    <%
                        Iterator it = rl.getJSONcontent().iterator();
                        while (it.hasNext()) {
                            Room r = (Room) it.next();
                    %>


                    <li data-filtertext="<%= r.getIdRoom()%>
                        <%= r.getShortDescription()%>
                        <%= r.getStatus()%>
                        <%= r.getLongLocation()%>
                        <% if (r.getTypeResource().equals("mc")) {%> mac <% }%>
                        <% if (r.getTypeResource().equals("pc")) {%> pc <% }%>
                        ">

                        <% out.println("<a href='YuukouServlet?choice=Room&id=" + r.getIdRoom() + "'>");%>
                        <%
                            if (r.getTypeResource().equals("mc")) {%>
                        <img src="images/apple.jpg" alt="macintosh" align="middle" class="myThumb"/>
                        <% } else {%>
                        <img src="images/windows.jpg" alt="windows" align="middle"  class="myThumb"/>
                        <% }%>

                        <span class="ui-li-count" style="margin-top: -2.3em;">
                            <B>Total: <%= r.getPcTotal()%> </B>
                            <br />
                            Free: <%= r.getPcAvailable()%>
                            <br />
                            Down: <%= r.getPcDown()%>
                            <br />
                            Busy: <%= r.getBusy()%>
                        </span>


                        <h3><% out.println(r.getIdRoom());%></h3>

                        <% if (r.getStatus().equals("Available")) {
                                    out.println("<p>Status : " + r.getStatus());
                                    if (Float.parseFloat(r.getAvailability()) >= 75.0) {

                                        out.println("<p>Availability : <span style=\" background-color: #0DED20;\"> " + r.getAvailability() + " </span></p>");
                                    } else if (Float.parseFloat(r.getAvailability()) >= 50.0) {
                                        out.println("<p>Availability : <span style=\" background-color: #F7B10D;\"> " + r.getAvailability() + " </span></p>");
                                    } else {
                                        out.println("<p>Availability : <span style=\" background-color: #F90909;\"> " + r.getAvailability() + " </span></p>");
                                    }
                                    out.println("<p>Site: " + r.getLongDescription() + "</p>");
                                } else {
                                    out.println("<p>Status:<blink><font color=\"red\"> Room Booked</font></blink></p>");


                                    if (!r.getStartTime().equals("")) {
                                        out.print("<p>Booking: ");
                                        out.println(r.getStartTime() + " - " + r.getEndTime());
                                        out.println("</p>");
                                        out.println("<p>Event: " + r.getEventType() + "</p>");
                                        out.println("<p>Site: " + r.getLongDescription() + "</p>");
                                    }
                                }
                                out.println("</a>");
                            }%>
                    </li>
                </ul>

            </div>

            <div data-role="footer" data-position="fixed"> <h3>Yuukou 2</h3>
                <a href="YuukouServlet?choice=credits" data-role="button" data-icon="star" data-theme="a" style="left: 10px;position: absolute;top: 0.4em;">Credits</a>
                <a href="info.jsp" data-role="button" data-icon="info" data-theme="a" style="position: absolute; right: 10px; top: 0.4em;">Info</a>
            </div>

            <div data-role="popup" id="why" data-overlay-theme="a" data-corners="true">
                <P>
                    Data quality : ${roomList.JSONstate}
                    <br />
                    Serveur LastCycle : ${roomList.JSONlastCycle}
                    <br />
                    Maintenance : ${roomList.JSONmaintenance}
                    <br />
                    <%
                        if (rl.getJSONstate().equals("KO")) {
                            out.println("Reason : " + rl.getJSONReason());
                        }
                    %>
                </p>
            </div>

        </div>   

    </body>
</html>


