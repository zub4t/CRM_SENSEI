<%-- 
    Document   : login
    Created on : 22/out/2020, 2:12:46
    Author     : marco
--%>

<%@page import="util.Constant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
        <title>Page Title</title>
        <link href="<%=Constant.HOST%>/login/login.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,500;1,900&display=swap" rel="stylesheet">
    </head>


    <body>

        <div class="wallpaper">
            <img id="wall" src="<%=Constant.HOST%>/resources/Japan-Kyoto-houses-snow-trees.jpg">
            <div id="filter"></div>

        </div>
        <div id="container-login">
            <div id="logo">
                <svg width="200" height="100" viewBox="0 0 200 100" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                <rect width="200" height="100" rx="10" fill="white" />
                <rect x="46" y="7" width="108" height="87"
                      fill="url(#pattern0)" />
                <defs>
                <pattern id="pattern0"
                         patternContentUnits="objectBoundingBox"
                         width="1" height="1">
                    <use xlink:href="#image0"
                         transform="scale(0.00925926 0.0114943)"
                         />
                </pattern>
                <image id="image0" width="108" height="87"
                       xlink:href="data:image/png;base64,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"
                       />
                </defs>
                </svg>
            </div>
            <form class="form" id="loginForm" method="POST" action="<%=Constant.HOST%>/EmployeeController?pwhat=login">
                <div class="box-container">
                    <div class="box-items">
                        <div class="label">Login:</div>
                        <div>
                            <input name="nickname" class="input" type="text">
                        </div>
                    </div>
                    <div class="box-items">
                        <div class="label">Senha:</div>
                        <div>
                            <input name="pass" class="input" type="password">
                        </div>
                    </div>

                </div>

                <div>
                    <div>

                        <button class="input btn">ENTRAR</button>
                        <button class="input btn" onclick="document.getElementById('form').action = '/login/signup'">CADASTRAR</button>
                    </div>
                    <div> <a href="" id="label-pass-recovery">Recuperar-Senha</a></div>
                </div>



            </form>
            <div class="version">
                version 0.0.1
            </div>
        </div>

    </body>

</html>