<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.assingment.services.AssingmentServices"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // returns null if no session or session is invalid
    if (session.getAttribute("username") != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);

        %>
        <script src="/CRM_SENSEI/management/assingment/assingment.js"></script>
        <link href="/CRM_SENSEI/management/assingment/assingment.css" rel="stylesheet"/>

    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>
        <form id="formId" method="GET" action="">
            <input type="hidden" name="pwhat" value="">
            <input type="hidden" name="id" value="">
        </form>
        <div id="table_container">
            <%if (session.getAttribute("username").equals("Mario") || session.getAttribute("username").equals("admin")) {%>

            <span class="plusButton" onclick="nnew()"><img  src="/CRM_SENSEI/resources/plus-sign.png" width="20px"/></span>
                <%}%>
            <span class="saveButton" onclick="saveOrder()">  <img width="24px" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZlcnNpb249IjEuMSIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnN2Z2pzPSJodHRwOi8vc3ZnanMuY29tL3N2Z2pzIiB3aWR0aD0iNTEyIiBoZWlnaHQ9IjUxMiIgeD0iMCIgeT0iMCIgdmlld0JveD0iMCAwIDUxMiA1MTIiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUxMiA1MTIiIHhtbDpzcGFjZT0icHJlc2VydmUiIGNsYXNzPSIiPjxnPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgoJPGc+CgkJPHBhdGggZD0iTTM0Niw0MjJIMTY2Yy04LjI4NCwwLTE1LDYuNzE2LTE1LDE1czYuNzE2LDE1LDE1LDE1aDE4MGM4LjI4NCwwLDE1LTYuNzE2LDE1LTE1UzM1NC4yODQsNDIyLDM0Niw0MjJ6IiBmaWxsPSIjZmZmZmZmIiBkYXRhLW9yaWdpbmFsPSIjMDAwMDAwIiBzdHlsZT0iIiBjbGFzcz0iIj48L3BhdGg+Cgk8L2c+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KCTxnPgoJCTxwYXRoIGQ9Ik0zNDYsMzAySDE2NmMtOC4yODQsMC0xNSw2LjcxNi0xNSwxNXM2LjcxNiwxNSwxNSwxNWgxODBjOC4yODQsMCwxNS02LjcxNiwxNS0xNVMzNTQuMjg0LDMwMiwzNDYsMzAyeiIgZmlsbD0iI2ZmZmZmZiIgZGF0YS1vcmlnaW5hbD0iIzAwMDAwMCIgc3R5bGU9IiIgY2xhc3M9IiI+PC9wYXRoPgoJPC9nPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+Cgk8Zz4KCQk8cGF0aCBkPSJNMzQ2LDM2MkgxNjZjLTguMjg0LDAtMTUsNi43MTYtMTUsMTVzNi43MTYsMTUsMTUsMTVoMTgwYzguMjg0LDAsMTUtNi43MTYsMTUtMTVTMzU0LjI4NCwzNjIsMzQ2LDM2MnoiIGZpbGw9IiNmZmZmZmYiIGRhdGEtb3JpZ2luYWw9IiMwMDAwMDAiIHN0eWxlPSIiIGNsYXNzPSIiPjwvcGF0aD4KCTwvZz4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgoJPGc+CgkJPHJlY3QgeD0iMTIxIiB3aWR0aD0iMjEwIiBoZWlnaHQ9IjEzMCIgZmlsbD0iI2ZmZmZmZiIgZGF0YS1vcmlnaW5hbD0iIzAwMDAwMCIgc3R5bGU9IiIgY2xhc3M9IiI+PC9yZWN0PgoJPC9nPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+Cgk8Zz4KCQk8cGF0aCBkPSJNNTA3LjYwNiw4NC4zOTRsLTgwLTgwQzQyNC43OTMsMS41ODEsNDIwLjk3OCwwLDQxNywwaC01NnYxNDVjMCw4LjI4NC02LjcxNiwxNS0xNSwxNUgxMDZjLTguMjg0LDAtMTUtNi43MTYtMTUtMTVWMEgxNSAgICBDNi43MTYsMCwwLDYuNzE2LDAsMTV2NDgyYzAsOC4yODQsNi43MTYsMTUsMTUsMTVjNC42NDUsMCw0NzUuNzYyLDAsNDgyLDBjOC4yODQsMCwxNS02LjcxNiwxNS0xNVY5NSAgICBDNTEyLDkxLjAyMiw1MTAuNDE5LDg3LjIwNyw1MDcuNjA2LDg0LjM5NHogTTM5MSw0ODJIMTIxVjI3MmgyNzBWNDgyeiIgZmlsbD0iI2ZmZmZmZiIgZGF0YS1vcmlnaW5hbD0iIzAwMDAwMCIgc3R5bGU9IiIgY2xhc3M9IiI+PC9wYXRoPgoJPC9nPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8L2c+CjxnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyI+CjwvZz4KPGcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPC9nPgo8ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciPgo8L2c+CjwvZz48L3N2Zz4=" /> </span>

            <% if (menu.isVisible(request, 1)) { %>
            <%}%>
            <div class="table_header"></div>


            <%@include file="assingment_table.jsp" %>

            <div class="table_footer"></div>

        </div>
    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>