<%-- 
    Document   : adminView
    Created on : 10 mai 2012, 14:00:45
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
        <title>Administrator View</title>
    </head>
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
                </li>

                <li ><a href="YuukouServlet?choice=stattest">Room View</a>
                </li>
            </ul>
        </div>
    </body>
</html>
