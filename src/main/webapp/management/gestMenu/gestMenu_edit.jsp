<%-- 
    Document   : gestMenu_nar
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
        <title>Gestão Menu </title>
        <%
            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
            request.setCharacterEncoding("UTF-8");
        %>
        <script src="/CRM_SENSEI/management/gestMenu/gestMenu.js"></script>
        <link href="/CRM_SENSEI/management/gestMenu/gestMenu.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>

        <div class="user">
            <header class="user__header">
                <img id="logo" src="../../resources/SHI_LOGO-HORIZONTAL-blanco.png" alt="" />
                <h1 class="user__title">registro de menu</h1>
            </header>

            <form class="form" method="POST" action="/CRM_SENSEI/MenuController?pwhat=update">
                <input type="hidden" value="${model.id}" name="menuId"/>
                <div class="form__group">
                    <input  type="text" value="${model.nme}" name="nme" placeholder="nome" class="form__input  item" />
                </div>
                <div class="form__group">
                    <input    type="number" value="${model.userLevel}" name="userLevel" placeholder="level" class="form__input item" />
                </div>
                <button class="btn-1" type="button">Edit</button>
            </form>
        </div>        
    </body>
</html>
