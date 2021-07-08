
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

<div class="label-table-content">
    <div class="" style="width: 30%">Projeto:</div>
    <div class="" style="width: 30%">Nome do Cliente:</div>
    <div class="" style="width: 10%">Venda Esperada:</div>  
    <div class="" style="width: 10%">Venda Efetiva:</div>
    <div class="" style="width: 10%">Compra Efetiva:</div>
    <div style="width: 5%">Editar:</div>
    <div style="width: 5%">Remover:</div>    
</div>



    <c:forEach items="${projectList}" var="item"   varStatus="loop">
       <div class="values-table-content">
           <div class="" style="width: 30%">
                ${item.getN_process()} |  ${item.getCustomer_nme()}
            </div>
            <div class="" style="width: 30%">
                ${item.getCustomer_nme()}
            </div>

            <div class="" style="width: 10%">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>
                <fmt:formatNumber value="${item.getExpected_sale()}" type="currency"/>
                <%}%>
            </div>

            <div class="" style="width: 10%">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>

                <fmt:formatNumber value="${item.getEffective_sale()}" type="currency"/>
                <%}%>
            </div>
            <div class="" style="width: 10%">
                <%if (employeeRepository.getUserLevelById(Integer.parseInt(session.getAttribute("userId").toString())) < 2) {%>

                <fmt:formatNumber value="${item.getEffective_purchase()}" type="currency"/>

                <%}%>
            </div>
            <% if (menu_1.isVisible(request, 1)) { %>
            <div style="width: 5%">
                <img onclick="goToProjectId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
            </div>
            <%} else {%>
            <div></div>
            <%}%>
            <% if (menu_1.isVisible(request, 1)) { %>
            <div style="width: 5%" >
                <img onclick="removeProject(${item.id})" style ="cursor:pointer" src="/CRM_SENSEI/resources/cancel.png" width="12px"/>
            </div>
            <%} else {%>
            <div></div>
            <%}%>
        </div>
    </c:forEach>
<table width="100%">
    <tr>
        <td colspan="7">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>
