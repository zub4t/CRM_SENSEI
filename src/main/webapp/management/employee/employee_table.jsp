<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="menu.services.MenuServices"%>
<%@page import="management.employee.services.EmployeeServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    EmployeeServices employee = new EmployeeServices();
    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    employee.setEmployee(request, response, n);
    MenuServices menu_1 = new MenuServices();

%>

<table id="table_employee" cellspacing="0">
    <tr>
        <td>Nome</td>
        <td>Email</td>  
        <td>Telefone</td>
        <td>Editar</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${employeeList}" var="item"   varStatus="loop">
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
            <% if (menu_1.isVisible(request, 1)) { %>
            <td onclick="goToEmployeeId(${item.id})">
                <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td onclick="removeEmployee(${item.id})">
                <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>