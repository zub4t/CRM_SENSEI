<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<%@page import="interventions.services.InterventionsServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
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
        <title>Intervenções Pesquisar </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);

            ProjectServices projectServices = new ProjectServices();
            projectServices.setListOfAllPrj(request, response);
        %>
        <script src="/CRM_SENSEI/report/report.js"></script>
        <link href="/CRM_SENSEI/report/report.css" rel="stylesheet"/>

    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>
        <form name="reportPsq" method="POST" action="/CRM_SENSEI/Rpt1">
            <div class="main-content">  
                <div class="table_header"></div>         
                <div class="item">
                    <div>Data de inicio</div>
                    <div>
                        <input id="date_in"  name="date_in" type="date" value="2020-06-01">
                        -to-
                        <input id="date_out" name="date_out" type="date" value="2021-06-01">
                    </div>
                </div>

                <div class="select item" >
                    <div>Projeto</div>
                    <select  name="prjct_selected" id="slct" multiple="multiple">
                        <c:forEach items="${projectList}" var="item"   varStatus="loop">
                            <option id="projeto_${item.id}" value="${item.id}">${item.n_process} </option>
                        </c:forEach>
                    </select>
                </div>
                <% if(menu.isVisible(request, 15)){ %>
                <div class="item">
                    <input type="submit" value="Exportar relatório" class="btn-1" style=" width: 20vw;">
                </div>
                <%}%>
            </div>
        </form>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>