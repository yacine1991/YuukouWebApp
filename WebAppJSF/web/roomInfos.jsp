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

<%
    Room r = (Room) request.getAttribute("room");
    UserList ul = (UserList) request.getAttribute("userlist");
    String siteletter = r.getLetterDescription();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rooms Infos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/latest/jquery.mobile.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/latest/jquery.mobile.js"></script>
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

        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>

        <% String gmap_file = "gmap/gmap-" + siteletter + ".js";%>
        <jsp:include page='<%= gmap_file%>' />        

        <style type="text/css">
            #map_canvas { 
                border: thin solid;
                height: 220px;
                <!--left: 18px;
                position: relative;
                top: 18px;-->
                padding: 5% 5% 5% 5%;
                vertical-align: middle;
                width: 420px; 
                overflow: hidden;
                max-width:100%;
                margin-left: 5%; 
            }
        </style> 
    </head>
    <body onload="initialize();">
        <div data-role="page" data-theme="d">
            <div data-role="header">
                <h1>Room <%out.println(r.getIdRoom());%></h1>
                <a href="" data-icon="back" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
                <a data-icon="refresh"  data-iconpos="notext" data-rel="dialog" data-transition="fade" href="javascript:document.location.reload();"></a>
            </div>
            <div data-role="content">

                <%out.println("<center><img src=\"images/" + r.getIdRoom() + ".jpg\" alt=\"salle\" width='90%' style='max-width:400px;max-height:300px' /></center>");%>
                <br/><%out.println("<center>" + r.getRoomDescription() + "</center>");%>
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

                                    myAvailClass = "novalue";
                                }
                            %>

                            <span class=" <%= myAvailClass%> "> &nbsp;<%= avail%> % &nbsp; </span>
                        </p>


                        <br/><%out.println("Available Computers: " + r.getPcAvailable());%>                        
                        <br/><%out.println("Computer Busy: " + r.getBusy());%>

                        <% if (r.getStatus().equals("Busy")) {
                                out.println("<br/>Lab Status:<blink><font color=\"red\"> booked</font></blink></li>");
                            }%>

                        <br/><%out.println("Computer Types: " + r.getTypeResource().toUpperCase());%>
                        <br/><%out.println("Location: " + r.getLongDescription());%>
                        <br/><%out.println("Restriction: " + r.getRestriction());%>
                        <br/>
                        <br/><br/>
                        <br/>

                        <div>
                            <ul data-role="listview" data-theme="d" data-filter="true">
                                <li data-role="list-divider" data-theme="a"> Computer List</li>
                                <%
                                    if (r.getComputerList() != null) {
                                        for (int i = 0; i < r.getComputerList().length; i++) {

                                            out.println("<li><a href=\"YuukouServlet?choice=computerInfo&idPc=" + r.getComputerList()[i].getRessourceName() + "\">");
                                            if (r.getComputerList()[i].getRessourceStatus().equals("DOWN")) {
                                                out.println("<span class=\"bad\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                            }

                                            if (r.getComputerList()[i].getRessourceStatus().equals("DELETEME")) {
                                                out.println("<span class=\"zero\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                            }

                                            if (r.getComputerList()[i].getRessourceStatus().equals("OK")) {
                                                out.println("<span class=\"good\">" + r.getComputerList()[i].getRessourceName() + "</span>");
                                            }
                                            if (r.getComputerList()[i].getLastTimeSeen().equals("null")) {
                                                out.println("Lastseen: Never seen alive");
                                            } else {
                                                out.println("Lastseen: " + r.getComputerList()[i].getLastTimeSeen());
                                            }

                                            out.println("</a>");
                                            out.println("</li>");


                                        }

                                    }
                                %>
                            </ul>7
                        </div>

                        <br/>
                        <br/>
                        <div>
                            <ul data-role="listview" data-theme="d" data-filter="true">
                                <li data-role="list-divider" data-theme="a"> Users logged-in</li>
                                <%
                                    if (ul.getJSONcontent() != null && ul.getJSONcontent().size() > 0) {



                                        Iterator it = ul.getJSONcontent().iterator();
                                        while (it.hasNext()) {

                                            User u = (User) it.next();
                                            // System.out.println(u.getRoomFromResource() + " --- " + r.getIdRoom());
                                            if (u.getRoomFromResource().equals(r.getIdRoom())) {
                                                out.println("<li> <a href=\"#" + u.getIdUser() + "\" data-rel=\"popup\"  data-inline=\"true\" data-icon=\"arrow-r\" data-iconpos=\"right\" data-mini=\"true\">"
                                                        + u.getIdUser() + " on " + u.getResourceUsedByUser() + " since " + u.getStartTimeSession() + "</a></li>");

                                                //out.println("<a href=\"YuukouServlet?choice=findUser&idUser="+u.getIdUser()+"\">More about this User</a>");


                                            }
                                        }
                                    } else {
                                        out.println("<li>No logged-in users</li>");
                                    }


                                %>
                            </ul>
                        </div>
                        <br/>
                        <br/>
                        <div>
                            <br/><%
                                if (r.getHasTimeTable()) {
                                    out.println("<ul data-role=\"listview\" data-inset=\"false\">");
                                    out.println("<li data-role=\"list-divider\" data-theme=\"a\"> Time Table</li>");
                                    for (int i = 0; i < r.getTimeTable().length; i++) {
                                        out.println("<li>");
                                        if (r.getTimeTable()[i].getEventId().equals(r.getActualEventId())) {
                                            out.println("<h3>" + r.getTimeTable()[i].getEventType() + " <font color=\"red\" size=-1> ( Current Event )</font></h3>");
                                        } else {
                                            out.println("<h3>" + r.getTimeTable()[i].getEventType() + "</h3>");
                                        }
                                        out.println("<p><strong>" + r.getTimeTable()[i].getStartTime() + "--" + r.getTimeTable()[i].getEndTime() + "</strong></p>");
                                        out.println("<p>Event descritpion : " + r.getTimeTable()[i].getEventDescription() + "</p>");
                                        int j = i + 1;


                                        out.println("<p class=\"ui-li-aside\"><strong>Event n°" + j + "</strong></p>");
                                        out.println("</li>");
                                    }
                                    out.println("</ul>");
                                }

                            %>

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
                        </div>
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
                                out.println("Software content to be populated");
                            }

                        %>

                    </div>
                </div>
                

                <div data-role="popup" id="popupMap" data-overlay-theme="a" data-theme="c"  data-inset="true" style="width:460px; height: 260px; max-width:90%;" >
                    <div id="map_canvas"></div>
                </div>

                <div data-role="popup" id="popuphowtogetthere" data-overlay-theme="a" data-theme="c"  data-inset="true" >
                    <% String siteinfo_file = "siteinfo/site-" + siteletter + ".js";%>
                    <jsp:include page='<%= siteinfo_file%>' />
                </div>

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
                    <br />

                    <a href="YuukouServlet?choice=findUser&idUser=<%= u.getIdUser()%>" data-role="button" data-inline="true" data-rel="dialog">More about this User</a>

                </div>
                <%  }
                        }
                    }
                %>

            </div>
                <div data-role="footer" data-position="fixed"> <h3>Yuukou 2</h3>
                    <a href="#popupMap" style="left: 10px;position: absolute;top: 0.4em;" data-icon="star" data-rel="popup" data-role="button" data-inline="true">Map</a>
                    <a href="#popuphowtogetthere" style="right: 10px;position: absolute;top: 0.4em;" data-icon="info" data-rel="popup" data-role="button" data-inline="true">How to get there</a>

                </div>
        </div>

    </body>
</html>
