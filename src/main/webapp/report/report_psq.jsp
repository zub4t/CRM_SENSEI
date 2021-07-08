<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<%@page import="interventions.services.InterventionsServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<%@page import="management.employee.services.EmployeeServices"%>

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
            
            EmployeeServices employeeServices = new EmployeeServices();
            employeeServices.setListOfAllEmployes(request,response);
        %>
        <script src="/CRM_SENSEI/report/report.js"></script>
        <link href="/CRM_SENSEI/report/report.css" rel="stylesheet"/>

    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>
        <div class="main-content">  
            <div class="form" style="height: 500px">
                <% if(menu.isVisible(request, 15)){ %>

                <form class="formnar" name="reportPsq" method="POST" action="/CRM_SENSEI/Rpt1">
                    <%}else{%>
                    <form class="formnar" name="reportPsq" method="POST" action="/CRM_SENSEI/Rpt2">

                        <%}%>
                        <div class="form__group">

                            <div class="form_label dots3">Projetos com intervenções entre o periodo</div>
                            <div class="form_item">
                                <input id="date_in"  name="date_in" type="date" value="2020-06-01">
                                -to-
                                <input id="date_out" name="date_out" type="date" value="2021-06-01">
                            </div>
                        </div>
                        <div class="form__group" >

                            <div class="form_label">Projetos</div>
                            <div class="form_item"> 
                                <select  name="prjct_selected" id="prj_slct" multiple="multiple">
                                    <c:forEach items="${projectList}" var="item"   varStatus="loop">
                                        <option id="projeto_${item.id}" value="${item.id}"> ${item.customer_nme}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form__group">

                            <div class="form_label">Funcionários </div>
                            <div class="form_item"> 
                                <select  name="employee_selected" id="employee_slct" multiple="multiple">
                                    <c:forEach items="${list}" var="item"   varStatus="loop">
                                        <option id="employee_${item.id}" value="${item.id}">${item.nme}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </form>
                    <button  onclick="$('.formnar').submit();"class="btn-1" type="button">Exportar</button>
            </div>
        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>