
<%-- 
    Document   : project_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        

        %>
        <script src="/CRM_SENSEI/management/project/project.js"></script>
        <link href="/CRM_SENSEI/management/project/project.css" rel="stylesheet"/>

    </head>
    <body>
        <form id="goToProject" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="projectId" value="">
        </form>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <span class="plusButton" onclick="window.location.href = '/CRM_SENSEI/management/project/project_nar.jsp'"><img  src="https://cdn3.iconfinder.com/data/icons/ui-thick-outline-1-of-5/100/ui_01_of_9-02-512.png" width="20px"/></span>

            <div class="table_header"></div>
            <div id="table">
                <%@include file="project_table.jsp" %>
            </div>
            <div class="table_footer"></div>


        </div>
    </body>
</html>
