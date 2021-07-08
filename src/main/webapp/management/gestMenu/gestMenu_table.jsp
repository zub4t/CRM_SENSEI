<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="menu.services.MenuServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    MenuServices menu = new MenuServices();
    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    menu.setMenu(request, response, n);

%>
<div class="label-table-content">
    <div style="width: 32%" class="td_left">Nome:</div>
    <div style="width: 32%" class="td_left">Nivel:</div>  
    <div style="width: 32%">Editar:</div>
</div>


<c:forEach items="${menuList}" var="item"   varStatus="loop">
    <div class="values-table-content">
        <div style="width: 32%">
            ${item.nme}
        </div>


        <div style="width: 32%">
            ${item.userLevel}

        </div>
        <% if (menu.isVisible(request, 1)) { %>
        <div style="width: 32%" >

            <img onclick="goToMenuId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
        </div >
        <%} else {%>
        <div></div>
        <%}%>
    </div>
</c:forEach>
<table  cellspacing="0" width="100%">
    <tr>
        <td colspan="5">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>