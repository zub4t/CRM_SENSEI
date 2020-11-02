<%-- 
    Document   : login
    Created on : 22/out/2020, 2:12:46
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="login.css">
    </head>
    <body>

        <div class="login container">
            <div class="login logo"><img src="../resources/shistudio-logo-160x90.png"></div>

            <div id="input-group">
                <div class="group">      
                    <input type="text" required>
                    <span class="highlight"></span>
                    <span class="bar"></span>
                    <label>Username</label>
                </div>

                <div class="group">      
                    <input type="password" required>
                    <span class="highlight"></span>
                    <span class="bar"></span>
                    <label>Password</label>
                </div>


            </div>
    </body>
</html>
