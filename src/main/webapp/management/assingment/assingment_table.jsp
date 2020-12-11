<%-- 
    Document   : project_table
    Created on : 8/dez/2020, 16:10:02
    Author     : marco
--%>
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
%>
<table id="table_assingment" cellspacing="0">
    <tr>
        <td>Descrição Do Tarefa</td>
        <td>Remover</td>
    </tr>
    <c:forEach items="${assingmentList}" var="item"   varStatus="loop">
        <tr>
            <td>
                ${item.getDsc()}
            </td>
            <td onclick="removeAssingment(${item.id})">
                <img style="cursor:pointer" src="https://cdn4.iconfinder.com/data/icons/interface-2/100/14-512.png" width="35px"/>
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