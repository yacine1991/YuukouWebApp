<%-- 
    Document   : adminView
    Created on : 10 mai 2012, 14:00:45
    Author     : Yacine, Thierry, AGC
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.yuukou.data.Location"%>
<%@page import="com.yuukou.data.LocationList"%>
<%@page import="com.yuukou.data.Room"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.yuukou.data.RoomList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% RoomList rl = (RoomList) request.getAttribute("roomList");
        LocationList locaList = (LocationList) request.getAttribute("locationList");
%>


                                        <%
                                Date today = new Date();
                                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");

                                Calendar cal = new GregorianCalendar();
                                cal.setTime(today);
                                cal.add(Calendar.DAY_OF_MONTH, -1);
                                Date today1 = cal.getTime();
                                cal.add(Calendar.DAY_OF_MONTH, -7);
                                Date today7 = cal.getTime();
                                cal.add(Calendar.DAY_OF_MONTH, -30);
                                Date today30 = cal.getTime();
                             %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
     
        <link rel="stylesheet"  href="http://jquerymobile.com/branches/popup-widget/css/themes/default/jquery.mobile.css" /> 
        <style>
.good,
.medium,
.bad, .zero { font-weight:bold; text-shadow: none;}
.good { background-color:#00FF00; }
.medium { background-color:#FFFF00; }
.bad { background-color:#FFAA00;}
.zero { background-color:#FF0000; }
.novalues { background-color:#100000; }
        </style>
        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> 
        <script src="http://jquerymobile.com/branches/popup-widget/js/"></script>
        
         <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['gauge']});
      google.load('visualization', '1', {packages: ['corechart']});
      
    </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator View</title>
   <%

          Location[] tabLocations = locaList.getAllData();
                                for (int i = 0; i < tabLocations.length; i++) {
   %>
      
      <script type="text/javascript">
      function drawVisualization<%=tabLocations[i].getShortLocation()%>() {
        // Create and populate the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Task');
        data.addColumn('number', 'Hours per Day');
        data.addRows(3);
        data.setValue(0, 0, 'Available');
        data.setValue(0, 1, <%= rl.getNumberComputerAvailablePerCampus(tabLocations[i].getLongLocation())     %>);
        data.setValue(1, 0, 'Down');
        data.setValue(1, 1, <%= rl.getNumberComputerDownPerCampus(tabLocations[i].getLongLocation())     %>);
        data.setValue(2, 0, 'Busy');
        data.setValue(2, 1, <%= rl.getNumberComputerBusyPerCampus(tabLocations[i].getLongLocation())     %>);
      
        // Create and draw the visualization.
        new google.visualization.PieChart(document.getElementById('visualization<%= tabLocations[i].getShortLocation() %>')).
            draw(data, {title:"Yuukou2 machine usage and health",width:500, height: 350 ,  backgroundColor:  {fill: "none" }} );

      }
      google.setOnLoadCallback(drawVisualization<%= tabLocations[i].getShortLocation() %>);
    </script>
      
    <% } %>
    </head>
    
    <body>
        <div data-role="page" data-add-back-btn="true">

            <div data-role="header">
                <h1>Administrator</h1>
            </div>
            <div data-role="content">
             <ul data-role="listview" data-theme="c">
                <li><a href="#globalview">Global View</a></li>
                <li><a href="#groupview">Group View</a></li>
                <li><a href="YuukouServlet?choice=find">Room View</a></li>
             </ul>
            </div>
        </div>
        <div data-role="page" data-add-back-btn="true" id="groupview">
          <div data-role="header"><h3>Site</h3></div>
           <div data-role="content">
                <ul data-role="listview" data-theme="c" data-filter="false">
                        <li data-role="list-divider">Site</li>
                            <%
                                tabLocations = locaList.getAllData();
                                for (int i = 0; i < tabLocations.length; i++) {
                            %>
                                    <li>
                                        <a href="#RoomView_<%= tabLocations[i].getId() %>"><%= tabLocations[i].getLongLocation() %></a>
                                    </li>
                            <%}
                             %>
                        <li data-role="list-divider"> Virtual Groups</li>
                          <li><a href="#VirtualGroup_ncslib">NCS Library</a></li>
                          <li><a href="#VirtualGroup_uowlib">UoW Library</a></li>
                          <li><a href="#VirtualGroup_ecsmac">ECS MAC</a></li>
                </ul>
         </div>
        </div>
                    
                    
                    <%          tabLocations = locaList.getAllData();
                                for (int i = 0; i < tabLocations.length; i++) {
                             
                    %> 
                    <!-- menu intermediaire -->
                    <div data-role="page" id="RoomView_<%= tabLocations[i].getId() %>" data-add-back-btn="true">
                        <div data-role="header">
                <h1><%=tabLocations[i].getLongLocation() %></h1>
            </div>
            <div data-role="content">
                <ul data-role="listview" data-theme="c" data-filter="false">
                    <li><a href="#<%= tabLocations[i].getId() %>-status">Status</a></li>
                    <li><a href="#<%= tabLocations[i].getId() %>-report">Computer Down Report</a></li>
                    <li><a href="#<%= tabLocations[i].getId() %>">Room View</a></li>
                </ul>
                    </div>
                    </div>
                    <div data-role="page" id="<%=tabLocations[i].getId() %>" data-add-back-btn="true">

            <div data-role="header">
                <h1><%=tabLocations[i].getLongLocation() %></h1>
            </div>
            <div data-role="content">
                    <ul data-role="listview" data-theme="c" data-filter="true">
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
                                            out.println("</a></li>");

                                        }%>


                                </ul>
            </div>
                    </div>
                                        <div data-role="page" id="<%=tabLocations[i].getId() %>-status" data-add-back-btn="true">
                                             <div data-role="header">
                                            <h1>Status <%= tabLocations[i].getShortLocation() %></h1>
                                            </div>
                                            <div data-role="content">
                                                <center><table><tr><td>
                                              <br /><strong>Computer Rooms Total:</strong>  <%= rl.getNumberRoomTotalPerCampus(tabLocations[i].getLongLocation()) %> 
                                              <br /><strong>Computer Rooms booked:</strong>  <%= rl.getNumberRoomBusyPerCampus(tabLocations[i].getLongLocation()) %> 
                                              <br /><strong>Computer Total:</strong>  <%= rl.getNumberComputerTotalPerCampus(tabLocations[i].getLongLocation()) %> 
                                              <br /><strong>Computer Available:</strong>  <%= rl.getNumberComputerAvailablePerCampus(tabLocations[i].getLongLocation()) %> 
                                              <br /><strong>Computer Busy:</strong>  <%= rl.getNumberComputerBusyPerCampus(tabLocations[i].getLongLocation()) %>
                                              <br /><strong>Computer Down:</strong>  <%= rl.getNumberComputerDownPerCampus(tabLocations[i].getLongLocation()) %>
                                              <br /> 
                                                        </td><td>
                                              <div id="visualization<%= tabLocations[i].getShortLocation() %>" style="width: 400px; height: 300px;"></div>
                                                        </td></tr>
                                                    <tr><td colspan="2">
                                       <!-- <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today1) 
                                        + "&timeEnd=" + ft.format(today) + "&resource=" + tabLocations[i].getId() + '\"'
                                        + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                                            <br />
                                        -->    
                                            <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7) 
                                        + "&timeEnd=" + ft.format(today) + "&resource=" + tabLocations[i].getId() + '\"'
                                        + " style=\"max-width:100%; \"/>"); %>
                                            <br />
                                        <!--    
                                            <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today30) 
                                        + "&timeEnd=" + ft.format(today) + "&resource=" + tabLocations[i].getId() + '\"'
                                        + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                                        -->
                                                        </td></tr></table></center>
                                            </div>
                                        </div>
                                        
                                        <div data-role="page" id="<%=tabLocations[i].getId() %>-report" data-add-back-btn="true">
                                             <div data-role="header">
                                            <h1>Computer Down Report <%= tabLocations[i].getShortLocation() %></h1>
                                            </div>
                                            <div data-role="content">
                         <ul>
                            <%
                            
                            al = rl.getRoomsPerCampus(tabLocations[i].getLongLocation());
                            it = al.iterator();
                                    while (it.hasNext()) {
                                        Room r = (Room) it.next();
                            
                            if (r.getComputerList() != null) {
                                    for (int j = 0; j < r.getComputerList().length; j++) {
                                        if (r.getComputerList()[j].getRessourceStatus().equals("DOWN")) {
                                            out.println("<li><span class=\"bad\">" + r.getComputerList()[j].getRessourceName() + "</span>");
                                        }

                                        if (r.getComputerList()[j].getRessourceStatus().equals("DELETEME")) {
                                            out.println("<li><span class=\"zero\">" + r.getComputerList()[j].getRessourceName() + "</span>");
                                        }

                                        out.println("Lastseen: " + r.getComputerList()[j].getLastTimeSeen() + "");
                                        out.println("</li>");
                                    }
                                }
                              }
                            %>
                        </ul>
                                            </div>
                                        </div>

                                        <% } %>
                    <!-- -->
                    
                    <div data-role="page" id="VirtualGroup_ncslib" data-add-back-btn="true">
                          <div data-role="header">
                <h1>NCS Library</h1>
            </div>
            <div data-role="content">
                <ul data-role="listview" data-theme="c" data-filter="false">
                    <li><a href="#ncslib-status">Status</a></li>
                    <li><a href="#ncslib-listview">Room View</a></li>
                </ul>
                    </div>
                    </div>
                    
                    <div data-role="page" id="VirtualGroup_ecsmac" data-add-back-btn="true">
                          <div data-role="header">
                <h1>ECS MAC</h1>
            </div>
            <div data-role="content">
                <ul data-role="listview" data-theme="c" data-filter="false">
                    <li><a href="#ecsmac-status">Status</a></li>
                    <li><a href="#ecsmac-listview">Room View</a></li>
                </ul>
                    </div>
                    </div>
                    
      <div data-role="page" id="ncslib-status" data-add-back-btn="true">
          <div data-role="header">
       <h1>NCS Library</h1>
      </div>
       <div data-role="content">
          <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today1) 
                       + "&timeEnd=" + ft.format(today) + "&resource=" + "n-lib" + '\"'
                       + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                        <br />
                                                
                                            <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7) 
                                        + "&timeEnd=" + ft.format(today) + "&resource=" + "n-lib" + '\"'
                                        + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                                            <br />
                                        
                                            </div>
                                        </div>
                                            
      <div data-role="page" id="ecsmac-status" data-add-back-btn="true">
          <div data-role="header">
       <h1>ECS MAC</h1>
      </div>
       <div data-role="content">
          <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today1) 
                       + "&timeEnd=" + ft.format(today) + "&resource=" + "e-n411" + '\"'
                       + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                        <br />
                                                
                                            <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7) 
                                        + "&timeEnd=" + ft.format(today) + "&resource=" + "e-n411" + '\"'
                                        + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
                                            <br />
                                        
                                            </div>
                                        </div>
                                            
      <div data-role="page" id="VirtualGroup_uowlib" data-add-back-btn="true">
       <div data-role="header">
       <h1>UoW Library</h1>
      </div>
       <div data-role="content">
         <ul data-role="listview" data-theme="c" data-filter="false">
            <li><a href="#uowlib-status">Status</a></li>
            <li><a href="#uowlib-listview">Room View</a></li>
         </ul>
       </div>
      </div>
                    
      <div data-role="page" id="uowlib-status" data-add-back-btn="true">
           <div data-role="content">
             <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7) 
                          + "&timeEnd=" + ft.format(today) + "&resource=" + "lib" + '\"'
                          + " style=\"max-width:100%; vertical-align:middle;\"/>"); %>
             <br />
           </div>
      </div>
                                            
      <div data-role="page" data-add-back-btn="true" id="globalview">
            <div data-role="header"><h3>Global View</h3></div>
            <div data-role="content">
             
                <img src="http://localhost:8080/WebApplication2/ComboChartServlet" /> 
                <br />
                    
                <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7) 
                                        + "&timeEnd=" + ft.format(today) + '\"'
                                        + " style=\"max-width:100%; \"/>"); %>
                         
            </div>
      </div>
                                        
      <div data-role="page" data-add-back-btn="true" id="ncslib-listview">
          <div data-role="header"><h3>NCS Library</h3></div>
          <div data-role="content">
                    <ul data-role="listview" data-theme="c" data-filter="true">
                     <%
                                    ArrayList al = rl.getRoomsForVirtualGroup("n-lib");
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
                                            out.println("</a></li>");

                                        }%>
                                </ul>
            </div>       
      </div>
    
    <div data-role="page" data-add-back-btn="true" id="uowlib-listview">
          <div data-role="header"><h3>NCS Library</h3></div>
          <div data-role="content">
                    <ul data-role="listview" data-theme="c" data-filter="true">
                     <%
                                    al = rl.getRoomsForVirtualGroup("lib");
                                    it = al.iterator();
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
                                            out.println("</a></li>");

                                        }%>
                                </ul>
            </div>       
      </div>
             
   <div data-role="page" data-add-back-btn="true" id="ecsmac-listview">
          <div data-role="header"><h3>ECS MAC</h3></div>
          <div data-role="content">
                    <ul data-role="listview" data-theme="c" data-filter="true">
                     <%
                                    al = rl.getRoomsForVirtualGroup("e-n411");
                                    it = al.iterator();
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
                                            out.println("</a></li>");

                                        }%>
                                </ul>
            </div>       
      </div>
                                       
                   
    </body>
</html>
