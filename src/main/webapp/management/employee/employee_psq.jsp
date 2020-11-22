<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.employee.services.EmployeeServices"%>
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
            EmployeeServices employee = new EmployeeServices();
            employee.setListOfAllEmployes(request, response);
        %>
        <script src="/CRM_SENSEI/management/employee/employee.js"></script>
        <link href="/CRM_SENSEI/management/employee/employee.css" rel="stylesheet"/>

    </head>
    <body>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <div class="table_header"></div>
            <table id="table_employee" cellspacing="0">
                <tr>
                    <td>Nome</td>
                    <td>Email</td>  
                    <td>Telefone</td>
                </tr>
                <c:forEach items="${list}" var="item"   varStatus="loop">
                    <tr>
                        <td>
                            ${item.getNme()}
                        </td>


                        <td>
                            ${item.getEmail()}

                        </td>


                        <td>
                            ${item.getTel()}

                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
