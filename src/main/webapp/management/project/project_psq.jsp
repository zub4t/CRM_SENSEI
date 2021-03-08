
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
<%
 // returns null if no session or session is invalid
if(session.getAttribute("username")!=null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);


        %>
        <script src="/CRM_SENSEI_EXTERNAL/management/project/project.js"></script>
        <link href="/CRM_SENSEI_EXTERNAL/management/project/project.css" rel="stylesheet"/>

    </head>
    <body>
        <form id="goToProject" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="projectId" value="">
        </form>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <% if (menu.isVisible(request, 1)) { %>
            <span class="plusButton" onclick="window.location.href = '/CRM_SENSEI_EXTERNAL/management/project/project_nar.jsp'"><img  src="/CRM_SENSEI_EXTERNAL/resources/plus-sign.png" width="20px"/></span>
                <%}%>
            <div class="table_header"></div>
          
                <%@include file="project_table.jsp" %>
        
            <div class="table_footer"></div>


        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>