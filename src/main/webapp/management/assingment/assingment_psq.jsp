<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
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
        %>
        <script src="/CRM_SENSEI/management/assingment/assingment.js"></script>
        <link href="/CRM_SENSEI/management/assingment/assingment.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>
        <form id="formId" method="GET" action="">
            <input type="hidden" name="pwhat" value="">
            <input type="hidden" name="id" value="">
        </form>
        <div id="table_container">
            <span class="plusButton" onclick="window.location.href = '/CRM_SENSEI/management/assingment/assingment_nar.jsp'"><img  src="https://cdn3.iconfinder.com/data/icons/ui-thick-outline-1-of-5/100/ui_01_of_9-02-512.png" width="20px"/></span>

            <div class="table_header"></div>
            <table id="table_assingment" cellspacing="0">
                <tr>
                    <td>Descrição Do Tarefa</td>
                    <td>Remover</td>
                </tr>
                <c:forEach items="${list_assng}" var="item"   varStatus="loop">
                    <tr>
                        <td>
                            ${item.getDsc()}
                        </td>
                        <td onclick="removeAssingment(${item.id})">
                            <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
