<%-- 
    Document   : project_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.project.services.ProjectServices"%>
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
            ProjectServices project = new ProjectServices();
            project.setListOfAllPrj(request, response);
        %>
        <script src="/CRM_SENSEI/management/project/project.js"></script>
        <link href="/CRM_SENSEI/management/project/project.css" rel="stylesheet"/>

    </head>
    <body>
        <form id="goToProject" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="projectId" value="">
        </form>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <span class="plusButton" onclick="window.location.href = '/CRM_SENSEI/management/project/project_nar.jsp'"><img  src="https://cdn3.iconfinder.com/data/icons/ui-thick-outline-1-of-5/100/ui_01_of_9-02-512.png" width="20px"/></span>

            <div class="table_header"></div>
            <table id="table_project" cellspacing="0">
                <tr>
                    <td>Número do Processo</td>
                    <td>Nome do Cliente</td>
                    <td>Venda Esperada</td>  
                    <td>Venda Efetiva</td>
                    <td>Compra Efetiva</td>
                    <td>Editar</td>
                    <td>Remover</td>
                </tr>
                <c:forEach items="${list_prj}" var="item"   varStatus="loop">
                    <tr>
                        <td>
                            ${item.getN_process()}
                        </td>
                        <td>
                            ${item.getCustomer_nme()}
                        </td>


                        <td>
                            ${item.getExpected_sale()}

                        </td>


                        <td>
                            ${item.getEffective_sale()}

                        </td>
                        <td>
                            ${item.getEffective_purchase()}

                        </td>
                        <td onclick="goToProjectId(${item.id})">
                            <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
                        </td>
                        <td onclick="removeProject(${item.id})">
                            <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
