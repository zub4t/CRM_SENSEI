<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 // returns null if no session or session is invalid
if(request.getSession(false) != null) {

%>
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
                <img id="logo" src="/CRM_SENSEI/resources/SHI_LOGO-HORIZONTAL-blanco.png" alt="" />
                <h1 class="user__title">registro de projetos</h1>
            </header>

            <form class="form" method="POST" action="/CRM_SENSEI/ProjectController?pwhat=insert" enctype="application/x-www-form-urlencoded;  charset=utf-8">
                <div class="form__group">
                    <input  type="text" name="n_process" placeholder="Numero do processo" class="form__input  item" />
                </div>
                <div class="form__group">
                    <input  type="text" name="nme" placeholder="Nome do Cliente" class="form__input  item" />
                </div>

                <div class="form__group">
                    <input  type="number" step="0.01" name="expected_sale" placeholder="Venda Prevista" class="form__input item"  />
                </div>
                <div class="form__group">
                    <input  type="number" step="0.01" name="effective_sale" placeholder="Venda Efetiva" class="form__input item"  />
                </div>
                <div class="form__group">
                    <input  type="number" step="0.01" name="effective_purchase" placeholder="Compra Efetiva" class="form__input item"  />
                </div>
                 <div class="form__group">
                    <input  type="number" step="0.01" name="honorary" placeholder="honorário" class="form__input item"  />
                </div>
                <input type="hidden" name="pwhat" value="insert">
                <button class="btn-1" type="button">Register</button>
            </form>
        </div>        
    </body>
</html>
<%}else{out.print("Usuario não está logado");}%>