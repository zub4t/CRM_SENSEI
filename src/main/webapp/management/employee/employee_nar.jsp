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
    if (session.getAttribute("username") != null) {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Funcionarios </title>
        <%            MenuServices menu = new MenuServices();
            menu.setMenu(request, response);
        %>
        <script src="/CRM_SENSEI_EXTERNAL/management/employee/employee.js"></script>
        <link href="/CRM_SENSEI_EXTERNAL/management/employee/employee.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>


        <div class="main-content">

            <div class="form">
                <form class="formnar" method="POST" action="/CRM_SENSEI_EXTERNAL/EmployeeController?pwhat=insert">
                    <div class="form__group">
                        <div class="form_label">Nome :</div>
                        <div class="form_item">
                            <input  type="text" name="nme" placeholder="nome" class="form__input  item" />
                        </div>
                    </div>

                    <div class="form__group">
                        <div class="form_label">Telefone :</div>
                        <div class="form_item">
                            <input   type="tel" name="tel" placeholder="913648628" class="form__input item"  pattern="[0-9]{9}" />
                        </div>
                    </div>

                    <div class="form__group">
                        <div class="form_label">Email:</div>
                        <div class="form_item">
                            <input   type="email" name="email" placeholder="seuemail@gmail.com" class="form__input item item" />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Salário:</div>
                        <div class="form_item">
                            <input    type="number" name="salary" placeholder="salary" class="form__input item" />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Nivel de Acesso </div>
                        <div class="form_item">
                            <input    type="number" name="userLevel" placeholder="nivel do user (0 é o mais prioritário)" class="form__input item" />
                        </div>

                    </div>
                    <div class="form__group">
                        <div class="form_label">Nome  de acesso </div>
                        <div class="form_item">
                            <input    type="text" name="nickname" placeholder="nickname" class="form__input item" />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Senha de acesso  </div>
                        <div class="form_item">
                            <input    type="password" name="pass" placeholder="senha" class="form__input  item" />
                        </div>
                    </div>
                    <div class="form__group">
                        <div class="form_label">Confirmação da senha de acesso </div>
                        <div class="form_item">
                            <input    type="password" name="pass" placeholder="confirmar senha" class="form__input item" />
                        </div>
                    </div>
                    <input type="hidden" name="pwhat" value="insert">
                </form>
                <button class="btn-1" onclick="event.preventDefault()" type="button">Register</button>

            </div>
        </div>        
    </body>
</html>
<%} else {
        out.print("Usuario não está logado");
    }%>