<%-- 
    Document   : info
    Created on : May 5, 2012, 8:16:38 PM
    Author     : thierry
--%>

<%@page import="com.yuukou.data.RoomList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="http://code.jquery.com/mobile/latest/jquery.mobile.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/latest/jquery.mobile.js"></script>
    
        <title>Yuukou Project</title>
    </head>
    <body>
        <div data-role="page" class="page_map">

 <div data-role="header" data-position="fixed">
        <a href="" data-icon="back" data-iconpos="notext" data-rel="back" data-direction="reverse">Back</a> 
         <h1>Credits</h1>
         </div><!-- /header -->

<div data-role="content">
    
    <center>
    <img border="0" src="images/yuukou_logo.gif">
    <br>
    <A HREF="http://www.westminster.ac.uk/ecs"> Developed by the School of Electronics and Computer Science</A>  
    </center>
    
  <P>
  Yuukou, from the Japanese Yuukou means validity (an), availability and effectiveness. Yuukou collects information about the University of Westminster desktop Grid and shows the availability of desktops in rooms.   
  <P>
  The list of rooms includes PCs and MACs and can be located at any sites at the University including Regent's street, Marylebone,
  Cavendish, Harrow, Little Tichfield Street and Well's Street. Each room describes the number of desktops free for students. In case a room is booked for teaching and is registered in the University timetabling system, 
  it will get reported as booked in Yuukou.
  <P>
  The list of rooms can be filtered using keywords on the text search input field. For example, if you are looking for computers in libraries at any sites, just enter
  "lib". Alternatively, enter "n-lib" if you are only interested about the Cavendish library. The search facility supports keywords in room names, site description, computer types such as "pc" or "mac".
  Site prefix can be used to display rooms at specific sites. Available site prefix name include "e-" for labs in the School of Electronics and Computer Science, "n-" for computer labs or machines in the library at the Cavendish site,
  "r-" for rooms at the Regent Street site, "w-" for rooms at the Well's street site, "l-" for rooms at the Little Tichfield Street site,
  "m-" for rooms at the Marylebone site and "h-" for rooms at the Harrow site.
  <P>
  Some rooms may have access restrictions and may only be available to particular departments of groups of students. For example, specialist labs in the School of Electronics and Computer Science (ECS) are only available to ECS students.
  Some other rooms at other sites are restricted to post-graduate students.
  <P>
  The room availability is represented as a percentage value and also using different colours depending on the value on the scale. High values are green and very low values are in red. Middle values are orange. 
  
    <% RoomList rl = (RoomList) request.getAttribute("roomList");%>

  
</div>

    <center>
        University of Westminster, Headquarters, 309 Regent Street, London W1B 2UW, +44 (0)20 7911 5000 
    </center>
</div>

    
        
<div data-role="footer" data-position="fixed">

<h4>and Google Maps</h4>
</div>
    </body>
</html>
