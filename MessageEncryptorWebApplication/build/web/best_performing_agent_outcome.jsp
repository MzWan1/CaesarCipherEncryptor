<%-- 
    Document   : best_performing_agent_outcome
    Created on : 09 Aug 2025, 6:06:40 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Best Performing Field Agent Page</title>
    </head>
    <body>
        <h1>View Best Performing Field Agent</h1>
        <%
            String bestPerformingAgent = (String) session.getAttribute("bestPerformingAgent");
        %>
        <p>
            The best performing agent is: <b><%=bestPerformingAgent%></b>
        </p>
        
        <p><a href="LogoutServlet.do">Logout</a></p>
    </body>
</html>
