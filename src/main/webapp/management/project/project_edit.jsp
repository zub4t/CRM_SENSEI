<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
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

            <form class="form" method="POST" action="/CRM_SENSEI/ProjectController?pwhat=update">
                <input type="hidden" value="${model.id}" name="projectId"/>
                <div class="form__group">
                    <input  type="text" name="n_process" value="${model.n_process}" placeholder="Numero do processo" class="form__input  item" />
                </div>
                <div class="form__group">
                    <input  type="text" name="nme" value="${model.customer_nme}" placeholder="Nome do Cliente" class="form__input  item" />
                </div>

                <div class="form__group">
                    <input  type="number" step="0.01" value="${model.expected_sale}" name="expected_sale" placeholder="Venda Prevista" class="form__input item"  />
                </div>
                <div class="form__group">
                    <input  type="number" step="0.01" value="${model.effective_sale}" name="effective_sale" placeholder="Venda Efetiva" class="form__input item"  />
                </div>
                <div class="form__group">
                    <input  type="number" step="0.01" value="${model.effective_purchase}" name="effective_purchase" placeholder="Compra Efetiva" class="form__input item"  />
                </div>
                <button class="btn" type="button">Edit</button>
            </form>
        </div>        
    </body>
</html>
