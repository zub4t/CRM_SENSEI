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

<div class="label-table-content">
    <div class="label-table" style="width: 20%">Nome do funcionário:</div>
    <div class="label-table" style="width: 20%">Tipo:</div> 
    <div class="label-table" style="width: 20%" >E-mail:</div>  
    <div class="label-table"style="width: 20%" >Telefone:</div>
    <div class="label-table"style="width: 10%">Editar:</div>
    <div class="label-table"style="width: 10%">Remover:</div>
</div>




<c:forEach items="${employeeList}" var="item"   varStatus="loop">
    <div class="values-table-content">
        <div class="" style="width: 20%">
            ${item.getNme()}
        </div>
        <div class="" style="width: 20%">
            ${item.getUserLevel() == 0 ? "Administrador": item.getUserLevel() == 1 ? "Gestor" :"Funcionário"}
        </div>
        <div class="" style="width: 20%">
            ${item.getEmail()}
        </div>
        <div class="" style="width: 20%">
            ${item.getTel()}

        </div>
        <% if (menu_1.isVisible(request, 1)) { %>
        <div style="width: 10%" >
            <img onclick="goToEmployeeId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
        </div>
        <%} else {%>
        <div></div>
        <%}%>
        <% if (menu_1.isVisible(request, 1)) { %>
        <div style="width: 10%">
            <img onclick="removeEmployee(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/cancel.png" width="12px"/>
        </div>
        <%} else {%>
        <div></div>
        <%}%>
    </div>
</c:forEach>
<table width="100%">
    <tr>
        <td colspan="5">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>
