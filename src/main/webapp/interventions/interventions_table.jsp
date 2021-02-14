<%@page import="menu.services.MenuServices"%>
<%@page import="interventions.services.InterventionsServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="management.project.services.ProjectServices"%>
<%
    InterventionsServices interventions = new InterventionsServices();

    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    interventions.setInterventions(request, response, n);
    MenuServices menu_1= new MenuServices();

%>
<table id="table_interventions" cellspacing="0">
    <tr>
        <td>Projeto</td>
        <td>Funcionario</td>
        <td>Tarefa</td>
        <td>Tempo Gasto</td>
        <td>Descrição</td>
        <td>Editar</td>
        <td>Remover</td>

    </tr>
    <c:forEach items="${interventionList}" var="item"   varStatus="loop">
        <tr>
            <td>
                ${item.prj_nme}
            </td>

            <td>
                ${item.employee_nme}
            </td>  

            <td>
                ${item.assingment_nme}
            </td> 

            <td>
                ${item.getSpeend_time()}
            </td>

            <td>
                ${item.getDsc()}
            </td>      
            <% if (menu_1.isVisible(request, 11)) { %>
            <td onclick="goToInterventionId(${item.id})">

                <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
            </td>
            <%}%>
            <% if (menu_1.isVisible(request, 11)) { %>
            <td onclick="removeIntervention(${item.id})">
                <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
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