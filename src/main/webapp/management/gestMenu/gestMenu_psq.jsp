<%-- 
    Document   : gestMenu_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="menu.services.MenuServices"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <base href="/CRM_SENSEI">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Menus </title>
        <%
            MenuServices menu1 = new MenuServices();
            menu1.setMenu(request, response);
        %>
        <script src="/CRM_SENSEI/management/gestMenu/gestMenu.js"></script>
        <link href="/CRM_SENSEI/management/gestMenu/gestMenu.css" rel="stylesheet"/>

    </head>
    <body>
        <form id="goToGestMenu" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="menuId" value="">
        </form>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <div class="table_header"></div>
            <div id="table">
                <%@include file="gestMenu_table.jsp" %>
            </div>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
