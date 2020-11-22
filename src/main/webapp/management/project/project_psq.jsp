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
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <div class="table_header"></div>
            <table id="table_project" cellspacing="0">
                <tr>
                    <td>Número do Processo</td>
                    <td>Nome do Cliente</td>
                    <td>Venda Esperada</td>  
                    <td>Venda Efetiva</td>
                    <td>Compra Efetiva</td>

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
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
