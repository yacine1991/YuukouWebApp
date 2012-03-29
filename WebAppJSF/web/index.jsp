<%-- 
    Document   : index
    Created on : 28 mars 2012, 16:20:37
    Author     : Yacine
--%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%

            try {
                out.print("<h1> <b>WHO</b> </h1></br>");
                jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
                jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
                // TODO process result here
                java.lang.String result = port.who();
                out.println(result);

            } catch (Exception ex) {
                Properties prop = System.getProperties();
                out.println(prop.get("javax.net.ssl.trustStore"));
                out.println(ex.getMessage());
                // TODO handle custom exceptions here
            }
        %>



    </body>
</html>


