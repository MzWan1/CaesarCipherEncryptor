<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Decrypted Messages</title>
</head>
<body>
    <h1>Decrypted Messages</h1>
    
    <%
        List<String> messageList = (List<String>) session.getAttribute("decryptedMessageList");
        
        if (messageList == null || messageList.isEmpty()) {
    %>
        <p>No messages found.</p>
    <%
        } else {
    %>
        <table border="1">
            <tr>
                <th>Message</th>
            </tr>
            <%
                for (String message : messageList) {
            %>
            <tr>
                <td><%= message %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>
    
    <p><a href="LogoutServlet.do">Logout</a></p>
</body>
</html>
