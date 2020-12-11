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

<table id="table_menu" cellspacing="0">
    <tr>
        <td>Nome</td>
        <td>Nivel</td>  
        <td>Editar</td>
    </tr>
    <c:forEach items="${menuList}" var="item"   varStatus="loop">
        <tr>
            <td>
                ${item.nme}
            </td>


            <td>
                ${item.userLevel}

            </td>
            <td onclick="goToMenuId(${item.id})">
                <img style="cursor:pointer" src="https://img1.gratispng.com/20180920/eqx/kisspng-computer-icons-editing-portable-network-graphics-i-edit-profile-svg-png-icon-free-download-194863-5ba3457963b929.9651381015374268094085.jpg" width="20px"/>
            </td>
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