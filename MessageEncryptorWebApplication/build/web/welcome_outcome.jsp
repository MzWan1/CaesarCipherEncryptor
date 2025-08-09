<%-- 
    Document   : welcome_outcome
    Created on : 08 Aug 2025, 4:36:21 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Outcome Page</title>
    </head>
    <body>
        <h1>Welcome Outcome</h1>
        <%
            String agentName = (String)session.getAttribute("agentName");
            String compName = application.getInitParameter("compName");
        %>
        <p>Hi <b><%=agentName%></b> my name is <b><%=compName%></b> please select option below.</p>
        <p>
            <ul>
                <li><a href="encrypt_message.html">Encrypt Message</a></li>
                <li><a href="ViewAllDecryptedMessagesServlet.do">View All Decrypted Messages</a></li>
                <li><a href="ViewBestPerformingFieldAgentServlet.do">View Best Performing Field Agent </a></li>
                <li><a href="LogoutServlet.do">Logout</a></li>
            </ul>
        </p>
        
    </body>
</html>
