<%-- 
    Document   : main
    Created on : 2/nov/2020, 0:18:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>
        <script src="/CRM_SENSEI/main/main.js"></script>
        <link href="/CRM_SENSEI/main/main.css" rel="stylesheet"/>
        

    </head>
    <%
        MenuServices menu = new MenuServices();
        menu.setMenu(request, response);
        ProjectServices projectServices = new ProjectServices();
        projectServices.setProjects(request, response);
    %>
    <body>
         <%@include file="../main/chart.jsp" %>
        <%@include file="../menu/menu.jsp" %>
        <form id="changeChart" method="GET" action="">
            <input type="hidden" name="pwhat" value="setCurProjectId">
            <input type="hidden" name="curProjectId" value="">
        </form>
        <div class="watermark"></div>
        <div id="project-selector">
            <div class="select">
                <select onchange="setCurrentProjectId(this)" name="prjct-selected" id="slct">
                    <c:forEach items="${projectList}" var="item"   varStatus="loop">
                        <option id="projeto_${item.id}" value="${item.id}">${item.n_process} </option>
                    </c:forEach>
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
