<%-- 
    Document   : error_not_empty_outcom
    Created on : 08 Aug 2025, 5:26:00 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Text area not empty Page</title>
    </head>
    <body>
        <h1>Text area not empty</h1>
        <%
            String error = (String)session.getAttribute("error");
        %>
        <p><b><%=error%></b></p>
        
        <p>Click <a href="initialize.html" >here</a> to return to initialize page.</p>
    </body>
</html>
