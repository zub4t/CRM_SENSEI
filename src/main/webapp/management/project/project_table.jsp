
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

%>
<fmt:setLocale value="es_ES"/>
<table id="table" cellspacing="0">
    <tr>
        <td class="td_left">Número do Processo</td>
        <td class="td_left">Nome do Cliente</td>
        <td class="td_left">Venda Esperada</td>  
        <td class="td_left">Venda Efetiva</td>
        <td class="td_left">Compra Efetiva</td>
        <td>Editar</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${projectList}" var="item"   varStatus="loop">
        <tr>
            <td class="td_left">
                ${item.getN_process()}
            </td>
            <td class="td_left">
                ${item.getCustomer_nme()}
            </td>

            <td class="td_left">

                <fmt:formatNumber value="${item.getExpected_sale()}" type="currency"/>
            </td>

            <td class="td_left">

                <fmt:formatNumber value="${item.getEffective_sale()}" type="currency"/>

            </td>
            <td class="td_left">
                <fmt:formatNumber value="${item.getEffective_purchase()}" type="currency"/>


            </td>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td onclick="goToProjectId(${item.id})">
                <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
            <% if (menu_1.isVisible(request, 1)) { %>
            <td onclick="removeProject(${item.id})">
                <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
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
