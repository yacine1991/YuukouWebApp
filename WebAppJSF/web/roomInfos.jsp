<%-- 
    Document   : index
    Created on : 28 mars 2012, 16:20:37
    Author     : Yacine
--%>
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
        <link rel="stylesheet" href="jquery.mobile-1.0.1.min.css" />
        <script src="jquery-1.7.1.min.js"></script>
        <script src="jquery.mobile-1.0.1.min.js"></script>
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

            <%out.println("<center><img src=\"images/" + r.getIdRoom() + ".jpg\" alt=\"salle\"/ width='90%'></center>");%>
              <div data-role="collapsible-set" data-theme="c" data-content-theme="d">
                    <div data-role="collapsible">
                        <h3>Status</h3>
                        
		
                        <h2>Button basics</h2>		
		
         <ul data-role="controlgroup" data-type="horizontal" class="localnav">
            <a href="#buttons-<%= r.getIdRoom() %>" data-role="button" data-transition="fade" class="ui-btn-active">Basics</a>
	    <a href="#buttons-<%= r.getIdRoom() %>-down" data-role="button" data-transition="fade">Down</a>
	    <a href="#buttons-<%= r.getIdRoom() %>-busy" data-role="button" data-transition="fade">Busy</a>
	    <a href="#buttons-<%= r.getIdRoom() %>-tt" data-role="button" data-transition="fade">Events</a>
         </ul>
                        
                        <p>

                <% if (r.getStatus().equals("Available")) {%>
                <br/><%out.println("Health Room : " + r.getHealthRoom());%>
                <br/><%out.println("Available Computers : " + r.getPcAvailable());%>
                <br/><%out.println("Computer down : " + r.getPcDown());%>
                <br/><%out.println("Computer Busy : " + r.getBusy());%>
                <br/><%out.println("Computer Types : " + r.getTypeResource());%>
                <br/><%out.println("Long Description : " + r.getLongDescription());%>
                <br/><%out.println("Restriction : " + r.getRestriction());%>
                <br/><%out.println("Computer Down : " + r.getHasComputersDown());%>
                <br/><%out.println("UserListtestState : " + ul.getJSONstate());%>
                <br/><%out.println("Computer down : " + r.getPcDown());%>
                
                
                  <%
                    if (r.getComputerList() != null) {
                        for (int i = 0; i < r.getComputerList().length; i++) {
                            out.println("<li>Nom PC foutu : " + r.getComputerList()[i].getRessourceName() + "");
                            out.println("Salle ou il est : " + r.getComputerList()[i].getRessouceRoom() + "");
                            out.println("Status : " + r.getComputerList()[i].getRessourceStatus() + "");
                            out.println("lasttimeseen : " + r.getComputerList()[i].getLastTimeSeen() + "</li>");
                        }
                    }
                  %>

                 <%
                    if (ul.getJSONcontent() != null && ul.getJSONcontent().size() > 0) {
                        Iterator it = ul.getJSONcontent().iterator();
                        while (it.hasNext()) {

                            User u = (User) it.next();
                            System.out.println(u.getRoomFromResource() + " --- " + r.getIdRoom());
                            if (u.getRoomFromResource().equals(r.getIdRoom())) {
                                out.println("<li>Id user connecté : " + u.getIdUser() + "   Resource Used" + u.getResourceUsedByUser() + "</li>");
                            
                            }
                        }
                    } else {
                        out.println("<li>Personne</li>");
                    }

                %>

                <br/><%out.println("TimeTable : " + r.getHasTimeTable());
                    if (r.getHasTimeTable()) {
                        System.out.print("Lenght " + r.getTimeTable().length);
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
                        /*
                         * out.println("<li>Start time : " + r.getStartTime() +
                         * "</li>"); out.println("<li>End Time : " +
                         * r.getEndTime() + "</li>"); out.println("<li>Event
                         * type : " + r.getEventType() + "</li>");
                         */
                    }%>
                    </div>
                <div data-role="collapsible">
                    <h3>Software</h3>
                    <p>
                         Windows 7<br/>
                         Build release: Kiwi 1.1<br/>
                    </p>
                    
                    <div data-role="collapsible-set" data-theme="b" data-content-theme="d">
                        
                      <div data-role="collapsible">
                       <h3>Baseline</h3>
                       <p>            
                        7-Zip 9.20<br />
                        Adobe Authorware<br />
                      </div>
                        
                       <div data-role="collapsible">
                        <h3>ECS core</h3>
                        <p>            
                        Rational Rose<br />
                        Visual Studio<br />
                       </div>
        </div>
                </div>
                    <a href="campusLocations.html" data-role="button" data-icon="search">View on Google Map</a>
                    
                    
            
        
             
              </div>
                </div>
        </div>
        
         
             
                    
    </body>
</html>


