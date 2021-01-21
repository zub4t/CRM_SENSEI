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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin="anonymous"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://unpkg.com/multiple-select@1.5.2/dist/multiple-select.min.js"></script>
    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>
        <form name="reportPsq" method="POST" action="/CRM_SENSEI/Rpt1">
            <div class="main-content">  
                <div class="table_header"></div>         
                <div class="item">
                    <div>Data de inicio</div>
                    <div>
                        <input id="date_in"  name="date_in" type="date" value="2017-06-01">
                        -to-
                        <input id="date_out" name="date_out" type="date" value="2017-06-01">
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

                <div class="item">
                    <input type="submit" value="pesquisar" class="btn-1" style="width: 400%;">
                </div>
            </div>
        </form>
    </body>
</html>
