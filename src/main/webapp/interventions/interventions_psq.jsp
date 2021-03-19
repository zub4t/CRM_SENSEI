<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("username")!= null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intervenções Pesquisar </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        %>
        <script src="/CRM_SENSEI/interventions/interventions.js"></script>
        <link href="/CRM_SENSEI/interventions/interventions.css" rel="stylesheet"/>

    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>

        <form id="formId" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="id" value="">
        </form>
        <div id="table_container">
            <% if(menu.isVisible(request, 11)){ %>
            <span class="plusButton" onclick="window.location.href = '/CRM_SENSEI/interventions/interventions_nar.jsp'"><img  src="/CRM_SENSEI/resources/plus-sign.png" width="20px"/></span>
                <% } %>
            <div class="table_header"></div>

            <%@include file="interventions_table.jsp" %>

            <div class="table_footer"></div>

        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>