<%-- 
    Document   : index
    Created on : 28 mars 2012, 16:20:37
    Author     : Yacine, Thierry
--%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="org.jfree.ui.about.SystemProperties"%>
<%@page import="com.yuukou.data.User"%>
<%@page import="com.yuukou.data.UserList"%>
<%@page import="com.yuukou.data.TimeTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.awt.Robot"%>
<%@page import="com.yuukou.common.YuukouServlet"%>
<%@page import="com.yuukou.data.Room"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.PrintWriter"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Infos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <script type="text/javascript" charset="utf-8" src="phonegap.js"></script>
        <!--  
        <link rel="stylesheet" href="jquery.mobile-1.0.1.min.css" />
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>
        -->
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
            .novalues { background-color:#100000; }
        </style>
    </head>
    <body>
        <div data-role="page">
            <%
                Room r = (Room) request.getAttribute("room");
                UserList ul = (UserList) request.getAttribute("userlist");
            %>


            <div data-role="header">
                <h1>Room <%out.println(r.getIdRoom());%></h1>
                <a href="" data-icon="back" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>
            <div data-role="content">

                <%out.println("<center><img src=\"images/" + r.getIdRoom() + ".jpg\" alt=\"salle\" width='90%' style='max-width:400px;max-height:300px'></center>");%>
                <div data-role="collapsible-set" data-theme="c" data-content-theme="d">
                    <div data-role="collapsible">
                        <h3>Status</h3>
                        <% if (r.getStatus().equals("Available") || r.getStatus().equals("Busy")) {%>
                        <p><strong>Room Health:</strong>
                            <%
                                String myHealthClass = "novalue";
                                float health = 0;
                               
                                if (r.getHealthRoom() != null) {

                                    health = Float.parseFloat(r.getHealthRoom());

                                    if (health > 60.0) {
                                        myHealthClass = "good";
                                    } else if (health <= 60.0 && health > 20.0) {
                                        myHealthClass = "medium";
                                    } else if (health <= 20.0 && health > 0.0) {
                                        myHealthClass = "bad";
                                    } else {
                                        myHealthClass = "zero";
                                    }
                                } else {
                                    out.println("GethealthRoom est null");
                                    myHealthClass = "novalue";
                                }
                            %>

                            <span class=" <%= myHealthClass%> "> &nbsp;<%= health%> % &nbsp; </span>
                        </p>

                        <p><strong>Computer Availability:</strong>
                            <%String myAvailClass = "novalue";
                                float avail = 0;
                                if (r.getAvailability() != null) {
                                    avail = Float.parseFloat(r.getAvailability());

                                    if (avail > 60.0) {
                                        myAvailClass = "good";
                                    } else if (avail <= 60.0 && avail > 20.0) {
                                        myAvailClass = "medium";
                                    } else if (avail <= 20.0 && avail > 0.0) {
                                        myAvailClass = "bad";
                                    } else {
                                        myAvailClass = "zero";
                                    }
                                } else {
                                    out.println("Soucis pour availability");
                                    myAvailClass = "novalue";
                                }
                            %>

                            <span class=" <%= myAvailClass%> "> &nbsp;<%= avail%> % &nbsp; </span>
                        </p>

                        <%out.println("Number of Computers: " + r.getPcTotal());%>
                        <br/><%out.println("Available Computers: " + r.getPcAvailable());%>
                        <br/><%out.println("Computer down: " + r.getPcDown());%>
                        <br/><%out.println("Computer Busy: " + r.getBusy());%>

                        <% if (r.getStatus().equals("Busy")) {
                                out.println("<br/>Lab Status:<blink><font color=\"red\"> booked</font></blink></li>");
                            }%>

                        <br/><%out.println("Computer Types: " + r.getTypeResource());%>
                        <br/><%out.println("Long Description: " + r.getLongDescription());%>
                        <br/><%out.println("Restriction: " + r.getRestriction());%>
                        <br/><%out.println("RoomDescription: " + r.getRoomDescription());%>

                        <br/><%out.println("Computer Down: " + r.getHasComputersDown());%>
                        <br/><%out.println("UserListtestState: " + ul.getJSONstate());%>

                        <p><strong>Computer List</strong></p>
                        <ul>
                            <%
                                if (r.getComputerList() != null) {
                                    for (int i = 0; i < r.getComputerList().length; i++) {
                                        if (r.getComputerList()[i].getRessourceStatus().equals("DOWN")) {
                                            out.println("<li><span class=\"bad\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                        }

                                        if (r.getComputerList()[i].getRessourceStatus().equals("DELETEME")) {
                                            out.println("<li><span class=\"zero\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                        }

                                        if (r.getComputerList()[i].getRessourceStatus().equals("OK")) {
                                            out.println("<li><span class=\"good\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                        }

                                        out.println("Lastseen: " + r.getComputerList()[i].getLastTimeSeen() + "");
                                        out.println("</li>");
                                    }
                                }
                            %>
                        </ul>

                        <%
                            if (ul.getJSONcontent() != null && ul.getJSONcontent().size() > 0) {

                                out.println("<p><strong>Users logged-in</strong></p>");

                                Iterator it = ul.getJSONcontent().iterator();
                                while (it.hasNext()) {

                                    User u = (User) it.next();
                                    // System.out.println(u.getRoomFromResource() + " --- " + r.getIdRoom());
                                    if (u.getRoomFromResource().equals(r.getIdRoom())) {
                                        out.println("<li> <a href=\"#" + u.getIdUser() + "\" data-rel=\"popup\" data-role=\"button\" data-inline=\"true\" data-icon=\"arrow-r\" data-iconpos=\"right\" data-mini=\"true\">"
                                                + u.getIdUser() + " on " + u.getResourceUsedByUser() + " since " + u.getStartTimeSession() + "</a></li>");
                                        out.println("hasHistory : "+u.isHasHistory());
                                        out.println("name : "+u.getNameUser());
                                        if (u.isHasHistory() == true) {
                                            out.println("<p>SizeHistory: " + u.getAllHistoryUser().size()+"</p>");
                                        }

                                    }
                                }
                            } else {
                                out.println("<li>Personne</li>");
                            }


                        %>

                        <br/><%out.println("TimeTable : " + r.getHasTimeTable());
                            if (r.getHasTimeTable()) {
                                
                                for (int i = 0; i < r.getTimeTable().length; i++) {
                                    out.println("<li>Start time : " + r.getTimeTable()[i].getStartTime() + "");
                                    out.println("End Time : " + r.getTimeTable()[i].getEndTime() + "");
                                    out.println("Event type : " + r.getTimeTable()[i].getEventType() + "");
                                    out.println("Event descritpion : " + r.getTimeTable()[i].getEventDescription() + "</li>");

                                    r.getTimeTable()[i].getEventType();
                                }
                            }

                        %>
                        <br/><%out.println("Long location : " + r.getLongLocation());%>

                        <%} else {
                                out.println("<li><blink><font color=\"red\">Room busy</font></blink></li>");
                            }%>

                        <%
                            Date today = new Date();
                            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            Calendar cal = new GregorianCalendar();
                            cal.setTime(today);
                            cal.add(Calendar.DAY_OF_MONTH, -1);
                            Date today1 = cal.getTime();
                            cal.add(Calendar.DAY_OF_MONTH, -7);
                            Date today7 = cal.getTime();
                            cal.add(Calendar.DAY_OF_MONTH, -30);
                            Date today30 = cal.getTime();
                        %>

                        <p><strong>Lab usage</strong></p>
                        <a href="#<%= r.getIdRoom()%>-day" data-rel="popup" data-role="button" data-inline="true" >Day</a>
                        <a href="#<%= r.getIdRoom()%>-week" data-rel="popup" data-role="button" data-inline="true" >Week</a>
                        <a href="#<%= r.getIdRoom()%>-month" data-rel="popup" data-role="button" data-inline="true" >Month</a>
                    </div>

                    <div data-role="collapsible">
                        <h3>Software</h3>
                        <%  if (r.getHasGroups().equals("YES")) {
                                int index;


                                for (index = 0; index < r.getGroupsSoftwareList().size(); index++) {

                                    out.println("<div data-role=\"collapsible-set\" data-theme=\"b\" data-content-theme=\"d\">");
                                    out.println("<h3>" + r.getGroupsSoftwareList().get(index).getIdGroup() + "</h3>");
                                    out.println("<p>");
                                    for (int f = 0; f < r.getGroupsSoftwareList().get(index).getSoftwareContents().size(); f++) {
                                        out.println(r.getGroupsSoftwareList().get(index).getSoftwareContents().get(f).getIdSoftware());

                                        if (r.getGroupsSoftwareList().get(index).getSoftwareContents().get(f).getDescriptionSoftware() == "null") {
                                            out.println("Description Soft :" + r.getGroupsSoftwareList().get(index).getSoftwareContents().get(f).getDescriptionSoftware());

                                        }
                                        out.println("<br/>");
                                    }

                                    out.println("</p>");
                                    out.println("</div>");
                                }
                            } else {
                               out.println("NOTHING");
                            }

                        %>

                    </div>
                </div>
                <a href="campusLocations.html" data-role="button" data-icon="search">View on Google Map</a>


                <div data-role="popup" id="<%= r.getIdRoom()%>-day" data-overlay-theme="a"  data-corners="false">
                    <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today1)
                                + "&timeEnd=" + ft.format(today) + "&resource=" + r.getIdRoom() + '\"'
                                + " style=\"max-width:100%; vertical-align:middle;\"/>");%>
                </div>

                <div data-role="popup" id="<%= r.getIdRoom()%>-week" data-overlay-theme="a"  data-corners="false">
                    <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today7)
                                + "&timeEnd=" + ft.format(today) + "&resource=" + r.getIdRoom() + '\"'
                                + " style=\"max-width:100%; vertical-align:middle;\"/>");%>
                </div>

                <div data-role="popup" id="<%= r.getIdRoom()%>-month" data-overlay-theme="a"  data-corners="false">
                    <% out.println("<img src=\"/WebAppJSF/ImgGraphServlet?timeStart=" + ft.format(today30)
                                + "&timeEnd=" + ft.format(today) + "&resource=" + r.getIdRoom() + '\"'
                                + " style=\"max-width:100%; vertical-align:middle;\"/>");%>
                </div>

                <%
                    if (ul.getJSONcontent() != null && ul.getJSONcontent().size() > 0) {
                        Iterator it = ul.getJSONcontent().iterator();
                        while (it.hasNext()) {
                            User u = (User) it.next();
                            if (u.getRoomFromResource().equals(r.getIdRoom())) {
                %>

                <div data-role="popup" id="<%= u.getIdUser()%>" data-overlay-theme="a" data-corners="false">
                    <img src="<%= u.getIdPicture()%>" style="width:180px; max-width:100%; vertical-align:middle;" />
                </div>
                <%  }
                        }
                    }
                %>

            </div>  
        </div>

    </body>
</html>
