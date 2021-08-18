<%-- 
    Document   : employee_nar
    Created on : 19/nov/2020, 10:48:28
    Author     : marco
--%>
<%@page import="management.assingment.model.AssingmentModel"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="menu.services.MenuServices"%>
<%@page pageEncoding="UTF-8"%>

<%
    AssingmentModel model = (AssingmentModel) request.getAttribute("assignment");
%>

<div class="">
    <div class="form">
        <form class="formnar">
            <div class="form__group">
                <div class="form_label">Descrição da Tarefa:</div>

                <div class="form_item">
                    <input  type="text" value="<%= model != null ? model.getDsc() : ""%>" name="dsc" placeholder="Descrição da Tarefa" class="form__input  item" />
                </div>
            </div>
            <div class="form__group">
                <div class="form_label">Cor da Tarefa:</div>

                <div class="form_item">
                    <input type="color" class="form__input  item"  name="color" value="<%=model != null ? model.getColor() : "#BCD9D7"%>">
                </div>
            </div>
        </form>
        <%if (model == null) {%>
        <input class="btn-1" onclick="event.preventDefault();save()" value ="Gravar Tarefa" type="button">
        <%} else {%>
        <input type="hidden" value="<%=model.getId()%>">
        <input class="btn-1" onclick="event.preventDefault();update('<%=model.getId()%>')" value ="Editar Tarefa" type="button">

        <%}%>
    </div>
</div>        
