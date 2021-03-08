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

<table id="table" cellspacing="0">
    <tr>
        <td class="" >Nome</td>
        <td class="">Email</td>  
        <td class="">Telefone</td>
        <td>Editar</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${employeeList}" var="item"   varStatus="loop">
        <tr>
            <td class="td_left">
                ${item.getNme()}
            </td>
            <td class="td_left">
                ${item.getEmail()}
            </td>
            <td class="td_left">
                ${item.getTel()}

            </td>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td >
                <img onclick="goToEmployeeId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI_EXTERNAL/resources/editar-arquivo.png" width="16px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td >
                <img onclick="removeEmployee(${item.id})" style="cursor:pointer" src="/CRM_SENSEI_EXTERNAL/resources/cancel.png" width="12px"/>
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