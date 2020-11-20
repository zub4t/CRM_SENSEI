<%-- 
    Document   : main
    Created on : 2/nov/2020, 0:18:28
    Author     : marco
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script src="/CRM_SENSEI/main/main.js"></script>
        <link href="/CRM_SENSEI/main/main.css" rel="stylesheet"/>

    </head>
    <%
        MenuServices menu = new MenuServices();
        menu.setMenu(request, response);
    %>
    <body>
        <%@include file="../menu/menu.jsp" %>

        <div class="watermark"></div>
        <div id="project-selector">
            <div class="select">
                <select name="prjct-selected" id="slct">
                    <option>Projeto 1 </option>
                    <option>Projeto 2 </option>
                    <option>Projeto 3 </option>
                    <option>Projeto 4 </option>
                    <option>Projeto 5 </option>
                    <option>Projeto 6 </option>

                </select>
            </div>
        </div>
        <div class="main-content">
            <div id="canvans-content">
                <canvas id="myChart" width="400" height="400"></canvas>
            </div>

        </div>
    </body>
</html>
