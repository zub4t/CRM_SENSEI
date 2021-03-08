
<%@page import="management.employee.repository.EmployeeRepository"%>
<%@page import="menu.services.MenuServices"%>
<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<%@page import="management.project.services.ProjectServices"%>
<%
    ProjectServices project = new ProjectServices();
    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    project.setProjects(request, response, n);
    MenuServices menu_1 = new MenuServices();
    EmployeeRepository employeeRepository = new EmployeeRepository();

%>
<fmt:setLocale value="es_ES"/>
<table id="table" cellspacing="0">
    <tr>
        <td class="">Projeto</td>
        <td class="">Nome do Cliente</td>
        <td class="">Venda Esperada</td>  
        <td class="">Venda Efetiva</td>
        <td class="">Compra Efetiva</td>
        <td>Editar</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${projectList}" var="item"   varStatus="loop">
        <tr>
            <td class="td_left">
                ${item.getN_process()} |  ${item.getCustomer_nme()}
            </td>
            <td class="td_left">
                ${item.getCustomer_nme()}
            </td>

            <td class="td_left">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>
                <fmt:formatNumber value="${item.getExpected_sale()}" type="currency"/>
                <%}%>
            </td>

            <td class="td_left">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>

                <fmt:formatNumber value="${item.getEffective_sale()}" type="currency"/>
                <%}%>
            </td>
            <td class="td_left">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>

                <fmt:formatNumber value="${item.getEffective_purchase()}" type="currency"/>

                <%}%>
            </td>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td >
                <img onclick="goToProjectId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI_EXTERNAL/resources/editar-arquivo.png" width="16px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td >
                <img onclick="removeProject(${item.id})" style ="cursor:pointer" src="/CRM_SENSEI_EXTERNAL/resources/cancel.png" width="12px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="7">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>
