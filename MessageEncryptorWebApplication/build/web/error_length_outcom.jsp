<%-- 
    Document   : error_length_outcom
    Created on : 08 Aug 2025, 4:26:27 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Length Outcome Page</title>
    </head>
    <body>
        <h1>Error Length Outcome</h1>
        <%
            String error = (String)session.getAttribute("error");
        %>
        <p><b><%=error%></b></p>
        
        <p>Click <a href="initialize.html" >here</a> to return to initialize page.</p>
    </body>
</html>
