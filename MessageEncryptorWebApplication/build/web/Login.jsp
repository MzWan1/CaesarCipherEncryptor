<%-- 
    Document   : Login
    Created on : 09 Aug 2025, 6:51:08 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <p>Please enter your login details</p>
        <form action="j_security_check" method="POST">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input name="j_username" type="text" required=""/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input name="j_password" type="text" required=""/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input value="LOGIN" type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
