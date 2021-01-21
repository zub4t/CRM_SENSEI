
<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="management.project.services.ProjectServices"%>
<%
    ProjectServices project = new ProjectServices();
    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    project.setProjects(request, response, n);
%>
<table id="table_project" cellspacing="0">
    <tr>
        <td>Número do Processo</td>
        <td>Nome do Cliente</td>
        <td>Venda Esperada</td>  
        <td>Venda Efetiva</td>
        <td>Compra Efetiva</td>
        <td>Editar</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${projectList}" var="item"   varStatus="loop">
        <tr>
            <td>
                ${item.getN_process()}
            </td>
            <td>
                ${item.getCustomer_nme()}
            </td>


            <td>
                ${item.getExpected_sale()}

            </td>


            <td>
                ${item.getEffective_sale()}

            </td>
            <td>
                ${item.getEffective_purchase()}

            </td>
            <td onclick="goToProjectId(${item.id})">
                <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
            </td>
            <td onclick="removeProject(${item.id})">
                <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
            </td>
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
