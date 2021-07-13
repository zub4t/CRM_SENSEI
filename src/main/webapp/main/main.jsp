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
<%
    if (session.getAttribute("username") != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRM</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>
        <script src="/CRM_SENSEI/main/main.js"></script>
        <link href="/CRM_SENSEI/main/main.css" rel="stylesheet"/>


    </head>
    <%        MenuServices menu = new MenuServices();
        menu.setMenu(request, response);
        ProjectServices projectServices = new ProjectServices();
        projectServices.setListOfModelProjectsByUser(request, response);

    %>
    <body>
        <%@include file="../menu/menu.jsp" %>

        <div class="main-content" style="display: block">
            <div class="user-header">
                <div style="display: flex;">
                    <div class="profile">
                        <div id="profile-img"></div>
                    </div>
                    <div class="welcome-msg">
                        <span id="salutation"> Bom dia</span><br><span id="user_nickname" style="color:#679596">Sr. <%=session.getAttribute("username")%></span>
                    </div>
                </div>
                <div style="float: right">

                    <div class="news">
                        <div id="ring-icon"></div>
                        <span style="color:#679596"> Notificações</span>

                    </div>
                </div>
            </div>
            <div class="projects-in-working" style="overflow-y: scroll; height: 700px">
                <%@include file="../componentes/card_view/card_view.jsp" %>

            </div>
        </div>


        <%@include file="../componentes/modal_add_hour/modal_add_hour.jsp" %>


    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>