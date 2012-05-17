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
        <link rel="stylesheet"  href="http://code.jquery.com/mobile/latest/jquery.mobile.css" />
        <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>  
        <script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>

        <title>Yuukou credits</title>
    </head>
    <body>
       
        <div data-role="page" class="page_map" data-theme="d">

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
                    The first version of Yuukou was originally developed in 2006 by the Information Systems and Library Services department.
                    The development of the second version of Yuukou in 2012 is led by the School of Electronics and Computer Science with the collaboration of the Information Systems and Library Services department. This second version
                    brings a number of new features including reporting of room bookings, a larger number of rooms, PCs and MAC labs as well as many other features.
                <P>
                    One important feature of this new version is the support for mobile devices thanks to the JQuery Mobile API.
            </div>
            
            <center>
                University of Westminster, Headquarters, 309 Regent Street, London W1B 2UW, +44 (0)20 7911 5000 
            </center>
        </div>



        <div data-role="footer" data-position="fixed">

            <h4></h4>
        </div>
    </body>
</html>
