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
        <base href="/CRM_SENSEI">
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
        <form id="goToEmployee" method="GET" action="">
            <input type="hidden" name="pwhat" value="edit">
            <input type="hidden" name="empId" value="">
        </form>
        <%@include file="../../menu/menu.jsp" %>
        <div id="table_container">
            <span><img class="plusIcon" src="https://www.pinclipart.com/picdir/middle/185-1852252_plus-icon-free-png-and-svg-download-iphone.png" width="20px"/></span>
            <div class="table_header"></div>
            <table id="table_employee" cellspacing="0">
                <tr>
                    <td>Nome</td>
                    <td>Email</td>  
                    <td>Telefone</td>
                    <td>Editar</td>
                    <td>Remover</td>
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
                        <td onclick="goToEmployeeId(${item.id})">
                            <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
                        </td>
                        <td onclick="removeEmployee(${item.id})">
                            <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <div class="table_footer"></div>

        </div>
    </body>
</html>
