<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
<%@page import="menu.services.MenuServices"%>
<%@page import="management.assingment.services.AssingmentServices"%>
<%@page import="util.PaginationModel"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    AssingmentServices assingment = new AssingmentServices();

    int n = 0;
    if (request.getAttribute("ppage") != null) {
        n = (Integer) request.getAttribute("ppage");
    }
    assingment.setAssingment(request, response, n);
    MenuServices menu_1 = new MenuServices();

%>
<script>
    $(function () {
        $("#sortable").sortable();
        $("#sortable").disableSelection();
    });
</script>
<div id="table" cellspacing="0">
    <div class="label-table-content">
        <div class="col">Descrição Do Tarefa:</div>
        <div class="col">Remover:</div>
    </div>
    <div id="sortable">
        <c:forEach items="${assingmentList}" var="item"   varStatus="loop">
            <div class="values-table-content" task="${item.id}">
                <div class="col">
                    ${item.getDsc()}
                </div>
                <% if (menu_1.isVisible(request, 1)) {%>
                <div onclick="removeAssingment(${item.id})" class="col">

                <img style="cursor:pointer" src="/CRM_SENSEI/resources/cancel.png" width="12px"/>

                </div>
                <%}%>
            </div>
        </c:forEach>
    </div>
    <div  class="row" style="display: flex;justify-content: center;">
        <div >
            <div>
                <%@include file="../../pagination/pagination.jsp" %>
            </div>
        </div>
    </div>
</div>