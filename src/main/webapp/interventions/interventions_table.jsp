<%@page import="menu.services.MenuServices"%>
<%@page import="interventions.services.InterventionsServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="management.project.services.ProjectServices"%>
<%
    InterventionsServices inter = new InterventionsServices();

    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    inter.setInterventions(request, response, n);
    MenuServices menu_1 = new MenuServices();

%>
<table id="table" cellspacing="0">
    <tr>
        <td class="">Projeto</td>
        <td class="">Funcionario</td>
        <td class="">Tarefa</td>
        <td class="">Tempo Gasto</td>
        <td class="" >Descrição</td>
        <td >Editar</td>
        <td>Remover</td>

    </tr>
    <c:forEach items="${interventionList}" var="item"   varStatus="loop">
        <tr>
            <td class="td_left ">
                ${item.prj_nme} | ${item.customer}
            </td>

            <td class="td_left">
                ${item.employee_nme}
            </td>  

            <td class="td_left">
                ${item.assingment_nme}
            </td> 

            <td class="td_left">
                ${item.getSpeend_time()}
            </td>

            <td class="td_left dots3">
                ${item.getDsc()}
            </td>      
            <% if (menu_1.isVisible(request, 11)) { %>
            <td >

                <img onclick="goToInterventionId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
            </td>
            <%}%>
            <% if (menu_1.isVisible(request, 11)) { %>
            <td >
                <img onclick="removeIntervention(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/cancel.png" width="12px"/>
            </td>
            <%}%>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            <div>
                <%@include file="../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>