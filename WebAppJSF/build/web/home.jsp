<%-- 
    Document   : hom
    Created on : 4 avr. 2012, 12:19:58
    Author     : Yacine
--%>

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
        <title>JSP Page</title>
    </head>
    <body>
        <div data-role="page">

            <div data-role="header">
                <h1>Home</h1>
            </div>
            <ul data-role="listview" data-theme="c" data-filter="true">
                <!--<li><form method="get" action="YuukouServlet">
                        <input type="submit" value ="envoyer"/>
                    </form>
                </li>-->
                <li><a href="YuukouServlet">Find a PC </a>
                </li>
                 <li><a href="Statistics.jsp">stats </a>
                </li>
                <li></li>
            </ul>
        </div>

    </body>
</html>
