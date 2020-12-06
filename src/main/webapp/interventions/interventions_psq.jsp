<%-- 
    Document   : assingment_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="interventions.services.InterventionsServices"%>
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
            InterventionsServices assingment = new InterventionsServices();
            assingment.setListOfAllInterventions(request, response);
        %>
        <script src="/CRM_SENSEI/interventions/interventions.js"></script>
        <link href="/CRM_SENSEI/interventions/interventions.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <div class="table_header"></div>
            <table id="table_assingment" cellspacing="0">
                <tr>
                    <td>Projeto</td>
                    <td>Funcionario</td>
                    <td>Tarefa</td>
                    <td>Tempo Gasto</td>
                    <td>Descrição</td>

                </tr>
                <c:forEach items="${list_interventions}" var="item"   varStatus="loop">
                    <tr>
                        <td>
                            ${item.prj_nme}
                        </td>

                        <td>
                            ${item.employee_nme}
                        </td>  

                        <td>
                            ${item.assingment_nme}
                        </td> 

                        <td>
                            ${item.getSpeend_time()}
                        </td>

                        <td>
                            ${item.getDsc()}
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>