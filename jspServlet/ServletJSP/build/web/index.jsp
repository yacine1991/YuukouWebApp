<%-- 
    Document   : index
    Created on : 26 mars 2012, 16:17:15
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
        
        
    <%-- start web service invocation --%><hr/>
    <%
    try {
        out.print("Hého");
	jax.webservice.server.YuukouServerService service = new jax.webservice.server.YuukouServerService();
	jax.webservice.server.YuukouServer port = service.getYuukouServerPort();
	// TODO process result here
	java.lang.String result = port.who();
	out.println("Result = "+result);
        
    } catch (Exception ex) {
        Properties prop = System.getProperties();
        out.println(prop.get("javax.net.ssl.trustStore"));
               out.println(ex.getMessage());
	// TODO handle custom exceptions here
    }
    %>
    result
    <%-- end web service invocation --%><hr/>
    </body>
</html>
