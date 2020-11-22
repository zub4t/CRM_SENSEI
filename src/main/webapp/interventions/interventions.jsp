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
        <title>Gestão Funcionarios </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
            AssingmentServices assingment = new AssingmentServices();
            assingment.setListOfAllAssingment(request, response);
            ProjectServices project = new ProjectServices();
            project.setListOfAllPrj(request, response);
        %>
        <script src="/CRM_SENSEI/management/project/project.js"></script>
        <link href="/CRM_SENSEI/management/project/project.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>

        <div class="user">
            <header class="user__header">
                <img id="logo" src="../../resources/SHI_LOGO-HORIZONTAL-blanco.png" alt="" />
                <h1 class="user__title">registro de funcionarios</h1>
            </header>

            <form class="form" method="POST" action="/CRM_SENSEI/AssingmentController?pwhat=insert">
                <div class="form__group">
                    <select name="cars" id="project"  class="form__input  item">
                        <c:forEach items="${list_prj}" var="item">
                            <option value="${item.getId()}">${item.getN_process()}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="form__group">
                    <select name="cars" id="project"  class="form__input  item">
                        <c:forEach items="${list_assng}" var="item">
                            <option value="${item.getId()}">${item.getDsc()}</option>
                        </c:forEach>

                    </select>
                </div>

                <div class="form__group">
                    <input type="time"  class="form__input  item" placeholder="Tempo dedicado">
                </div>  
                <div class="form__group">
                    <textarea name="dsc" rows="4" cols="50" class="form__input  item" placeholder="Descrição detalhada">Descrição detalhada sobre oque fez no projeto.
                    </textarea>
                </div>
                <button class="btn" type="button">Register</button>
            </form>
        </div>        
    </body>
</html>
