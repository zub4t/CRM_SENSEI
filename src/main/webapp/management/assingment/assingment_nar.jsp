<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page pageEncoding="UTF-8"%>
<%
    // returns null if no session or session is invalid
    if (session.getAttribute("username") != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        %>
        <script src="/CRM_SENSEI_EXTERNAL/management/assingment/assingment.js"></script>
        <link href="/CRM_SENSEI_EXTERNAL/management/assingment/assingment.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>


        <div class="main-content">
            <div class="form">
                <form class="formnar">
                    <div class="form__group">
                        <div class="form_label">Descrição da Tarefa:</div>

                        <div class="form_item">
                            <input  type="text" name="dsc" placeholder="Descrição da Tarefa" class="form__input  item" />
                        </div>
                    </div>
                    <input type="hidden" name="pwhat" value="insert">
                </form>
                <button onclick="event.preventDefault();" class="btn-1" type="button" >Gravar</button>

            </div>
        </div>        
    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>