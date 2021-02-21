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
    if (request.getSession(false) != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        %>
        <script src="/CRM_SENSEI/management/project/project.js"></script>
        <link href="/CRM_SENSEI/management/project/project.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>

        <div class="main-content">
            <div class="form">
                <form class="formnar" method="POST" action="/CRM_SENSEI/ProjectController?pwhat=insert" enctype="application/x-www-form-urlencoded;  charset=utf-8">

                    <div class="form__group">
                        <div class="form_label">Nº do processo:</div>
                        <div class="form_item">
                            <input  type="text" name="n_process" placeholder="Numero do processo" class="form__input  item" />
                        </div>                   
                    </div>
                    <div class="form__group">
                        <div class="form_label">Nome do cliente:</div>
                        <div class="form_item">
                            <input  type="text" name="nme" placeholder="Nome do Cliente" class="form__input  item" />
                        </div>                   
                    </div>

                    <div class="form__group">
                        <div class="form_label">Venda Prevista:</div>
                        <div class="form_item">
                            <input  type="number" step="0.01" name="expected_sale" placeholder="Venda Prevista" class="form__input item"  />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Venda Efetiva</div>
                        <div class="form_item">
                            <input  type="number" step="0.01" name="effective_sale" placeholder="Venda Efetiva" class="form__input item"  />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Compra Efetiva</div>
                        <div class="form_item">
                            <input  type="number" step="0.01" name="effective_purchase" placeholder="Compra Efetiva" class="form__input item"  />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">honorário</div>
                        <div class="form_item">
                            <input  type="number" step="0.01" name="honorary" placeholder="honorário" class="form__input item"  />
                        </div>    
                    </div>
                    <input type="hidden" name="pwhat" value="insert">
                </form>
                <button onclick="event.preventDefault();" class="btn-1" type="button">Gravar</button>

            </div>

        </div>        
    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>