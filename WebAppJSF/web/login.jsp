<%--
   Document : Login page
   Author   : Thierry
   Year     : 2012
--%>

<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="html" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<core:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>UoW login</title>
        </head>
        <body>          
            <div align="center">
                <h1><html:outputText value="Authentication"/></h1>
                <form method="POST" action="j_security_check">
                <table border="0">
                    <tr>
                        <td>Login :</td>
                        <td>
                            <input type="text" name="j_username" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td>
                            <input type="password" name="j_password" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <html:commandButton action="Portal" value="Login" />
                        </td>
                    </tr>
                </table>
                </form>
            </div>
                        <div>
                            <table width="770"  cellpadding="0" cellspacing="0" class="TableLayout" summary="footer table">
                <tr>

                    <td width="768" bgcolor="#000033" class="footer">&nbsp;
                        
                    </td>
                    
                </tr>
                <tr>

                    <td class="FooterText" colspan="5" align="right">
                        <br>
                        University of Westminster, Headquarters, 309 Regent Street, London W1B 2UW, +44 (0)20 7911 5000
                    </td>
                </tr>

            </table>
                        </div>     
        </body>
    </html>
</core:view>
