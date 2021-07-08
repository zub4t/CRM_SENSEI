<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="management.client.service.ClientService"%>
<%@page import="menu.services.MenuServices"%>
<%@page import="management.employee.services.EmployeeServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ClientService clientService = new ClientService();
    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    clientService.setClient(request, response, n);
    MenuServices menu_1 = new MenuServices();

%>

<div class="label-table-content">
    <div class="label-table" style="width: 15%">Nome do client:</div>
    <div class="label-table" style="width: 15%">E-mail:</div>  
    <div class="label-table"style=" width: 10%">Telefone:</div>
    <div class="label-table" style="width: 10%">Nº de Contribuinte:</div>

    <div class="label-table" style="width: 10%">Localidade:</div> 
    <div class="label-table" style="width: 30%">Endereço:</div> 

    <div class="label-table" style="width: 5%">Editar:</div>
    <div class="label-table" style="width: 5%">Remover:</div>
</div>




<c:forEach items="${clientList}" var="item"   varStatus="loop">
    <div class="values-table-content">
        <div class=""style="width: 15%">
            ${item.getName()}
        </div>

        <div class="" style="width: 15%">
            ${item.getEmail()}
        </div>
        <div class="" style="width: 10%">
            ${item.getTel()}

        </div>
        <div class="" style="width: 10%">
            ${item.getNum_contribuinte()}

        </div>
        <div class=""style="width: 10%">
            ${item.getLocation()}

        </div>
        <div class="" style="width: 30%">
            ${item.getAddress()}

        </div>
        <% if (menu_1.isVisible(request, 1)) { %>
        <div style="width: 5%" >
            <img onclick="goToEmployeeId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
        </div>
        <%} else {%>
        <div></div>
        <%}%>
        <% if (menu_1.isVisible(request, 1)) { %>
        <div style="width: 5%">
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
