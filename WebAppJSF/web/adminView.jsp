<%-- 
    Document   : adminView
    Created on : 10 mai 2012, 14:00:45
    Author     : Yacine
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.yuukou.data.Location"%>
<%@page import="com.yuukou.data.LocationList"%>
<%@page import="com.yuukou.data.Room"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.yuukou.data.RoomList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <script type="text/javascript" charset="utf-8" src="phonegap.js"></script>
        <link rel="stylesheet" href="jquery.mobile-1.0.1.min.css" />
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator View</title>
    </head>
    <% RoomList rl = (RoomList) request.getAttribute("roomList");
        LocationList locaList = (LocationList) request.getAttribute("locationList");
    %>
    <body>
        <div data-role="page">

            <div data-role="header">
                <h1>Administrator</h1>
            </div>

            <ul data-role="listview" data-theme="c">

                <li>Global View
                    <ul>
                        <li>Status</li>
                        <li>Utilisation</li>
                        <li>Statistics</li>
                    </ul>
                </li>

                <li ><a href="YuukouServlet?choice=stats">Site View</a>
                    <ul data-role="listview" data-theme="c" data-filter="true">
                        <li data-role="list-divider"> Campus</li>
                        <li>
                            <%

                                Location[] tabLocations = locaList.getAllData();
                                for (int i = 0; i < tabLocations.length; i++) {

                                    out.println("<a>");
                                    out.println(tabLocations[i].getLongLocation());
                                    out.println("</li>");
                                    out.println("</a>");
                                
                            %>
                        

                        <li>
                            <ul data-role="listview" data-theme="c" data-filter="true">
                                <li data-role="list-divider"> <%out.println(tabLocations[i].getLongLocation());%></li>

                                <%
                                    ArrayList al = rl.getRoomsPerCampus(tabLocations[i].getLongLocation());
                                    Iterator it = al.iterator();
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
                                    <img src="images/apple.jpg" alt="macintosh" align="middle"/>
                                    <% } else {%>
                                    <img src="images/windows.jpg" alt="windows" align="middle"/>
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


                        </li>
                        <%}
                                %>
                    </ul>
                </li>

                <li ><a href="YuukouServlet?choice=find">Room View</a>
                </li>
            </ul>
        </div>
    </body>
</html>
