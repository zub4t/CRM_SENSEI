<%-- 
    Document   : login
    Created on : 22/out/2020, 2:12:46
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="/CRM_SENSEI_EXTERNAL/login/login.css">
        <script type="application/javascript" src="/CRM_SENSEI_EXTERNAL/login/login.js"></script>
    </head>
    <body>
        <form class="form" id="loginForm" method="POST" action="/CRM_SENSEI_EXTERNAL/EmployeeController?pwhat=login">
            <div class="login container">
                <div class="login logo"><img src="/CRM_SENSEI_EXTERNAL/resources/logo.png"></div>

                <div id="input-group">
                    <div class="group">      
                        <input type="text" name="nickname" required>
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <label>Username</label>
                    </div>

                    <div class="group">      
                        <input type="password" name="pass" required>
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <label>Password</label>
                    </div>

                    <div class="group">
                        <input style="cursor:pointer" type="submit" value="Login">
                    </div>

                    <div class="group">
                        <a id="forgot_pass" onclick=getNewPass()>Esqueceu-se da password</a>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
