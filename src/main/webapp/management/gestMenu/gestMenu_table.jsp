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

<table id="table" cellspacing="0">
    <tr>
        <td class="td_left">Nome</td>
        <td class="td_left">Nivel</td>  
        <td >Editar</td>
    </tr>
    <c:forEach items="${menuList}" var="item"   varStatus="loop">
        <tr>
            <td>
                ${item.nme}
            </td>


            <td>
                ${item.userLevel}

            </td>
            <% if (menu.isVisible(request, 1)) { %>
            <td >

                <img onclick="goToMenuId(${item.id})" style="cursor:pointer" src="/CRM_SENSEI/resources/editar-arquivo.png" width="16px"/>
            </td>
            <%} else {%>
            <td></td>
            <%}%>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </td>
    </tr>
</table>