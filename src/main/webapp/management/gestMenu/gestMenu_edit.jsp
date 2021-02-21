<%-- 
    Document   : gestMenu_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // returns null if no session or session is invalid
    if (session.getAttribute("username") != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Menu </title>
        <%            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
            request.setCharacterEncoding("UTF-8");
        %>
        <script src="/CRM_SENSEI_EXTERNAL/management/gestMenu/gestMenu.js"></script>
        <link href="/CRM_SENSEI_EXTERNAL/management/gestMenu/gestMenu.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>

        <div class="main-content">
            <div class="form">


                <form class="formnar" method="POST" action="/CRM_SENSEI_EXTERNAL/MenuController?pwhat=update">
                    <input type="hidden" value="${model.id}" name="menuId"/>
                    <div class="form__group">
                        <div class="form_label">Nome: </div>
                        <div class="form_item">
                            <input  type="text" value="${model.nme}" name="nme" placeholder="nome" class="form__input  item" />
                        </div>
                    </div>
                    <div class="form__group">

                        <div class="form_label">Nivel de usuario requerido para aceder a esse menu : </div>
                        <div class="form_item">
                            <input    type="number" value="${model.userLevel}" name="userLevel" placeholder="level" class="form__input item" />
                        </div>
                    </div>
                    <input type="hidden" name="pwhat" value="update">

                </form>
                <button class="btn-1" type="button">Gravar</button>

            </div>  
        </div>
    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>