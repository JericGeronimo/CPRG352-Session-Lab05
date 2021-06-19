<%-- 
    Document   : login
    Created on : Jun 19, 2021, 1:26:31 AM
    Author     : 855474
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
        <form method="post">
            <label>Username:</label>
            <input type="text" name="input_username" value=${username}><br>

            <label>Password:</label>
            <input type="text" name="input_password" value=${password}><br>

            <input type="submit" name="login_Button" value="Log in">
        </form>
        <p>${message}</p>
    </body>
</html>
