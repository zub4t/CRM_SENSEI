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
<div  class="label-table-content">
    <div class="" style="width: 25%">Projeto:</div>
    <div class="" style="width: 5%">Func.:</div>
    <div class="" style="width: 20%">Tarefa:</div>
    <div class="" style="width: 5%">Tempo:</div>
    <div class="" style="width: 30%">Descrição:</div>
    <div style="width: 5%">Editar:</div>
    <div style="width: 5%">Remover:</div>

</div>

<c:forEach items="${interventionList}" var="item"   varStatus="loop">
    <div class="values-table-content">
        <div class="td_left dots3 " style="width: 25%">
         ${item.customer}
        </div>

        <div class="td_left dots3" style="width: 5%">
            ${item.employee_nme}
        </div>  

        <div class="td_left dots3" style="width: 20%">
            ${item.assingment_nme}
        </div> 

        <div class="td_left dots3" style="width: 5%">
            ${item.getSpeend_time()}
        </div>

        <div class="td_left dots3" style="width: 30%">
            ${item.getDsc()}
        </div>      
        <% if (menu_1.isVisible(request, 11)) { %>
        <div  style="width: 5%;text-align: center">

            <img onclick="goToInterventionId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
        </div>
        <%}%>
        <% if (menu_1.isVisible(request, 11)) { %>
        <div style="width: 5%; text-align: center">
            <img onclick="removeIntervention(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/cancel.png" width="12px"/>
        </div>
        <%}%>
    </div>
</c:forEach>
<table id="table" width="100%" cellspacing="0">

    <tr>
        <td colspan="7">
            <div>
                <%@include file="../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>