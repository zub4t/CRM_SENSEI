<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Intervenções Criar</title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
            AssingmentServices assingment = new AssingmentServices();
            assingment.setListOfAllAssingment(request, response);
            ProjectServices project = new ProjectServices();
            project.setListOfAllPrj(request, response);
        %>
        <script src="/CRM_SENSEI/interventions/interventions.js"></script>
        <link href="/CRM_SENSEI/interventions/interventions.css" rel="stylesheet"/>
        <script>
            window.addEventListener("load", function (event) {
                document.querySelector("[name=project_id]").value = ${model.project_id};
                document.querySelector("[name=assingment_id]").value = ${model.assingment_id};
            <%if(request.getAttribute("edit") != null){%>
                document.querySelector("[name=pwhat]").value = "update";

            <%}%>

            });
        </script>
    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>

        <div class="user">
            <header class="user__header">
                <img id="logo" src="../../resources/SHI_LOGO-HORIZONTAL-blanco.png" alt="" />
                <h1 class="user__title">registro de funcionarios</h1>
            </header>

            <form class="form" method="POST" action="/CRM_SENSEI/InterventionsController">

                <%if(request.getAttribute("edit") != null){%>
                <input type="hidden" name="id" value="${model.id}">

                <%}%>
                <input type="hidden" name="pwhat" value="insert">
                <div class="form__group">
                    <select name="project_id"   class="form__input  item">
                        <c:forEach items="${projectList}" var="item">
                            <option value="${item.getId()}">${item.getN_process()}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="form__group">
                    <select name="assingment_id"  class="form__input  item">
                        <c:forEach items="${list_assng}" var="item">
                            <option value="${item.getId()}">${item.getDsc()}</option>
                        </c:forEach>

                    </select>
                </div>



                <div class="form__group">
                    <input name="spend_time" type="time"  class="form__input  item" placeholder="Tempo dedicado">
                </div>  
                <div class="form__group">
                    <textarea name="dsc" rows="4" cols="50" class="form__input  item" placeholder="Descrição detalhada">${model.dsc}</textarea>
                </div>
                <button class="btn-1" type="button">Register</button>
            </form>
        </div>        
    </body>
</html>
