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
        <script src="/CRM_SENSEI_EXTERNAL/report/report.js"></script>
        <link href="/CRM_SENSEI_EXTERNAL/report/report.css" rel="stylesheet"/>

    </head>
    <body>

        <%@include file="../../menu/menu.jsp" %>
        <div class="main-content">  
            <div class="form">
                <form class="formnar" name="reportPsq" method="POST" action="/CRM_SENSEI_EXTERNAL/Rpt1">
                    <div class="form__group">

                        <div class="form_label">Projetos com intervenções entre o periodo</div>
                        <div class="form_item">
                            <input id="date_in"  name="date_in" type="date" value="2020-06-01">
                            -to-
                            <input id="date_out" name="date_out" type="date" value="2021-06-01">
                        </div>
                    </div>
                    <div class="form__group" style="margin-bottom: 200px">

                        <div class="form_label">Projetos</div>
                        <div class="form_item"> 
                            <select  name="prjct_selected" id="slct" multiple="multiple">
                                <c:forEach items="${projectList}" var="item"   varStatus="loop">
                                    <option id="projeto_${item.id}" value="${item.id}">${item.n_process} | ${item.customer_nme}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
                <% if(menu.isVisible(request, 15)){ %>
                <button  onclick="$('.formnar').submit();"class="btn-1" type="button">Exportar</button>
                <%}%>
            </div>
        </div>
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>